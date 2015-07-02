package com.pehulja.both.repositories.custom;

import java.util.List;

import com.pehulja.both.model.Hotel;

public interface HotelRepositoryCustom {
	public List<Hotel> getHotelViaName(String name);
}
