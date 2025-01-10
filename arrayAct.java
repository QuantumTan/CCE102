import java.util.Scanner;

public class arrayAct {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int totalItems = 0, highestDay = 0, lowestDay = 0;
		int[] quantitiesSold = new int[7];
		int highestSale = 0;
		int lowestSale;
		for (int i = 0; i < quantitiesSold.length; i++) {
			System.out.print("Enter Quantity Sold for day " + (i + 1) + ": ");
			quantitiesSold[i] = sc.nextInt();
			totalItems += quantitiesSold[i];
			
		}
		
		lowestSale= quantitiesSold[0];
		
		for(int i = 0; i < quantitiesSold.length; i++) {
			if (quantitiesSold[i] > highestSale) {
				highestSale = quantitiesSold[i];
				highestDay = i + 1;
	
			}
			
			if (quantitiesSold[i] < lowestSale) {
				lowestSale = quantitiesSold[i];
				lowestDay = i + 1;

			}
		}
		
		int average = totalItems / quantitiesSold.length;

		System.out.println("\nTotal items sold: " + totalItems);
		System.out.println("Highest sales: " + highestSale + " on Day " + highestDay);
		System.out.println("Lowest sales: " + lowestSale + " on Day " + lowestDay);
		System.out.println("Average sales: " + average);
		
		sc.close();
		
	}
	
}


