package com.pehulja.both.nosql.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.couchbase.client.protocol.views.Query;
import com.pehulja.both.nosql.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, String> {
	public List<Booking> findByGuest(Query query);
}
