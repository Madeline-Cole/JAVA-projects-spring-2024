package week4;

import java.util.Scanner;

public class ScubaDivingSafety{
    //reads data from the keyboard (user input)
    private static Scanner scnr = new Scanner(System.in);
    //creates constant for calculations
    public static final int FEET_PER_ATMOSPHERE = 33;


    public static void main(String[] args) { //beginning of main method
        //initialize variables
        int depth;
        int percentO2;
        double ambientPressure;
        double partialPressure;
        char pressureGroup;

        //gets depth & percent02 from user input and stores them into variables
        System.out.print("Enter Depth & Percent O2   : ");
        depth = scnr.nextInt();
        percentO2 = scnr.nextInt();

        //calculate ambient pressure
        ambientPressure = (double)(depth / FEET_PER_ATMOSPHERE) + 1;
        //calculates partial pressure
        partialPressure = ((double)(percentO2 / 100) * ambientPressure);

        //displays the pressures calculated from the input
        System.out.println("Ambient pressure   : "+ ambientPressure);
        System.out.println("O2 pressure        : " + partialPressure);

        //determine character affiliated with pressure group
        pressureGroup = (char)((int)(partialPressure * 10)+(int)('A'));
        System.out.println(pressureGroup);


        //determines if the pressures exceed the recommended / continent amounts.
        if (partialPressure > 1.4) {
            System.out.println("Exceeds maximal O2 pressure  : true");
        }
        else {
            System.out.println("Exceeds maximal O2 pressure  : false");
        }

        if (partialPressure > 1.6) {
            System.out.println("Exceeds contingency O2 pressure  : true");
        }
        else {
            System.out.println("Exceeds contingency O2 pressure  : false");
        }




    }

}
