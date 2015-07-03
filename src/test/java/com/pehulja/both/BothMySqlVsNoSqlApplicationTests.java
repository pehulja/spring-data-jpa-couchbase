package com.pehulja.both;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.pehulja.both.dto.mocks.MocksGenerator;
import com.pehulja.both.model.Hotel;
import com.pehulja.both.model.Room;
import com.pehulja.both.service.CRUDService;

@Configuration
@ComponentScan(basePackages = { "com.pehulja.both" })
class TestConfig {
}

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(value = "jpa")
public class BothMySqlVsNoSqlApplicationTests {

	@Autowired
	CRUDService crudService;

	@Autowired
	MocksGenerator mocksGenerator;

	@Test
	@Ignore
	public void contextLoads() {

		System.out.println("Before sets");
		Random random = new Random();

		Hotel[] hotels = new Hotel[1 + random.nextInt(1)];

		int hotelsLength = hotels.length;

		for (int i = 0; i < hotels.length; i++) {
			hotels[i] = crudService.create(mocksGenerator.getMockHotel());
		}

		for (int i = 0; i < hotels.length; i++) {
			System.out.println(hotels[i]);
		}

		List<Hotel> hotelsByName = crudService.getHotelByName(hotels[random.nextInt(hotelsLength)]);
		System.out.println("START ---- SPECIAL GUESTS BOOKINGS");

		for (Hotel booking : hotelsByName) {
			System.out.println(booking.toString());
		}
		System.out.println("EXIT ----- SPECIAL GUESTS BOOKINGS");

		System.out.println("After sets");
	}
	
	@Test
	public void testRelations(){
		Hotel hotel = mocksGenerator.getMockHotel();
		List<Room> rooms = new ArrayList<Room>(2);
		rooms.add(mocksGenerator.getMockRoom());
		rooms.add(mocksGenerator.getMockRoom());
		for(Room room : rooms){
			room.setHotel(hotel);
		}
		hotel.setRooms(rooms);
		crudService.create(hotel);
		
		
		Hotel hotel2 = crudService.get(hotel.getId());
		System.out.println(hotel2.toString());
	}

}
