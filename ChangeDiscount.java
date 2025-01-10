import java.util.Scanner;

public class ChangeDiscount {

	public static void main(String[] args) {

		Scanner tan = new Scanner(System.in);

		double totalAmount, totalBill, discount;
		double result = 0.0;
		discount = 0.20;
		int choice;

		System.out.print("Enter total amount: ");
		totalAmount = tan.nextDouble();
		System.out.print("Enter total bill: ");
		totalBill = tan.nextDouble();
		displayChoice();
		choice = tan.nextInt();
		tan.close();

		switch (choice) {

		case 1:
			System.out.printf("Total change is %.0f", calculate(totalBill, totalAmount));
			break;
		case 2:
			double amountDiscounted;
			amountDiscounted = totalBill - calculate(totalBill, totalAmount, discount);
		
			System.out.printf("The new total amount after discount is %.0f" , calculate(totalBill, totalAmount, discount));
			System.out.printf("\nThe change is %.0f", amountDiscounted);
			break;
		default:
			System.out.println("Wrong Choice. Try again.");
			return;
		}

	}

	public static void displayChoice() {
		System.out.println("Enter type Customer [1] Regular [2] Senior Citizen or PWD");
	}

	public static double calculate(double totalBill, double totalAmount) {
		double change = totalBill - totalAmount;
		return change;
	}

	public static double calculate(double totalBill, double totalAmount, double discount) {
		double newAmount;

		newAmount = totalAmount - (totalAmount * discount);
		return newAmount;
	}
}
