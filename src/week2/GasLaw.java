package week2;

import java.util.Scanner;
//needed to import scanner

//=============================================================================
public class GasLaw {

    //-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    //The gas constant in Joules/mole/K
    private static double GasConstant = 8.3143;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values
        double Volume, Moles, Temp;
        double pressure;

//----What is this all about?
        System.out.print("Enter volume, moles, temperature : ");
        Volume = keyboard.nextDouble();
        Moles = keyboard.nextDouble();
        Temp = keyboard.nextDouble();

//----Is anything happening here? (the pressure is being calculated by the variables)
        pressure = Moles * GasConstant * Temp / Volume;

//----Why do this? (to print out the pressure)
        System.out.println("Pressure is " + pressure);
    }
}
//-----------------------------------------------------------------------------
//=============================================================================