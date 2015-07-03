package com.pehulja.both.service.impl.sql;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Service;

import com.pehulja.both.model.Hotel;
import com.pehulja.both.model.Room;
import com.pehulja.both.repositories.HotelRepository;
import com.pehulja.both.repositories.RoomRepository;
import com.pehulja.both.service.CRUDService;

@Service
@Profile("jpa")
@Transactional
public class CRUDServiceImpl implements CRUDService {

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private RoomRepository roomRepository;
	
	public Hotel create(Hotel hotel) {

		return hotelRepository.save(hotel);
	}

	public List<Hotel> getHotelByName(Hotel hotel) {
		return hotelRepository.getHotelViaName(hotel.getName());
	}

	@Transactional
	public Hotel get(Integer id) {
		Hotel hotel =  hotelRepository.findOne(id);
		List<Room> rooms = hotel.getRooms();
		for(Room room : rooms){
			System.out.println(room.toString());
		}
		return hotel;
	}
	
	

}
