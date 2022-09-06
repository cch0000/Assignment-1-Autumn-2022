import java.util.Scanner;                                           // compile with javac *.java
                                                // run with java ScoresSystem.java

public class ScoresSystem {
                                                // functions here ->

    public static void OutputMenu() {                  // outputing the menu
        /*All features described in the text above should be accessed via a Main Menu, using the template below. Note that once you begin the program, the user should still be prompted to type the students’ scores (described in Task 1).
        After that, you present the menu below. Typing the number of the option should take the user to the corresponding Task described above. After completing the corresponding task, the user should return to the Main Menu.*/

        int option = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the menu. Choose one of the options below:");
        System.out.println("\t1. Register new scores for students.");
        System.out.println("\t2. Calculate the mean of the entered scores.");
        System.out.println("\t3. Find the two highest and two lowest scores.");
        System.out.println("\t4. Find the highest score and its position.");
        System.out.println("\t5. Collect hashtags from a post.");
        System.out.println("\t6. To exit.");
        System.out.println("Type your option:");


        option = input.nextInt();
        switch(option) {
            case(1):

                break;
            case(2):

                break;
            case(3):

                break;
            case(4):

                break;
            case(5):

                break;
            case(6):
                System.out.println("Thank you for using our grading system. Have a nice day!");
                break;
            default:
                System.out.println("Error - Invalid value. Please type between 1 and 6");
                break;
        }
    }

    public static void main(String[] args) {
        OutputMenu();
                                                // some test code for later
        // IOScanner in = new IOScanner();
        // System.out.println(in.readFiveNums()[2]);
    }
}
