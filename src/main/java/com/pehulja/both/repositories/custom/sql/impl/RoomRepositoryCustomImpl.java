package com.pehulja.both.repositories.custom.sql.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.pehulja.both.model.Room;
import com.pehulja.both.repositories.custom.RoomRepositoryCustom;

@Repository
@Profile("jpa")
public class RoomRepositoryCustomImpl implements RoomRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	public List<Room> getRoomViaName(String name) {
		TypedQuery<Room> query = entityManager.createQuery("select room from Room room where room.name = :name",
				Room.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
}
