package busResv;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */
public class BusDemo {

	public static void main(String[] args) {

		ArrayList<Bus> buses = new ArrayList<Bus>();
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		
		buses.add(new Bus(1,true,3));
		buses.add(new Bus(2,true,55));
		buses.add(new Bus(3,true,50));
		
		
		
		int userOption = 1;
		Scanner scanner = new Scanner(System.in);

		for(Bus b:buses) {
			b.displayBusInfo();
		}
		
		while(userOption==1) {
			System.out.print("Enter 1 to book and 2 to exit:");
			userOption = scanner.nextInt();
			if(userOption == 1) {
				Booking booking = new Booking();
				if(booking.isAvailable(bookings,buses)) {
					bookings.add(booking);
					System.out.println("Your booking is confirmed.");
					
				} else {
					System.out.println("Sorry.  Bus is full.  Try another bus or date.");
				}
			}
			
		}
		System.out.println("-- Thank You --");
	}

}
