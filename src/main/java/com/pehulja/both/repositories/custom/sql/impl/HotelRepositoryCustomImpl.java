package com.pehulja.both.repositories.custom.sql.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.pehulja.both.model.Hotel;
import com.pehulja.both.repositories.custom.HotelRepositoryCustom;

@Repository
@Profile("jpa")
public class HotelRepositoryCustomImpl implements HotelRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	public List<Hotel> getHotelViaName(String name) {
		TypedQuery<Hotel> query = entityManager.createQuery("select hotel from Hotel hotel where hotel.name = :name",
				Hotel.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
}
