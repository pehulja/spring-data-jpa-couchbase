package com.pehulja.both.repositories.custom;

import java.util.List;

import com.pehulja.both.model.Room;

public interface RoomRepositoryCustom {
	public List<Room> getRoomViaName(String name);

}
