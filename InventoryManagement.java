  import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class InventoryManagement {
	private static final String MY_PATH = "Inventory.txt";

	public static void main(String[] args) throws IOException {

		makeFile();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Menu Display");
			System.out.println(
					"\n1. Add Book \n2. View All Books \n3. Search for a Book \n4. Update a Book \n5. Delete a Book \n6. Exit");

			System.out.print("\nEnter your Choice: ");
			int choice = sc.nextInt();
			sc.nextLine(); 

			switch (choice) {
			case 1:
				addBook(sc);
				break;
			case 2:
				view();
				break;
			case 3:
				searchBook(sc);
				break;
			case 4:
				updateBook(sc);
				break;
			case 5:
				deleteBook(sc);
				break;
			case 6:
				System.out.println("Exiting the program...");
				sc.close();
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}

		}
	}

	private static void makeFile() throws IOException {
		File file = new File(MY_PATH);
		if (!file.exists()) {

			file.createNewFile();
		}
	}

	private static void addBook(Scanner sc) throws IOException {
		System.out.print("Enter Book ID: ");
		String ID = sc.nextLine();
		System.out.print("Enter Title: ");
		String title = sc.nextLine();
		System.out.print("Enter Author: ");
		String author = sc.nextLine();
		System.out.print("Enter Price: ");
		double price = sc.nextDouble();
		sc.nextLine(); 
		System.out.print("Enter Stock Quantity: ");
		String stock = sc.nextLine();

		String bookView = ID + "|" + title + "|" + author + "|" + price + "|" + stock + "|";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(MY_PATH, true))) {
			writer.write(bookView);
			writer.newLine();
			System.out.println("Book added successfully!");
		}
	}

	private static void view() throws IOException {
		List<String> bookLines = Files.readAllLines(Paths.get(MY_PATH));

		if (bookLines.isEmpty()) {
			System.out.println("No Books Found...");
		} else {
			System.out.println("\n      Viewing All Books      \n");
			System.out.println("[ ID | Title | Author | Price | Stock ]");
			System.out.println("__________________________________________");

			for (String line : bookLines) {
				String[] bookDetails = line.split("\\|");

				if (bookDetails.length == 5) {
					System.out.printf("%-11s | %-20s | %-20s | %-16.2f | %-8s%n", bookDetails[0], bookDetails[1],
							bookDetails[2], Double.parseDouble(bookDetails[3]), bookDetails[4]);
				}
			}

			System.out.println("--------------------------------------------------");
		}
	}

	private static void searchBook(Scanner sc) throws IOException {

		List<String> bookLines = Files.readAllLines(Paths.get(MY_PATH));

		if (bookLines.isEmpty()) {
			System.out.println("Nothing Found...");
			return;
		}

		System.out.println("Enter a Book ID to Search: ");
		String searchId = sc.nextLine();

		boolean found = false;

		System.out.println("\n--- Search Results ---");
		System.out.println("[ ID | Title | Author | Price | Stock ]");
		System.out.println("--------------------------------------------------");

		for (String line : bookLines) {
			String[] bookDetails = line.split("\\|");

			if (bookDetails.length >= 5 && bookDetails[0].trim().equalsIgnoreCase(searchId.trim())) {
				System.out.printf("%-5s | %-20s | %-15s | %-8.2f | %-5s%n", bookDetails[0], bookDetails[1],
						bookDetails[2], Double.parseDouble(bookDetails[3]), bookDetails[4]);
				found = true;
				break; // Stop searching after finding the first match
			}
		}

		if (!found) {
			System.out.println("No book found with ID: " + searchId);
		}

		System.out.println("--------------------------------------------------");
	}

	private static void updateBook(Scanner sc) throws IOException {
		List<String> bookLines = Files.readAllLines(Paths.get(MY_PATH));

		if (bookLines.isEmpty()) {
			System.out.println("No Books Found in the Inventory...");
			return;
		}

		System.out.print("Enter Book ID to Update: ");
		String searchId = sc.nextLine();

		boolean found = false;

		for (int i = 0; i < bookLines.size(); i++) {
			String[] bookDetails = bookLines.get(i).split("\\|");

			if (bookDetails.length >= 5 && bookDetails[0].trim().equalsIgnoreCase(searchId.trim())) {
				System.out.println("\nBook Found. Current Details:");
				System.out.printf("ID: %s, Title: %s, Author: %s, Price: %.2f, Stock: %s%n", bookDetails[0],
						bookDetails[1], bookDetails[2], Double.parseDouble(bookDetails[3]), bookDetails[4]);

				// Update Price
				double newPrice;
				while (true) {
					try {
						System.out.print("New Price (press Enter to keep current): ");
						String priceInput = sc.nextLine();
						if (priceInput.isEmpty()) {
							newPrice = Double.parseDouble(bookDetails[3]);
							break;
						}
						newPrice = Double.parseDouble(priceInput);
						break;
					} catch (NumberFormatException e) {
						System.out.println("Invalid price. Please enter a valid number.");
					}
				}

				// Update Stock
				System.out.print("New Stock Quantity (press Enter to keep current): ");
				String newStock = sc.nextLine();
				if (newStock.isEmpty()) {
					newStock = bookDetails[4];
				}

				// Create updated book entry
				String updatedBook = String.join("|", bookDetails[0], bookDetails[1], bookDetails[2],
						String.valueOf(newPrice), newStock);

				// Replace the old entry
				bookLines.set(i, updatedBook);

				// Write updated list back to file
				Files.write(Paths.get(MY_PATH), bookLines);

				System.out.println("Book updated successfully!");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("No book found with ID: " + searchId);
		}
	}

	private static void deleteBook(Scanner sc) throws IOException {
		List<String> bookLines = Files.readAllLines(Paths.get(MY_PATH));

		if (bookLines.isEmpty()) {
			System.out.println("No Books Found in the Inventory...");
			return;
		}

		System.out.print("Enter Book ID to Delete: ");
		String searchId = sc.nextLine();

		for (int i = 0; i < bookLines.size(); i++) {
			String[] bookDetails = bookLines.get(i).split("\\|");

			if (bookDetails.length >= 5 && bookDetails[0].trim().equalsIgnoreCase(searchId.trim())) {
				// Display book details before deletion
				System.out.println("Book Found. Details:");
				System.out.printf("ID: %s, Title: %s, Author: %s, Price: %.2f, Stock: %s%n", bookDetails[0],
						bookDetails[1], bookDetails[2], Double.parseDouble(bookDetails[3]), bookDetails[4]);

				// Confirm deletion
				System.out.print("Are you sure you want to delete this book? (yes/no): ");
				String confirm = sc.nextLine().trim().toLowerCase();

				if (confirm.equals("yes")) {
					// Remove the book at the current index
					bookLines.remove(i);

					// Write updated list back to file
					Files.write(Paths.get(MY_PATH), bookLines);

					System.out.println("Book deleted successfully!");
					break;
				} else {
					System.out.println("Deletion cancelled.");
					return;
				}
			}
		}

	}
}