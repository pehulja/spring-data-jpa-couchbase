package com.pehulja.both.nosql.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pehulja.both.nosql.model.Guest;

public interface GuestRepository extends CrudRepository<Guest, String> {

}
