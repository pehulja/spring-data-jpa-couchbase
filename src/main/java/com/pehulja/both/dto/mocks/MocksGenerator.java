package com.pehulja.both.dto.mocks;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.pehulja.both.dto.Booking;
import com.pehulja.both.dto.Guest;
import com.pehulja.both.dto.Hotel;

@Component
public class MocksGenerator {
	
	public Guest getMockGuest(){
		Guest guest = new Guest();
		guest.setFio(RandomStringUtils.randomAlphabetic(20));
		return guest;
	}
	
	public Hotel getMockHotel(){
		Hotel hotel = new Hotel();
		hotel.setName(RandomStringUtils.randomAlphabetic(10));
		return hotel;
	}
	
	public Booking getMockBooking(Hotel hotel, Guest guest){
		Booking booking = new Booking();
		booking.setDate(new Date());
		booking.setGuest(guest);
		booking.setHotel(hotel);
		return booking;
	}
}
