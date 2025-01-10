import java.util.Scanner;

public class gradeCalculator {
	public static void main(String[] args) {
		Scanner tan = new Scanner(System.in);
		int n1;
		double grade = 0;
		double sum = 0;

		do {
			System.out.print("Enter the number of subjects: ");
			n1 = tan.nextInt();
			if (n1 < 1) {
				System.out.println("Enter again!");
			}
		} while (n1 < 1);
		sum = get(n1, grade, tan);

		average(sum, n1);

	}

	public static double get(int n1, double grade, Scanner tan) {
		double sum = 0;

		for (int i = 1; i < n1 + 1; i++) {
			do {
				System.out.print("Enter grade for subject " + i + ": ");
				grade = tan.nextDouble();
				if (grade < 0 || grade > 100) {
					System.out.println("Error: Grade must be 0 to 100. Try Again.");
				}
			} while (grade < 0 || grade > 100);
			
			sum = sum + grade;

		}
		return sum;

	}

	public static double average(double sum, int n1) {
		double average1;
		average1 = sum / n1;
		System.out.printf("The average grade is %.1f", average1);

		return average1;

	}

}
