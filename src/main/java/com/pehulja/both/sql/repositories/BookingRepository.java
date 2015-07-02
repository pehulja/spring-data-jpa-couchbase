package com.pehulja.both.sql.repositories;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pehulja.both.sql.model.Booking;
import com.pehulja.both.sql.model.Guest;

@Profile("jpa")
public interface BookingRepository extends JpaRepository<Booking, Integer>, BookingRepositoryCustom{

	/*@Query("select booking from Booking booking where booking.guest = :guest")
	public List<Booking> getBookingsByGuest(@Param("guest") Guest guest);*/
}
