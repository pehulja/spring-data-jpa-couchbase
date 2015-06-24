package com.pehulja.both.sql.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pehulja.both.sql.model.Guest;
@Profile("jpa")
public interface GuestRepository extends JpaRepository<Guest, Integer>{

}
