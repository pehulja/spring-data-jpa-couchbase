package com.pehulja.both.dto.mocks;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.pehulja.both.model.Hotel;
import com.pehulja.both.model.Room;

@Component
public class MocksGenerator {

	public Hotel getMockHotel() {
		Hotel hotel = new Hotel();
		hotel.setName(RandomStringUtils.randomAlphabetic(10));
		return hotel;
	}
	
	public Room getMockRoom() {
		Room room = new Room();
		room.setName(RandomStringUtils.randomAlphabetic(10));
		return room;
	}
}
