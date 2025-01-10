import java.util.Scanner;

public class activity1 {

	public static void main(String[] args) {
		Scanner tan = new Scanner(System.in);
		double radius, length, width, height;

		System.out.print("Enter radius: ");
		radius = tan.nextDouble();

		System.out.print("Enter length: ");
		length = tan.nextDouble();

		System.out.print("Enter width: ");
		width = tan.nextDouble();

		System.out.print("Enter height: ");
		height = tan.nextDouble();

		System.out.printf("Area of circle: %.2f\n", aCircle(radius));
		System.out.printf("Area of rectangle: %.2f", aRectangle(length, width, height));

		tan.close();

	}

	public static double aCircle(double radius) {

		double areaCircle;
		areaCircle = Math.PI * (Math.pow(radius, 2));
		return areaCircle;
	}

	public static double aRectangle(double length, double width, double height) {

		double areaRectangle;

		areaRectangle = length * width * height;
		return areaRectangle;
	}

}
