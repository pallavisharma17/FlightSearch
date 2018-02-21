package com.nagarro.flightsearch.model;

import java.time.LocalDate;

public class Flight {
	private String arrLoc;
	private String depLoc;
	private double fare;
	private String flightClass;
	private double flightDur;
	private String flightTime;
	private String flightNo;
	private char seatAvailability;
	private LocalDate vaildTill;

	/**
	 * 
	 * @param arr_loc
	 * @param dep_loc
	 * @param fare
	 * @param flight_class
	 * @param flight_dur
	 * @param flight_time
	 * @param flight_no
	 * @param seat_availability
	 * @param vaild_till
	 */
	
	/**
	 * This will display the flight details
	 */
	public void display() {
		System.out.println(
				this.flightNo + " " + this.depLoc + " " + this.arrLoc + " " + this.flightDur + " " + this.fare + " " + this.getVaildTill());
	}

	/**
	 * @param arrLoc
	 * @param depLoc
	 * @param fare
	 * @param flightClass
	 * @param flightDur
	 * @param flightTime
	 * @param flightNo
	 * @param seatAvailability
	 * @param vaildTill
	 */
	public Flight(String arrLoc, String depLoc, double fare, String flightClass, double flightDur, String flightTime,
			String flightNo, char seatAvailability, LocalDate vaildTill) {
		this.arrLoc = arrLoc;
		this.depLoc = depLoc;
		this.fare = fare;
		this.flightClass = flightClass;
		this.flightDur = flightDur;
		this.flightTime = flightTime;
		this.flightNo = flightNo;
		this.seatAvailability = seatAvailability;
		this.vaildTill = vaildTill;
	}

	/**
	 * @return the arrLoc
	 */
	public String getArrLoc() {
		return arrLoc;
	}

	/**
	 * @param arrLoc the arrLoc to set
	 */
	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}

	/**
	 * @return the depLoc
	 */
	public String getDepLoc() {
		return depLoc;
	}

	/**
	 * @param depLoc the depLoc to set
	 */
	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}

	/**
	 * @return the fare
	 */
	public double getFare() {
		return fare;
	}

	/**
	 * @param fare the fare to set
	 */
	public void setFare(double fare) {
		this.fare = fare;
	}

	/**
	 * @return the flightClass
	 */
	public String getFlightClass() {
		return flightClass;
	}

	/**
	 * @param flightClass the flightClass to set
	 */
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	/**
	 * @return the flightDur
	 */
	public double getFlightDur() {
		return flightDur;
	}

	/**
	 * @param flightDur the flightDur to set
	 */
	public void setFlightDur(double flightDur) {
		this.flightDur = flightDur;
	}

	/**
	 * @return the flightTime
	 */
	public String getFlightTime() {
		return flightTime;
	}

	/**
	 * @param flightTime the flightTime to set
	 */
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	/**
	 * @return the flightNo
	 */
	public String getFlightNo() {
		return flightNo;
	}

	/**
	 * @param flightNo the flightNo to set
	 */
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	/**
	 * @return the seatAvailability
	 */
	public char getSeatAvailability() {
		return seatAvailability;
	}

	/**
	 * @param seatAvailability the seatAvailability to set
	 */
	public void setSeatAvailability(char seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	/**
	 * @return the vaildTill
	 */
	public LocalDate getVaildTill() {
		return vaildTill;
	}

	/**
	 * @param vaildTill the vaildTill to set
	 */
	public void setVaildTill(LocalDate vaildTill) {
		this.vaildTill = vaildTill;
	}
}
