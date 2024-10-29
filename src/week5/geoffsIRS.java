package week5;
import java.util.Scanner;

public class geoffsIRS { //beginning of geoffsIRS class

    //imports a scanner to read user input
    private static Scanner keyboard = new Scanner(System.in);
    //initializes constant variables
    public static final int STINKING_RICH = 500000;
    public static final int QUITE_RICH = 200000;
    public static final int MIAMI_POOR = 100000;
    public static final int AVERAGE = 50000;
    public static final int REALISTIC = 20000;
    public static final double HIGH_RATE = 0.25;
    public static final double MEDIUM_RATE = 0.10;
    public static final double LOW_RATE = 0.03;

    public static void main(String[] args) { //beginning of main method

        System.out.println("WEEK 5 - LAB 4");

        double income = 0.0;
        double deduction = 0.0;
        double inputValue = 0.0;


        inputValue = keyboard.nextDouble();

        while ( inputValue != 0 ) {
            if (inputValue > 0) {
                income += inputValue;
            }
            else {
                deduction += Math.abs(inputValue);
            } //end of if-else

            System.out.print("Enter next amount: ");
            inputValue = keyboard.nextDouble();
        } //end of while loop

        double getTaxableAmount = computeTaxableIncome(income,deduction);
        char getTaxGroup = chooseTaxGroup(getTaxableAmount);
        double getComputeTax = computeTax(getTaxableAmount, getTaxGroup);
        displayTaxInformation(income,deduction,getTaxableAmount,getTaxGroup,getComputeTax);


    } //end of main method

    public static double computeTaxableIncome(double income, double deduction) {
        double taxableAmount = 0.0;
        if(income >= deduction) {
            taxableAmount = income - deduction;
        } //end of if statement

        //returns taxable amount
        return taxableAmount;
    } //end of computeTaxableIncome method

    public static char chooseTaxGroup(double taxableAmount){ //beginning of chooseTaxGroup method
        char taxGroup = 'P';
        if (taxableAmount >= STINKING_RICH) { //beginning of if-else statement
            taxGroup = 'S';
        }
        else if (taxableAmount >= QUITE_RICH) {
            taxGroup = 'Q';
        }
        else if (taxableAmount >= MIAMI_POOR) {
            taxGroup = 'M';
        }
        else if (taxableAmount >= AVERAGE) {
            taxGroup = 'A';
        }
        else if (taxableAmount >= REALISTIC) {
            taxGroup = 'R';
        } //end of if-else statement
      return taxGroup;
    } ////end of chooseTaxGroup method

    public static double computeTax(double taxableAmount, char taxGroup){ //beginning of computeTax method
        double taxOwed = 0.0;
        if (taxGroup == 'S' || taxGroup == 'Q') {
            taxOwed = taxableAmount * HIGH_RATE;
        }
        else if (taxGroup == 'M') {
            taxOwed = taxableAmount * MEDIUM_RATE;
        }
        else if (taxGroup == 'A' || taxGroup == 'R') {
            taxOwed = taxableAmount * LOW_RATE;
        }
        else {
            System.out.println("Error!");
        }
       return taxOwed;
    } //end of computeTax method

    private static void displayTaxInformation(double income, double deductions, double taxableIncome, char taxGroup, double taxOwed) { //beginning of displayTaxInformation method
        System.out.println("Income          = " + income);
        System.out.println("Deductions      = " + deductions);
        System.out.println("Taxable Income  = " + taxableIncome);
        System.out.println("Tax Group       = " + taxGroup);
        System.out.println("Tax Owed        = " + taxOwed);
    }// end of displayTaxInformation method



} //end of geoffsIRS class
