package com.pehulja.both.sql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.pehulja.both.dto.Booking;
import com.pehulja.both.dto.Guest;
import com.pehulja.both.dto.Hotel;
import com.pehulja.both.service.CRUDService;
import com.pehulja.both.sql.convertors.Convertor;
import com.pehulja.both.sql.repositories.BookingRepository;
import com.pehulja.both.sql.repositories.GuestRepository;
import com.pehulja.both.sql.repositories.HotelRepository;

@Service
@Profile("jpa")
public class JPAService implements CRUDService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private Convertor convertor;

	public Booking create(Booking booking) {
		return convertor.convert(bookingRepository.save(convertor.convert(booking)));
	}

	public Guest create(Guest guest) {
		return convertor.convert(guestRepository.save(convertor.convert(guest)));
	}

	public Hotel create(Hotel hotel) {
		return convertor.convert(hotelRepository.save(convertor.convert(hotel)));
	}

	public List<Booking> getBookingsByGuest(Guest guest) {
		System.out.println("LA LA LA");
		com.pehulja.both.sql.model.Guest guestEntity = guestRepository.findOne(guest.getId());
		List<com.pehulja.both.sql.model.Booking> bookings = bookingRepository.getBookingsByGuest(guestEntity);
		List<Booking> bookingsDTOs = new ArrayList<Booking>(bookings.size());
		for (com.pehulja.both.sql.model.Booking booking : bookings) {
			bookingsDTOs.add(convertor.convert(booking));
		}
		
		System.out.println("LA LA LA");

		return bookingsDTOs;
	}
}
