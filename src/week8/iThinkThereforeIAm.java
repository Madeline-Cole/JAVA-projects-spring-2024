package wekk8;

import java.util.Scanner;

public class iThinkThereforeIAm {
    //imports a scanner to read user input
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) { //beginning of main method

        System.out.println("WEEK 8 - LAB 7");

        String sentence;
        String traits = " ";
        String totalTraits = "The qualities are ";

        System.out.println("Please enter sentences, . to end");
        sentence = keyboard.nextLine();


        while (!sentence.equals(".")) {

            if (sentence.startsWith("I am ")) {
                sentence = sentence.substring(5) + ", ";
                totalTraits = totalTraits + sentence;
            }
            sentence = keyboard.nextLine();

        } //end of while

        System.out.println( totalTraits);

    }
}
