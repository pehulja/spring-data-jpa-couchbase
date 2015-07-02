package com.pehulja.both.sql.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.pehulja.both.sql.model.Hotel;

@Profile("jpa")
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

}
