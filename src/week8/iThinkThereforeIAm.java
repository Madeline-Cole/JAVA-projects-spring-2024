package week8;

import java.util.Scanner;

public class iThinkThereforeIAm {
    //imports a scanner to read user input
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) { //beginning of main method

        System.out.println("WEEK 8 - LAB 7");

        //initialize varibles
        String sentence;
        String totalTraits = "The qualities are ";

        //prompt user for traits and stores lines into sentence
        System.out.println("Please enter sentences, . to end");
        sentence = keyboard.nextLine();


        while (!sentence.equals(".")) {

            if (sentence.startsWith("I am ")) {
                sentence = sentence.substring(5) + ", ";
                totalTraits = totalTraits + sentence;
            }
            sentence = keyboard.nextLine();

        } //end of while loop

        System.out.println( totalTraits);

    }
}
