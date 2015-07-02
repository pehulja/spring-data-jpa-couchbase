package com.pehulja.both.dto.mocks;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.pehulja.both.model.Hotel;

@Component
public class MocksGenerator {

	public Hotel getMockHotel() {
		Hotel hotel = new Hotel();
		hotel.setName(RandomStringUtils.randomAlphabetic(10));
		return hotel;
	}
}
