package com.nagarro.flightsearch.model;

import java.time.LocalDate;

/**
 * 
 * @author nishantgarg
 *
 */
public class UserFlightDetail {

	private String arrLoc;
	private String depLoc;
	private char flightClass;
	private String outputPrefrence;
	private LocalDate flightDate;

	/**
	 * @param arr_loc
	 * @param dep_loc
	 * @param flight_class
	 * @param output_prefrence
	 * @param vaild_till
	 */
	public UserFlightDetail(String arr_loc, String dep_loc, char flight_class, String output_prefrence,
			LocalDate flight_date) {
		this.arrLoc = arr_loc;
		this.depLoc = dep_loc;
		this.flightClass = flight_class;
		this.outputPrefrence = output_prefrence;
		this.flightDate = flight_date;
	}

	/**
	 * 
	 */
	public UserFlightDetail() {

	}

	/**
	 * @return the arr_loc
	 */
	public String getArrLoc() {
		return arrLoc;
	}

	/**
	 * @return the dep_loc
	 */
	public String getDepLoc() {
		return depLoc;
	}

	/**
	 * @return the flight_class
	 */
	public char getFlightClass() {
		return flightClass;
	}

	/**
	 * @return the output_prefrence
	 */
	public String getOutputPrefrence() {
		return outputPrefrence;
	}

	/**
	 * @return the vaild_till
	 */
	public LocalDate getFlightDate() {
		return flightDate;
	}

	/**
	 * @param arr_loc
	 *            the arr_loc to set
	 */
	public void setArrLoc(String arr_loc) {
		this.arrLoc = arr_loc;
	}

	/**
	 * @param dep_loc
	 *            the dep_loc to set
	 */
	public void setDepLoc(String dep_loc) {
		this.depLoc = dep_loc;
	}

	/**
	 * @param flight_class
	 *            the flight_class to set
	 */
	public void setFlightClass(char flight_class) {
		this.flightClass = flight_class;
	}

	/**
	 * @param output_prefrence
	 *            the output_prefrence to set
	 */
	public void setOutputPrefrence(String output_prefrence) {
		this.outputPrefrence = output_prefrence;
	}

	/**
	 * @param vaild_till
	 *            the vaild_till to set
	 */
	public void setFlightDate(LocalDate flight_date) {
		this.flightDate = flight_date;
	}
/**
 * This will check the data is valid or not
 * @return {@link Boolean}
 */
	public boolean isvalid() {
		if(this.arrLoc.length()!=3 || this.depLoc.length()!=3)return false;
		if(this.arrLoc.contains(" ") || this.depLoc.contains(" "))return false;
		
		return true;
	}
}
