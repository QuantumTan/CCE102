
import java.util.Scanner;

public class array {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] days = { "Day 1", "Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7" };
		int[] quantitiesSold = new int[7];
		System.out.print("Quantities Sold on Day 1: ");
		quantitiesSold[0] = sc.nextInt();
		System.out.print("Quantities Sold on Day 2: ");
		quantitiesSold[1] = sc.nextInt();
		System.out.print("Quantities Sold on Day 3: ");
		quantitiesSold[2] = sc.nextInt();
		System.out.print("Quantities Sold on Day 4: ");
		quantitiesSold[3] = sc.nextInt();
		System.out.print("Quantities Sold on Day 5: ");
		quantitiesSold[4] = sc.nextInt();
		System.out.print("Quantities Sold on Day 6: ");
		quantitiesSold[5] = sc.nextInt();
		System.out.print("Quantities Sold on Day 7: ");
		quantitiesSold[6] = sc.nextInt();
		System.out.println("\n");

		int total = quantitiesSold[0] + quantitiesSold[1] + quantitiesSold[2] + quantitiesSold[3] + quantitiesSold[4]
				+ quantitiesSold[5] + quantitiesSold[6];
		System.out.println("Total items sold: " + total);

		int highsales = 0, lowsales = 0, highdex = 0, lowdex = 0;
		for (int i = 0; i < quantitiesSold.length; i++) {
			if (highsales < quantitiesSold[i]) {
				highsales = quantitiesSold[i];
				highdex = i;
			} else {
				lowsales = quantitiesSold[i];
				lowdex = i;
			}
		}
		for (int i = 0; i < quantitiesSold.length; i++) {
			if (lowsales > quantitiesSold[i]) {
				lowsales = quantitiesSold[i];
				lowdex = i;
			}
		}

		System.out.println("Highest sales: " + highsales + " on " + days[highdex]);
		System.out.println("Lowest sales: " + lowsales + " on " + days[lowdex]);

		int average = total / 7;
		System.out.println("Average sales: " + average);

			sc.close();
	}

}
