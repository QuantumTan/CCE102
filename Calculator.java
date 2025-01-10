import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner tan = new Scanner(System.in);
		double result = 0.0;

		System.out.print("Select Operation [+] Addition, [-] Subtraction, " + "[*] Multiplication, [/] Division: ");
		char operation = tan.next().charAt(0);

		System.out.print("Enter your first number: ");
		double num1 = tan.nextDouble();

		System.out.print("Enter your second number: ");
		double num2 = tan.nextDouble();

		switch (operation) {

		case '+':
			result = addition(num1, num2);
			break;
		case '-':
			result = subtraction(num1, num2);
			break;
		case '*':
			result = multiplication(num1, num2);
			break;
		case '/':
			result = division(num1, num2, tan);
			break;
		default:
			System.out.println("Enter valid operation!");
		}
		 System.out.printf("Result: %.2f", result);

	}

	public static double addition(double num1, double num2) {
		double addition;
		addition = num1 + num2;
		return addition;
	}

	public static double subtraction(double num1, double num2) {
		double subtraction;
		subtraction = num1 - num2;
		return subtraction;
	}

	public static double multiplication(double num1, double num2) {
		double multiplication;
		multiplication = num1 * num2;
		return multiplication;
	}

	public static double division(double num1, double num2, Scanner scanner) {

		double value = 0.0;
		if (num1 == 0 && num2 == 0) {
			System.out.println("Syntax Error");
			scanner.next();
			division(num1, num2, scanner);
		} else {
			value = num1 / num2;
		}

		return value;

	}
}
