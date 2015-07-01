package com.pehulja.both.nosql.convertor;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.pehulja.both.dto.Booking;
import com.pehulja.both.dto.Guest;
import com.pehulja.both.dto.Hotel;

@Component
@Profile("nosql")
public class Convertor {

	public Booking convert(com.pehulja.both.nosql.model.Booking bookingEntity) {
		Booking booking = new Booking();
		booking.setId(bookingEntity.getId());
		booking.setDate(bookingEntity.getDate());
		booking.setGuest(convert(bookingEntity.getGuest()));
		booking.setHotel(convert(bookingEntity.getHotel()));

		return booking;
	}

	public com.pehulja.both.nosql.model.Booking convert(Booking bookingDTO) {
		com.pehulja.both.nosql.model.Booking booking = new com.pehulja.both.nosql.model.Booking();
		booking.setId(bookingDTO.getId());
		booking.setDate(bookingDTO.getDate());
		booking.setGuest(convert(bookingDTO.getGuest()));
		booking.setHotel(convert(bookingDTO.getHotel()));

		return booking;
	}

	public Hotel convert(com.pehulja.both.nosql.model.Hotel hotelEntity) {
		Hotel hotel = new Hotel();
		hotel.setId(hotelEntity.getId());
		hotel.setName(hotelEntity.getName());
		return hotel;
	}

	public com.pehulja.both.nosql.model.Hotel convert(Hotel hotelDTO) {
		com.pehulja.both.nosql.model.Hotel hotel = new com.pehulja.both.nosql.model.Hotel();
		hotel.setId(hotelDTO.getId());
		hotel.setName(hotelDTO.getName());
		return hotel;
	}

	public Guest convert(com.pehulja.both.nosql.model.Guest guestEntity) {
		Guest guest = new Guest();
		guest.setId(guestEntity.getId());
		guest.setFio(guestEntity.getFio());
		return guest;
	}

	public com.pehulja.both.nosql.model.Guest convert(Guest guestDTO) {
		com.pehulja.both.nosql.model.Guest guest = new com.pehulja.both.nosql.model.Guest();
		guest.setId(guestDTO.getId());
		guest.setFio(guestDTO.getFio());
		return guest;
	}
}
