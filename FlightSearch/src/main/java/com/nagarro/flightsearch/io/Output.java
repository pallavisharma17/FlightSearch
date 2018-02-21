package com.nagarro.flightsearch.io;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.UserFlightDetail;

/**
 * Print the output for given condition
 * 
 * @author nishantgarg
 *
 */
public class Output {

	/**
	 * Show the output of the file
	 * 
	 * @param fligts
	 * @param userFlightDetail
	 */
	public void showOutput(List<Flight> fligts, UserFlightDetail userFlightDetail) {
		List<Flight> outputFlight = new LinkedList<>();
		for (int i = 0; i < fligts.size(); i++) {
			if (userFlightDetail.getFlightDate().isBefore(fligts.get(i).getVaildTill())
					&& fligts.get(i).getSeatAvailability() == 'Y'
					&& fligts.get(i).getFlightClass().contains(userFlightDetail.getFlightClass() + "")) {
				double price = 0;
				if (userFlightDetail.getFlightClass() == 'B') {

					price = fligts.get(i).getFare() * 1.4;
				}
				outputFlight.add(fligts.get(i));
			}
		}
		// check if the size is 0 or not
		if (outputFlight.size() == 0) {
			System.err.println("No such flight is available on the given date");
			return;
		}

		// if getOutput_prefrence of userFlight is according to fare
		if (userFlightDetail.getOutputPrefrence().equals("fare")) {
			outputFlight.sort((o1, o2) -> o1.getFare() > o2.getFare() ? 1 : -1);
		}
		// if getOutput_prefrence of userFlight is according to both fare and flight
		// duration
		if (userFlightDetail.getOutputPrefrence().equals("both")) {
			outputFlight.sort(new Comparator<Flight>() {

				@Override
				public int compare(Flight o1, Flight o2) {

					if (o1.getFare() > o2.getFare())
						return 1;
					if (o1.getFare() < o2.getFare())
						return -1;

					return o1.getFlightDur() > o2.getFlightDur() ? 1 : -1;
				}
			});
		}
		for (int i = 0; i < outputFlight.size(); i++) {
			outputFlight.get(i).display();
		}

	}

}
