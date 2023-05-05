package cinema;

public class Price { //This class calculates the tickets price based on the preferred seat

    public static int ticketPrice(int numberOfRows, int numberOfSeats, int buyRow, int buySeat) {


        int price = 0;


        if (numberOfRows * numberOfSeats <= 60) {
            price = 10; //* seats * rows;
        }

        if (numberOfRows * numberOfSeats > 60) {

            if (buyRow <= numberOfRows / 2) {
                price = 10;
            } else {
                price = 8;
            }

        }

        return price;

    }


    public static int totalIncome(int numberOfRows, int numberOfSeats) {

        int totalIncome = 0;

        if (numberOfRows * numberOfSeats <= 60) {
            totalIncome = (numberOfRows * numberOfSeats) * 10;
        }

        if (numberOfRows * numberOfSeats > 60) {

            totalIncome = (numberOfRows * numberOfSeats / 2) * 10 + (numberOfRows * numberOfSeats / 2) * 8;
        }

        return totalIncome;


    }


}


