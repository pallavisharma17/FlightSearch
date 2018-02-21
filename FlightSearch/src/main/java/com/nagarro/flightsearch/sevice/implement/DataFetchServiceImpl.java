package com.nagarro.flightsearch.sevice.implement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.sevice.DataFetchServices;

/**
 * This class will fetch the data for given services
 * 
 * @author nishantgarg
 *
 */
public class DataFetchServiceImpl implements DataFetchServices {

	@Override
	public void fetchDataFromAllFiles(List<String> listOfFiles, Map<String, List<Flight>> data)
			throws NumberFormatException, IOException {
		for (int i = 0; i < listOfFiles.size(); i++) {
			String csvFile = listOfFiles.get(i);

			String line = "";
			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
				int lineNumber = 0;
				while ((line = br.readLine()) != null) {
					if (lineNumber++ == 0) {
						continue;
					}
					String[] flight = line.split(Pattern.quote("|"));
					String key = flight[1] + flight[2];
					if (data.get(key) == null) {
						data.put(key, new LinkedList<Flight>());
					}
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					data.get(key)
							.add(new Flight(flight[2], flight[1], Double.parseDouble(flight[6]), flight[8],
									Double.parseDouble(flight[5]), flight[4], flight[0], flight[7].charAt(0),
									LocalDate.parse(flight[3], formatter)));
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<String> getListOfFilesPath(String path) {
		// create list that hast to return;
		List<String> filePathList = new ArrayList<String>();
		File file = new File(path);
		// get all the files in array of the given path
		File[] files = file.listFiles();
		for (File f : files) {
			filePathList.add(f.getAbsolutePath());// add all the the filePath in fileList and return it
		}
		return filePathList;

	}

}
