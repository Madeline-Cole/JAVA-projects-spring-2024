package week3;
import java.util.Scanner;
//import scanner

public class KangarooKills { //class is created, start of KangarooKills class
    //reads data from the keyboard (user input)
    private static Scanner keyboard = new Scanner(System.in);
    //create constant for calculating kangaroo kills/injuries
    private static final double KANGAROO_CONSTANT = 1.47;
    //create constant for standard road width in km
    private static final double ROAD_CONSTANT = 0.01;
    //*THESE^ MUST BE IN A CLASS BUT ABOVE THE MAIN METHOD

    public static void main(String[] args) {
        //start of main method
        //prints title and ensures there is an output
        System.out.println("Week 3 - LAB 2 \n");

        //initialize the variables that will be inputted from users
        double squareSideLength;
        double roadlength ;
        int kangarooTotal;
        //initializes variables needed for calculating kangaroo kills and injuries
        double kangarooDensity;
        double roadarea;
        double kangarooKillandInjury;
        int kangarooInjury;
        double squareArea;
        int kangarooKill;

        //prompt user for data and place input into initialized variables
        System.out.print("Enter side of square in km: ");
        squareSideLength = keyboard.nextDouble();
        System.out.print("Enter road's length in km: ");
        roadlength = keyboard.nextDouble();
        System.out.print("Enter number of 'roos: ");
        kangarooTotal = keyboard.nextInt();

            //calculate square area
            squareArea = squareSideLength * squareSideLength;
            //calculate kangaroo density
            kangarooDensity = kangarooTotal / squareArea;
            //calculate road area
            roadarea = roadlength * ROAD_CONSTANT;
            //calculate kangaroo kills
            kangarooKillandInjury = kangarooDensity * roadarea * KANGAROO_CONSTANT;

            //shortening double to find the kangaroo kills
            kangarooKill = (int)(kangarooKillandInjury);
            //assigning a value to kangarooInjury that will be shortened
            kangarooInjury = (int)(Math.ceil(kangarooKillandInjury %1));

        //System.out.println(+kangarooKillandInjury); (test number)
        //prints out the calculated number of kangaroo kills and injuries
        System.out.println("Expected number of kills is: " + kangarooKill);
        System.out.println("Expected number of injuries is: " + kangarooInjury);

    } //end of the main method

} //end of the KangarooKills class

