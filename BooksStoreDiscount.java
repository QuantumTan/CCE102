import java.util.Scanner;

public class BooksStoreDiscount {

	public static void main(String[] args) {
		Scanner tan = new Scanner(System.in);

		int price, books;
		do {
			System.out.print("Enter the number of books purchased: ");
			books = tan.nextInt();
			System.out.print("Enter the total price of the books: ");
			price = tan.nextInt(); 
			if (books <= 0) {
				System.out.println("Please enter a no. of Purchased Book ");

			}
			if (price < 0) {
				System.out.println("Enter a valid amount! Thank you.");

			} else {
				System.out.printf("The total price after discount: $%.1f%n", calculatePrice(price, books));
			}
		} while (books <= 0 || price < 0);
		tan.close();
	}

	public static double calculatePrice(double price, double books) {
		double discountedPrice, discount = 0;

		if (books >= 1 && books <= 3) {
			discount = 0.05;
		} else if (books >= 4 && books <= 6) {
			discount = 0.10;
		} else if (books >= 6) {
			discount = 0.15;
		}
		double discountAmount = price * discount;
		discountedPrice = price - discountAmount;

		return discountedPrice;

	}
}
