package com.pehulja.both.repositories.custom.nosql.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Repository;

import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;
import com.pehulja.both.model.Hotel;
import com.pehulja.both.repositories.custom.HotelRepositoryCustom;

@Repository
@Profile("nosql")
public class HotelRepositoryCustomImpl implements HotelRepositoryCustom {

	@Autowired
	CouchbaseTemplate template;

	public List<Hotel> getHotelViaName(String name) {
		Query query = new Query();
		query.setKey(ComplexKey.of(name));
		return template.findByView("hotel", "byName", query, Hotel.class);
	}
}
