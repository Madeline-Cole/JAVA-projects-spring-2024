import java.util.Scanner;

/**
 * This class represents the BandOfTheHour.
 */
public class BandOfTheHour {
    // Scanner to read user input
    private static Scanner keyboard = new Scanner(System.in);
    // Maximum number of rows
    private static final int MAX_ROWS = 10;
    // Maximum number of positions
    private static final int MAX_POSITIONS = 8;
    // Maximum weight
    private static final double MAX_WEIGHT = 200.0;
    // Minimum weight
    private static final double MIN_WEIGHT = 45.0;

    /**
     * The main method.
     * @param args The command line arguments.
     */
    public static void main(String[] args) { //beginning of main method
        // Array to hold the positions
        double[][] positions = new double[MAX_ROWS][];
        //creates a variable to hold letters for each given row
        char rowLetter;
        // creates a variable to hold position number
        int positionNumber;
        //creates a variable to hold the total weight of each row
        double totalWeight = 0.0;
        //creates a variable where true is showing the options and false is exitiing the program
        String option;
        // creates a variable to hold total weight of each row
        totalWeight = 0.0;
        // creates a variable where true shows the option menu and false will not display the option menu
        boolean showMenu = true;
        // creates a variable that holds the max positions for each row.
        int maxPositionsInRow = 0;

        //prints title of program
        System.out.println("Welcome to the Band of the Hour");
        System.out.println("--------------------------------");

        // Prompt the user to enter the number of rows and stores it into numRows
        System.out.print("Please enter number of rows              : ");
        int numRows = keyboard.nextInt();

        // Validates the input is within 1-10 rows
        while (numRows < 1 || numRows > MAX_ROWS) {
            //prompts the user for a valid input until one is given
            System.out.print("ERROR: Out of range, try again           : ");
            numRows = keyboard.nextInt();
        }

        // Loop through each row
        for (int i = 0; i < numRows; i++) {
            //creates letters for each row based on the number of rows given
            rowLetter = (char) ('A' + i);

            // Prompt the user to enter the number of positions in the row
            System.out.printf("Please enter number of positions in row %c: ", rowLetter);
            int numPositions = keyboard.nextInt();

            /**
             * Validates that the input is within 1-8 positions.
             * If it's out of range, ask the user to try again.
             */
            while (numPositions < 1 || numPositions > MAX_POSITIONS) {
                System.out.print("ERROR: Out of range, try again           : ");
                numPositions = keyboard.nextInt();
            } //end of while loop

            // Initialize the positions in the row
            positions[i] = new double[numPositions];
        } //end of for loop

        /**
         * This is the main loop of the program.
         * It will keep running until the user chooses to exit.
         */
        do {
            //if showMenu is true, print the menu options.
            if(showMenu){
                System.out.print("\n(A)dd, (R)emove, (P)rint,         e(X)it : "); }
            //reads the users option and converts it the uppercase.
            option = keyboard.next().toUpperCase();

            // exit the loop immediately if the option is "X"
            if (option.equals("X")) {
                break;
            }

            /**
             * Switch statement to handle different user options.
             */
            switch (option) {
                case "A": // Add a musician option.
                    // Prompt user for the row letter.
                    System.out.print("Please enter row letter                  : ");
                    // Reads the user's row letter and converts it to uppercase.
                    rowLetter = keyboard.next().toUpperCase().charAt(0);

                    /**
                     * Validate the entered row letter.
                     * If it's out of range, ask the user to try again.
                     */
                    while (rowLetter < 'A' || rowLetter >= 'A' + numRows) {
                        System.out.print("ERROR: Out of range, try again           : ");
                        // Reads the user's row letter and converts it to uppercase.
                        rowLetter = keyboard.next().toUpperCase().charAt(0);
                    }
                    // Prompts user for position number.
                    System.out.print("Please enter position number (1 to " + positions[rowLetter - 'A'].length + ")    : ");
                    // user input is stored into the variable positionNumber.
                    positionNumber = keyboard.nextInt();

                    /**
                     * Validates that the entered position number is within 1-total positions in row.
                     * If it's out of range, ask the user to try again.
                     */
                    while (positionNumber < 1 || positionNumber > positions[rowLetter - 'A'].length) {
                        System.out.print("ERROR: Out of range, try again           : ");
                        positionNumber = keyboard.nextInt();
                    } //end of while loop

                    /**
                     * Check if there's already a musician at the entered position.
                     * If so, print an error message and break the case.
                     */
                    if (positions[rowLetter - 'A'][positionNumber - 1] > 0) {
                        System.out.println("ERROR: There is already a musician there.");
                        break;
                    }
                    // Prompts user for the weight of the musician.
                    System.out.print("Please enter weight (" + MIN_WEIGHT + " to " + MAX_WEIGHT + ")      : ");
                    double weight = keyboard.nextDouble();
                    /**
                     * Validates that the entered weight is within 45.0 & 200.0.
                     * If it's out of range, ask the user to try again.
                     */
                    while (weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
                        System.out.print("ERROR: Out of range, try again           : ");
                        weight = keyboard.nextDouble();
                    }


                    // Get the current weight at the given position.
                    double currentWeight = positions[rowLetter - 'A'][positionNumber - 1];
                    // Subtract the current weight from the total weight.
                    totalWeight -= currentWeight;

                    /**
                     * Check if adding the new weight would exceed the weight limit for the row.
                     * If the weight limit is exceeded, print an error message.
                     */
                    if (totalWeight + weight > positions[rowLetter - 'A'].length * 100) {
                        System.out.println("ERROR: That would exceed the average weight limit.");
                    }

                    /**
                     * If the weight limit is not exceeded, add the new weight at the given position
                     * and print a success message.
                     */
                    else {
                        positions[rowLetter - 'A'][positionNumber - 1] = weight;
                        System.out.println("****** Musician added.");
                    }
                    // Set showMenu to true so the menu will be printed in the next iteration.
                    showMenu = true;
                    break; // end of case A

                case "R": // Remove a musician option.
                    System.out.print("Please enter row letter                  : ");
                    // Reads the user's row letter and converts it to uppercase.
                    rowLetter = keyboard.next().toUpperCase().charAt(0);

                    /**
                     * Validate the entered row letter.
                     * If it's out of range, ask the user to try again.
                     */
                    while (rowLetter < 'A' || rowLetter >= 'A' + numRows) {
                        System.out.print("ERROR: Out of range, try again           : ");
                        rowLetter = keyboard.next().toUpperCase().charAt(0);
                    }
                    // Prompts the user for the position number.
                    System.out.print("Please enter position number (1 to " + positions[rowLetter - 'A'].length + ")    : ");
                    positionNumber = keyboard.nextInt();

                    /**
                     * Validate the entered position number.
                     * If it's out of range, ask the user to try again.
                     */
                    while (positionNumber < 1 || positionNumber > positions[rowLetter - 'A'].length) {
                        System.out.print("ERROR: Out of range, try again           : ");
                        positionNumber = keyboard.nextInt();
                    }

                    /**
                     * Check if the position is vacant.
                     * If so, print an error message.
                     * If not, remove the musician and print a success message.
                     */
                    if (positions[rowLetter - 'A'][positionNumber - 1] == 0.0) {
                        System.out.println("ERROR: That position is vacant.");
                    } else {
                        positions[rowLetter - 'A'][positionNumber - 1] = 0.0;
                        System.out.println("****** Musician removed.");
                    }
                    // Set showMenu to true so the menu will be printed in the next iteration.
                    showMenu = true;
                    break; //end of case R

                case "P": //print positions of musicians option.
                    System.out.println();
                    // Find the maximum number of positions in any row.
                    for (int i = 0; i < numRows; i++) {
                        if (positions[i].length > maxPositionsInRow) {
                            maxPositionsInRow = positions[i].length;
                        }
                    }

                    /**
                     * Print the positions and weights of the musicians in each row.
                     */
                    for (int i = 0; i < numRows; i++) {
                        rowLetter = (char) ('A' + i);
                        System.out.print(rowLetter + ": ");

                        // resets the totalWeight
                        totalWeight = 0.0;
                        for (int j = 0; j < positions[i].length; j++) {
                            System.out.printf("%5.1f ", positions[i][j]);
                            totalWeight += positions[i][j];
                        } // End of inner for loop.

                        // Print spaces to align the output.
                        for (int j = positions[i].length; j < maxPositionsInRow; j++) {
                            System.out.print("      "); // 6 spaces to align with "%5.1f "
                        } // End of inner for loop.

                        /**
                         * Calculate and print the total and average weight of the musicians in the row.
                         */
                        double averageWeight = totalWeight / positions[i].length;
                        System.out.printf(" [ %5.1f, %5.1f]\n", totalWeight, averageWeight);
                        // Set showMenu to true so the menu will be printed in the next iteration.
                        showMenu = true;

                    } // End of for loop
                    break; //end of case P

                    /**
                     * If the user's option is not recognized, print an error message and set showMenu to false.
                     */
                    default:
                    System.out.print("Invalid option, try again                : ");
                    showMenu = false;
                    break; //end of default case

            } //end of switch statement
        } while (true); //end of do-while loop

    } //end of the main method
} //end of the BandOfTheHour class
