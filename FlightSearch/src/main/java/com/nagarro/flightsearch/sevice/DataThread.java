package com.nagarro.flightsearch.sevice;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.sevice.implement.DataFetchServiceImpl;

public class DataThread extends Thread {
	
	DataFetchServices dataFetchServices = new DataFetchServiceImpl();
	public void dataThread(HashMap<String, List<Flight>> data, List<String> files,String pathOfDataSource) throws NumberFormatException, IOException {
		files = dataFetchServices.getListOfFilesPath(pathOfDataSource);
		dataFetchServices.fetchDataFromAllFiles(files, data);
	}
}
