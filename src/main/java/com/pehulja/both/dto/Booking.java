package com.pehulja.both.dto;

import java.util.Date;

public class Booking {
	
	private int id;
	
	private Date date;
	private Hotel hotel;
	private Guest guest;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", date=" + date + ", hotel=" + hotel
				+ ", guest=" + guest + "]";
	}
}