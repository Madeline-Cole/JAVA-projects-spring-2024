package wekk8;
import java.util.Scanner;
public class Kindle {
    //imports a scanner to read user input
    private static Scanner keyboard = new Scanner(System.in);

    //initializes variables
    private int totalPages;
    private int currentPage;

    public void main(String[] args) { //beginning of main method
        //promts user for page numbers
        System.out.println("How many pages in the book : ");
        totalPages = keyboard.nextInt();
    }

    public Kindle(int numberOfPages) {

        totalPages = numberOfPages;
        currentPage = 1;
    } //end of constructor

    public String toString() {
        return "Page " + currentPage + "of " + totalPages;
    } //end of toString method


    public void turnPages() {
        turnPages(1);
    }

    public void turnPages (int numberOfPages) {
        //checks if page number is positive
        if(numberOfPages > 0) {
            if (numberOfPages + currentPage > totalPages) {
                System.out.println("Turning " + numberOfPages + " would take you past the last page.");
                currentPage = totalPages;
                System.out.println("You are now on "+ toString());
            }
            else {
                currentPage = currentPage + numberOfPages; }
        }
            //checks if page number is negative
            if (numberOfPages < 0) {
                if (currentPage - numberOfPages < 0) {
                    System.out.println("Turning " + numberOfPages + " would take you past the first page.");
                } else {
                    currentPage = currentPage - numberOfPages;
                }
        }
    }

}//end of the Kindle class
