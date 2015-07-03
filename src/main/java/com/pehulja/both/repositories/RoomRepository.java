package com.pehulja.both.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pehulja.both.model.Room;
import com.pehulja.both.repositories.custom.RoomRepositoryCustom;

public interface RoomRepository extends CrudRepository<Room, String>, RoomRepositoryCustom {

}
