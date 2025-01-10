import java.util.Scanner;

public class acitvity3 {

	public static void main(String[] args) {

		Scanner tan = new Scanner(System.in);

		String roomType, confirmBook;
		int nights;
		
		System.out.println("Available rooms: \n");
		displayRoom();
		
		do {
		System.out.print("Enter the type of room you want to book (Single/Double/Suite): ");
		roomType = tan.nextLine();
			if (!roomType.equalsIgnoreCase("Single") && !roomType.equalsIgnoreCase("Double") && !roomType.equalsIgnoreCase("Suite") ) {
				System.out.println("\nError: Re-enter the room you want to book.");
			}
		} while (!roomType.equalsIgnoreCase("Single") && !roomType.equalsIgnoreCase("Double") && !roomType.equalsIgnoreCase("Suite"));
		
		do {
		System.out.print("Enter the number of nights you want to stay: \n");
		nights = tan.nextInt();
			if(nights<=0) {
				System.out.println("Error: Please Re-enter the number of nights you want to stay. \n");
			}
		} while (nights<=0);

		if (roomType.equalsIgnoreCase("Single")) {
			calculateCost(roomType, nights, 50);
		} else if (roomType.equalsIgnoreCase("Double")) {
			calculateCost(roomType, nights, 75);
		} else if (roomType.equalsIgnoreCase("Suite")) {
			calculateCost(roomType, nights, 120);
		} else {
			System.out.println("Room Unavailable!\n");
		}
		
		System.out.print("Do you want to confirm the booking? (yes/no)\n");
		tan.nextLine();
		confirmBook= tan.nextLine();
		confirmBooking(confirmBook);

		tan.close();
	}

	public static void calculateCost(String roomType, int nights, int cost) {

		double totalCost = nights * cost;
		System.out.printf("The total cost of your booking is : $%.1f \n", totalCost);


	}

	public static void displayRoom() {

		System.out.println(
				"1. Single Room ($50 per night)\n" + "2. Double Room ($75 per night)\n" + "3. Suite ($120 per night)\n ");

	}

	public static void confirmBooking(String confirmBook) {
		if (confirmBook.equalsIgnoreCase("yes")) {
			System.out.println("Booking Confirmed! Thank you.");
		} else {
			System.out.println("Booking Cancelled! Thank you.");
		}
	}

}
