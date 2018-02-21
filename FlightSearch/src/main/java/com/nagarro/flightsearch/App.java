package com.nagarro.flightsearch;

import java.io.IOException;
import java.sql.Time;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.nagarro.flightsearch.io.Input;
import com.nagarro.flightsearch.io.Output;
import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.UserFlightDetail;
import com.nagarro.flightsearch.sevice.DataFetchServices;
import com.nagarro.flightsearch.sevice.DataThread;
import com.nagarro.flightsearch.sevice.implement.DataFetchServiceImpl;

/**
 * 
 * @author nishantgarg
 *
 */
public class App {

	public static String pathOfDataSource = "";

	/**
	 * Main method to excecute
	 * 
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scan = new Scanner(System.in);
		UserFlightDetail userFlightDetail = new UserFlightDetail();

		System.out.println("enter the source Path of folder");
		pathOfDataSource = scan.nextLine();
		
		Output output = new Output();
		Input input = new Input();
		

		// fetch data from all the files and store them in hashmap named data

		List<String> files = new LinkedList<>();
		HashMap<String, List<Flight>> data = new HashMap<String, List<Flight>>();

		// data has been initialize
		while(!initalizeData(files, data, pathOfDataSource)) {
			System.err.println("enter correct path");
			pathOfDataSource=scan.nextLine();
		}

		// thread has been created and re-run for every time interval
		ThreadOperation threadOperation = new ThreadOperation();
		threadOperation.threadOperation(files, data, pathOfDataSource);

		// taking input from user
		for (int i = 0; i < 3; i++) {
			// System.out.println(data.get("DELMUB").size());
			if (input.getInput(userFlightDetail, scan)) {
				if (userFlightDetail.isvalid()) {
					String key = userFlightDetail.getDepLoc() + userFlightDetail.getArrLoc();
					if (data.containsKey(key)) {
						output.showOutput(data.get(key), userFlightDetail);
					} else {
						System.err.println("there is no flight for the given data");
					}

				} else {
					System.err.println("enter Correct date");
				}
			} else {
				System.err.println("please enter correct Data");
			}
		}
	}

	/**
	 * 
	 * @param files
	 * @param data
	 * @param pathOfDataSource
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static boolean initalizeData(List<String> files, HashMap<String, List<Flight>> data, String pathOfDataSource)
			throws NumberFormatException, IOException {

		try {
		DataFetchServices dataFetchServices = new DataFetchServiceImpl();
		dataFetchServices.getListOfFilesPath(pathOfDataSource);
		dataFetchServices.fetchDataFromAllFiles(files, data);
		}catch(Exception e) {
			System.err.println("enter correct Path");
			return false;
		}
		return true;
	}

}

/**
 * This class handle the thread
 * @author nishantgarg
 *
 */
class ThreadOperation {
	/**
	 * This method create the create the thread and run the thread for a perticular timeperiod
	 * @param files
	 * @param data
	 * @param pathOfDataSource
	 */
	public static void threadOperation(List<String> files, HashMap<String, List<Flight>> data,
			String pathOfDataSource) {
		DataThread dataThread = new DataThread();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					dataThread.dataThread(data, files, pathOfDataSource);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// task to run goes here
				data.clear();
				files.clear();
				t1.run();
			}
		};

		Timer timer = new Timer();
		long delay = 0;
		long intevalPeriod = 5 * 1000;
		// schedules the task to be run in an interval
		timer.scheduleAtFixedRate(task, delay, intevalPeriod);
	}
}
