package com.nagarro.flightsearch.sevice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.nagarro.flightsearch.model.Flight;

public interface DataFetchServices {
	/**
	 * This will fetch the data of all the listed file and store it in hashmap
	 * 
	 * @param listOfFiles
	 * @param data
	 * @throws NumberFormatException
	 * @throws IOException
	 * @return {@link Void}
	 */
	public void fetchDataFromAllFiles(List<String> listOfFiles, Map<String, List<Flight>> data)
			throws NumberFormatException, IOException;

	/**
	 * This will return the list of filesPath present in the source folder
	 * 
	 * @param path
	 *            {@link String}
	 * @return {@link List <{@link String}>
	 */
	public List<String> getListOfFilesPath(String path);
}
