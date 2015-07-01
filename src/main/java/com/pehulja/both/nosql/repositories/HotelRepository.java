package com.pehulja.both.nosql.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pehulja.both.nosql.model.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, String> {

}
