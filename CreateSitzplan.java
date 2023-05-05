package cinema;

public class CreateSitzplan {  //This class creates the seat plan; marking all free seats with an "S"

    private char[][] sitzplan;


    public static String[][] createSitzplan(String[][] sitzplan) {

        for (int i = 0; i < sitzplan.length; i++) {

            for (int k = 0; k < sitzplan[i].length; k++) {
                sitzplan[i][k] = " S";

            }
        } return sitzplan;
    }

    public  char[][] getSitzplan() {
        return this.sitzplan;
    }
}
