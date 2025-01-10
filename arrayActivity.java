import java.util.Scanner;

public class arrayActivity {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int totalItems = 0, highestDay = 0, lowestDay = 0, highest=0, lowest=0;
		int[] quantitiesSold = new int[7];
		int highestSale = 0;
		int lowestSale= 0;
		int high=0, low=0;
	

		for (int i = 0; i < quantitiesSold.length; i++) {
			System.out.print("Enter Quantity Sold for day " + (i + 1) + ": ");
			quantitiesSold[i] = sc.nextInt();
			totalItems += quantitiesSold[i];
			
		

			if (quantitiesSold[i] > highestSale) {
				highestSale = quantitiesSold[i];
				highestDay = i + 1;
				high= i;
	
			}
			
			lowestSale= quantitiesSold[0];
			if (quantitiesSold[i] < lowestSale) {
				lowestSale = quantitiesSold[i];
				lowestDay = i + 1;
				low= i;

			}
		}
		int average = totalItems / quantitiesSold.length;

		System.out.println("\nTotal items sold: " + totalItems);
		System.out.println("Highest sales: " + highestDay + " on Day " + high);
		System.out.println("Lowest sales: " + lowestDay + " on Day " + low);
		System.out.println("Average sales: " + average);
		
		sc.close();
		
	}
	
}
