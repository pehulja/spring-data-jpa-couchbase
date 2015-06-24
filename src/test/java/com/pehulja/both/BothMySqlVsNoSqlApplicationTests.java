package com.pehulja.both;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pehulja.both.dto.Booking;
import com.pehulja.both.dto.Guest;
import com.pehulja.both.dto.Hotel;
import com.pehulja.both.dto.mocks.MocksGenerator;
import com.pehulja.both.service.CRUDService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BothMySqlVsNoSqlApplication.class)
public class BothMySqlVsNoSqlApplicationTests {

	@Autowired 
	CRUDService crudService;
	
	@Autowired
	MocksGenerator mocksGenerator;
	
	@Test
	public void contextLoads() {

		System.out.println("Before sets");
		Random random = new Random();

		Guest [] guests = new Guest[1 + random.nextInt(2)];
		Hotel [] hotels = new Hotel[1 + random.nextInt(1)];
		Booking [] bookings = new Booking[1 + random.nextInt(15)];
		List<Booking> bookingsByGuest = null;
		
		int hotelsLength = hotels.length;
		int guestLength = guests.length;
		
		for(int i = 0; i < guests.length; i++){
			guests[i] = crudService.create(mocksGenerator.getMockGuest());
		}
		
		for(int i = 0; i < hotels.length; i++){
			hotels[i] = crudService.create(mocksGenerator.getMockHotel());
		}

		for(int i = 0; i < bookings.length; i++){
			bookings[i] = crudService.create(mocksGenerator.getMockBooking(hotels[random.nextInt(hotelsLength)], guests[random.nextInt(guestLength)]));
		}

		for(int i = 0; i < guests.length; i++){
			System.out.println(guests[i]);
		}
		
		for(int i = 0; i < hotels.length; i++){
			System.out.println(hotels[i]);
		}

		for(int i = 0; i < bookings.length; i++){
			System.out.println(bookings[i]);
		}
		
		bookingsByGuest = crudService.getBookingsByGuest(guests[random.nextInt(guestLength)]);
		System.out.println("START ---- SPECIAL GUESTS BOOKINGS");
		
		for(Booking booking : bookingsByGuest){
			System.out.println(booking.toString());
		}
		System.out.println("EXIT ----- SPECIAL GUESTS BOOKINGS");

		System.out.println("After sets");
	}

}
