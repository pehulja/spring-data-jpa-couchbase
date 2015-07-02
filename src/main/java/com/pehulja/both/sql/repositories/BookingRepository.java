package com.pehulja.both.sql.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.pehulja.both.sql.model.Booking;
import com.pehulja.both.sql.repositories.custom.BookingRepositoryCustom;

@Profile("jpa")
public interface BookingRepository extends CrudRepository<Booking, Integer>, BookingRepositoryCustom {

	/*
	 * @Query("select booking from Booking booking where booking.guest = :guest"
	 * ) public List<Booking> getBookingsByGuest(@Param("guest") Guest guest);
	 */
}
