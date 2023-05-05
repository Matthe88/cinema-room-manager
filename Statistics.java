package cinema;

import java.util.Locale;

public class Statistics {


    public static void showStatistics(int purchasedSeats, int sumSeats, int currentIncome, int totalIncome) {

        System.out.println("Number of purchased tickets: " + purchasedSeats);

        System.out.print("Percentage: ");
        System.out.printf(Locale.US, "%.2f", (purchasedSeats/(float)sumSeats)*100);
        System.out.println("%");
        System.out.println("Current income: $"+currentIncome);
        System.out.println("Total income: $"+totalIncome);


    }




}
