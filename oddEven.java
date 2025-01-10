import java.util.Scanner;

public class oddEven {

	public static void main(String[] args) {

		Scanner tan = new Scanner(System.in);

		int n;
		String identification;

		do {
			System.out.print("Enter the maximum number: ");
			n = tan.nextInt();
			tan.nextLine();
			if (n < 1) {
				System.out.print("Enter a number greater than 1. Try Again.\n");
			}
		} while (n < 1);

		do {
			System.out.print("Odd or Even: ");
			identification = tan.nextLine();
			if (!identification.equalsIgnoreCase("Odd") && !identification.equalsIgnoreCase("Even")) {
				System.out.println("Error: Enter Odd or Even. Try Again.");
			}
		} while (!identification.equalsIgnoreCase("Odd") && !identification.equalsIgnoreCase("Even"));

		if (identification.equalsIgnoreCase("Odd")) {
			odd(tan, n);
		}

		if (identification.equalsIgnoreCase("Even")) {
			even(tan, n);
		}

	}

	private static void even(Scanner tan, int n) {

		System.out.print("The Even numbers are: ");
		for (int i = 2; i <= n; i = i + 2) {
			System.out.print(i);
			if (i + 2 <= n) {
				System.out.print(", ");

			}
		}

	}

	public static void odd(Scanner tan, int n) {
		System.out.print("The Odd numbers are: ");
		for (int i = 1; i <= n; i = i + 2) {
			System.out.print(i);
			if (i + 2 <= n) {
				System.out.print(", ");
			}
		}
	}
}
