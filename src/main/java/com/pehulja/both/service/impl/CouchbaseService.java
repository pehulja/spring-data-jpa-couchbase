package com.pehulja.both.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pehulja.both.model.Hotel;
import com.pehulja.both.repositories.HotelRepository;
import com.pehulja.both.service.CRUDService;

@Service
public class CouchbaseService implements CRUDService {

	@Autowired
	private HotelRepository hotelRepository;

	public Hotel create(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	public List<Hotel> getHotelByName(Hotel hotel) {
		return hotelRepository.getHotelViaName(hotel.getName());
	}
}
