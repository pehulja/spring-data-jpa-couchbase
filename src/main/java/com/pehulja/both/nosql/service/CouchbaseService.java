package com.pehulja.both.nosql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;
import com.pehulja.both.dto.Booking;
import com.pehulja.both.dto.Guest;
import com.pehulja.both.dto.Hotel;
import com.pehulja.both.nosql.convertor.Convertor;
import com.pehulja.both.nosql.repositories.BookingRepository;
import com.pehulja.both.nosql.repositories.GuestRepository;
import com.pehulja.both.nosql.repositories.HotelRepository;
import com.pehulja.both.service.CRUDService;

@Profile("nosql")
@Service
public class CouchbaseService implements CRUDService{
	@Autowired
	CouchbaseTemplate template;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private GuestRepository guestRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private Convertor convertor;
	
	@Override
	public Booking create(Booking booking) {
		return convertor.convert(bookingRepository.save(convertor.convert(booking)));
	}

	@Override
	public Guest create(Guest guest) {
		return convertor.convert(guestRepository.save(convertor.convert(guest)));
	}

	@Override
	public Hotel create(Hotel hotel) {
		return convertor.convert(hotelRepository.save(convertor.convert(hotel)));
	}

	@Override
	public List<Booking> getBookingsByGuest(Guest guest) {
		System.out.println(template);
		Query query = new Query();
		query.setKey(ComplexKey.of(convertor.convert(guest)));
		//query.setKey(ComplexKey.of("1435085258634"));
		List<com.pehulja.both.nosql.model.Booking> bookings = bookingRepository.findByGuest(query);
		//List<com.pehulja.both.nosql.model.Booking> bookings = bookingRepository.findByDate(query);
		List<Booking> bookingsDTOs = new ArrayList<Booking>(bookings.size());
		for(com.pehulja.both.nosql.model.Booking booking : bookings){
			bookingsDTOs.add(convertor.convert(booking));
		}
		
		return bookingsDTOs;
	}
	
}
