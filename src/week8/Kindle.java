package week8;


public class Kindle {

    //initializes variables
    private int totalPages;
    private int currentPage;

    public Kindle(int numberOfPages) { //beginning of Kindle constructor

        totalPages = numberOfPages;
        currentPage = 1;
    } //end of constructor

    public String toString() { //beginning of toString method
        return "Page " + currentPage + "of " + totalPages;
    } //end of toString method


    public void turnPages() { //beginning of turnPages constructor
        turnPages(1);
    } //end of turnPages constructor

    public void turnPages (int numberOfPages) { //beginning of turnPages Method
        //checks if page number is positive
        if(numberOfPages > 0) {
            if (numberOfPages + currentPage > totalPages) {
                System.out.println("Turning " + numberOfPages + " would take you past the last page.");
                currentPage = totalPages;
                System.out.println("You are now on "+ toString());
            }
            else {
                currentPage = currentPage + numberOfPages; }
        } //end of mother if statement
            //checks if page number is negative
            if (numberOfPages < 0) {
                if (currentPage - numberOfPages < 0) {
                    System.out.println("Turning " + numberOfPages + " would take you past the first page.");
                } else {
                    currentPage = currentPage - numberOfPages;
                }
        } //end of mother if statement
    }

}//end of the Kindle class
