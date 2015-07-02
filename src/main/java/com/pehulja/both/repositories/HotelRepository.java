package com.pehulja.both.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pehulja.both.model.Hotel;
import com.pehulja.both.repositories.custom.HotelRepositoryCustom;

public interface HotelRepository extends CrudRepository<Hotel, String>, HotelRepositoryCustom {

}
