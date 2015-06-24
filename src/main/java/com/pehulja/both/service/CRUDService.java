package com.pehulja.both.service;

import java.util.List;

import com.pehulja.both.dto.Booking;
import com.pehulja.both.dto.Guest;
import com.pehulja.both.dto.Hotel;

public interface CRUDService {
	public Booking create(Booking booking);
	public Guest create(Guest guest);
	public Hotel create(Hotel hotel);
	
	public List<Booking> getBookingsByGuest(Guest guest);
}