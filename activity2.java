import java.util.Scanner;

public class activity2 {

	public static void main(String[] args) {

		Scanner tan = new Scanner(System.in);
		String coffeeType;
		double numCups;

		do {
			System.out.print("Enter coffee type (Espresso, Latte, Cappuccino): ");
			coffeeType = tan.nextLine();

			if (!coffeeType.equalsIgnoreCase("Espresso")
					&& !(coffeeType.equalsIgnoreCase("Latte") && !(coffeeType.equalsIgnoreCase("Cappuccino")))) {
				System.out.println("Error: Re-enter your coffee type.");
			}
		} while (!coffeeType.equalsIgnoreCase("Espresso")
				&& !(coffeeType.equalsIgnoreCase("Latte") && !(coffeeType.equalsIgnoreCase("Cappuccino"))));

		do {
			System.out.print("Enter number of cups: ");
			numCups = tan.nextInt();

			if (numCups <= 0) {
				System.out.println("Error: Enter a number of cups");
			}
		} while (numCups <= 0);
		
		output(coffeeType, numCups);
		
		tan.close();
	
	}

	public static double calculation(String coffeeType, double numCups, int cost) {

		double tCost;
		tCost = numCups * cost;
		return tCost;
	}
	
	public static void output(String coffeeType, double numCups) {
		if (coffeeType.equalsIgnoreCase("Espresso")) {
			System.out.printf("Total costs for %.0f cup(s) of %s: $%.2f%n", numCups, coffeeType,
					calculation(coffeeType, numCups, 3));
		} else if (coffeeType.equalsIgnoreCase("Latte")) {
			System.out.printf("Total costs for %.0f cup(s) of %s: $%.2f%n", numCups, coffeeType,
					calculation(coffeeType, numCups, 4));
		} else if (coffeeType.equalsIgnoreCase("Cappuccino")) {
			System.out.printf("Total costs for %.0f cup(s) of %s: $%.2f%n", numCups, coffeeType,
					calculation(coffeeType, numCups, 5));
		}
	}

}
