import java.util.*;

class InvalidBookingException extends Exception {
	public InvalidBookingException(String msg) {
		super(msg);
	}
}


public class TravelBookingSystem {
	
	static void validatePackageName(String str) throws InvalidBookingException {
		if(str.equals("P123")) return;
		if(str.equals("P223")) return;
		if(str.equals("P345")) return;
		
		throw new InvalidBookingException("Invalid package Name");
	}
	
	static void validateNumberOfDays(int n) throws InvalidBookingException {
		if(n <= 0) throw new InvalidBookingException("Invalid number of days");
	}
	
	static void validateSeason(String str) throws InvalidBookingException {
		
		if(str.equals("offSeason")) return;
		if(str.equals("peakseason")) return;
		if(str.equals("season")) return;
		
		throw new InvalidBookingException("Invalid season type");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name : ");
		String customerName = sc.next();
		
		try {
			System.out.print("Enter package [P123, P223, P345] : ");
			String packageName = sc.next();
			validatePackageName(packageName);
			
			System.out.print("Enter no. of days : ");
			int numberOfDays = sc.nextInt();
			validateNumberOfDays(numberOfDays);
			
			System.out.print("Enter season : ");
			sc.nextLine();
			String season = sc.nextLine();
			
			validateSeason(season);
			
			int basePrice = 0;
			
			switch (packageName) {
				case "P123" :
					basePrice += 5000;
					break;
				case "P223" :
					basePrice += 10000;
					break;
				case "P345" :
					basePrice += 12000;
			}
			
			double seasonalPrice = 0;
			
			switch (season) {
				case "season" :
					seasonalPrice += 0.15 * basePrice;
					break;
				case "offseason" :
					seasonalPrice += 0.10 * basePrice;
					break;
				case "peakseason" :
					seasonalPrice += 0.25 * basePrice;
			}
			
			if(numberOfDays >= 7) {
				basePrice -= 0.10 * basePrice;
			}
			
			double finalBill = basePrice + seasonalPrice;
			
			System.out.printf("Final Payable amount is : %.2f", finalBill);
			
		} catch(InvalidBookingException e) {
			System.out.println(e);
		}
	}
}
