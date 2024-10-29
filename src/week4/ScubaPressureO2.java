package week4;
import java.util.Scanner;

public class ScubaPressureO2 {
    //reads data from the keyboard (user input)
    private static Scanner scnr = new Scanner(System.in);
    public static final int FEET_PER_ATMOSPHERE = 33;

    public static void main(String[] args) {
        //initialize all variables needed
        int depth;
        int inputPercentO2;
        int percentO2;
        double ambientPressure;
        double partialPressure;
        double o2Pressure;
        boolean maxO2Pressure;
        boolean contingencyO2Pressure;

        //prompts user for input of data for depth and the percent o2 and assigns them to variables
        System.out.print("Enter Depth & Percent O2   : ");
        depth = scnr.nextInt();
        inputPercentO2 = scnr.nextInt();

        //calculate ambient pressure
        ambientPressure = ( depth / FEET_PER_ATMOSPHERE) + 1;

        //convert the input percent o2 into percent form.
        percentO2 = inputPercentO2 / 100;

        //calculates partial pressure
        partialPressure = percentO2 * ambientPressure;


        System.out.println("Ambient pressure   : "+ ambientPressure);
        System.out.println("O2 pressure        : " + partialPressure);
        System.out.println("O2 group           : ");

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
