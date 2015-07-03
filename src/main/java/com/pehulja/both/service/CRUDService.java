package com.pehulja.both.service;

import java.util.List;

import com.pehulja.both.model.Hotel;
import com.pehulja.both.model.Room;

public interface CRUDService {
	public Hotel create(Hotel hotel);
	public List<Hotel> getHotelByName(Hotel hotel);
	public Hotel get(Integer id);

}