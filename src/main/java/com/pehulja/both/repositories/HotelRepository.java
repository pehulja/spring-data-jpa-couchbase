package com.pehulja.both.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.pehulja.both.model.Hotel;
import com.pehulja.both.repositories.custom.HotelRepositoryCustom;

public interface HotelRepository extends CrudRepository<Hotel, Integer>, HotelRepositoryCustom {

	List<Hotel> getHotelViaName(String name);
	
	Hotel findOne(Integer id);

}
