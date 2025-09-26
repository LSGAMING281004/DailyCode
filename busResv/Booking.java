package busResv;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	Booking(){
		try {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter passenger name: ");
		passengerName = scanner.next();
		System.out.print("Enter bus no: ");
		busNo = scanner.nextInt();
		System.out.print("Enter date dd-mm-yyyy");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
		date = dateFormat.parse(dateInput);// Convert to String to date datatype
		} catch (ParseException e) {
			//e.printStackTrace();
			System.out.println("Date is invalid.  Try Again");
			System.exit(1);
		}catch(Exception ex) {
			System.out.println("Your input value is invalid.  Try Again");
			System.exit(1);
		}
		
	}
	
	public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
		boolean isNo = false;
		int capacity = 0;
		for(Bus bus:buses) {
			if(bus.getBusNo() == busNo) {
				isNo = true;
				capacity = bus.getCapacity();
			}
			
		}
		
		if(!isNo)
			System.out.println("BusNo: "+busNo+"  - Bus not avalable.  Top of information");
		
		int booked = 0;
		for(Booking b:bookings) {
			if(b.busNo == busNo && b.date.equals(date)) {
				booked++;
			}
		}
		
		return (booked<capacity)?true:false;
		
	}
}