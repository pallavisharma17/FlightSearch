package com.nagarro.flightsearch.io;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.nagarro.flightsearch.model.UserFlightDetail;

/**
 * Take the input from user
 * 
 * @author nishantgarg
 *
 */
public class Input {
	/**
	 * Take the userFlight input and return the boolean value
	 * 
	 * @param userFlight
	 * @param scan
	 * @return {@link Boolean}
	 */
	public boolean getInput(UserFlightDetail userFlight, Scanner scan) {

		System.out.println("enter department Location");
		userFlight.setDepLoc(scan.next());

		System.out.println("Enter Arrival Location ");
		userFlight.setArrLoc(scan.next());

		System.out.println("Enter Flight Date in this format dd-MM-yyyy");
		DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {
			userFlight.setFlightDate(LocalDate.parse(scan.next(), formatter_1));
		} catch (Exception e) {
			return false;
		}

		System.out.println("Enter Flight class");
		String temp = scan.next();
		if (temp.length() > 1)
			return false;
		userFlight.setFlightClass(temp.charAt(0));

		System.out.println("enter the output prefrence i.e. sorted by fare or by both  fare and flight duration.");
		System.out.println("So enter Fare or Both");
		temp = scan.next().toLowerCase();
		if (!temp.equals("both") && !temp.equals("fare"))
			return false;
		userFlight.setOutputPrefrence(temp);

		return true;

	}
}
