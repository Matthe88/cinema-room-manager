package cinema;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int purchasedSeats = 0;
        int currentIncome = 0;
        int totalIncome = 0;


        Scanner reader = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int numberOfRows = reader.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = reader.nextInt();

        int sumSeats = numberOfSeats*numberOfRows;  //Calculate the sum of all seats
        totalIncome = Price.totalIncome(numberOfRows, numberOfSeats); //Calculate the total income, when all seats are sold


        String[][] sitzplan = new String[numberOfRows][numberOfSeats]; //Create a 2-dimensional array

        String[][] newSitzplan = CreateSitzplan.createSitzplan(sitzplan); //Add the availability to the cinema seats - "S" for free seats, "B" for already sold seats


        while (true) {

            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int choose = reader.nextInt();

            if (choose == 1) { //Show the seatplan of the cinema

                System.out.println("Cinema:"); //Prints the headline
                System.out.print("  ");

                for (int j = 1; j <= numberOfSeats; j++) { //Print Number of Columns
                    System.out.print(" " + j);
                }
                System.out.println(); //Starts new row

                for (int i = 0; i < newSitzplan.length; i++) {  //Prints number of row
                    System.out.print(" ");
                    System.out.print(i + 1);

                    for (int k = 0; k < newSitzplan[i].length; k++) {   //Prints the seats
                        System.out.print(newSitzplan[i][k]);
                    }
                    System.out.println();
                }


            }

            if (choose == 2) { //Functionality to buy a seat

                while (true) {

                    System.out.println("Enter a row number: ");
                    int buyRow = reader.nextInt();

                    System.out.println("Enter a seat number in that row: ");
                    int buySeat = reader.nextInt();

                    if (buyRow<= numberOfRows && buySeat <= numberOfSeats && !(sitzplan[buyRow - 1][buySeat - 1].equals(" B"))) { //No errors

                        sitzplan[buyRow - 1][buySeat - 1] = " B";
                        purchasedSeats++;

                        int price = Price.ticketPrice(numberOfRows, numberOfSeats, buyRow, buySeat);
                        currentIncome += price;

                        System.out.println("Ticket price: $" + price);
                        break;
                    }

                    if (buyRow > numberOfRows || buySeat > numberOfSeats) { //Error when user tries to buy a seat that is not available
                        System.out.println("Wrong input!");
                        System.out.println();
                    }

                    if (buyRow <= numberOfRows && buySeat <= numberOfSeats && (sitzplan[buyRow - 1][buySeat - 1].equals(" B"))) { //Error when user tries to buy a seat that is already sold
                        System.out.println("That Ticket has already been purchased!");
                        System.out.println();
                    }


                }

            }

            if (choose == 3 ) {  //Show the statistics
                Statistics.showStatistics(purchasedSeats, sumSeats, currentIncome, totalIncome);
            }


            if (choose == 0) {
                break;
            }
        }
    }
}


