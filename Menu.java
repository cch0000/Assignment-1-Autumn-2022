import java.util.Locale;
import java.util.Scanner;                                           // compile with javac *.java
                                                // run with java ScoresSystem.java


public class Menu {
                                                // global array for student grades
    static int[] grades = new int[7];
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
        // System.out.print("Type your option: ");

        // option = input.nextInt();
        option = IOScanner.readInt("Type your option: ");
                                                        // checking if user's input is between 1 and 6
                                                        // if not -> read the value again
        while(option > 6 || option < 1) {
            System.out.println("Error - Invalid value. Please type between 1 and 6");
            option = input.nextInt();
        }

        switch(option) {
            case(1):
                collectGrades();
                break;
            case(2):
                MeanCalculator();
                break;
            case(3):

                break;
            case(4):

                break;
            case(5):
                DetectHashtags();
                break;
            case(6):
                System.out.println("Thank you for using our grading system. Have a nice day!");
                break;
            default:
                System.out.println("Error - Invalid value. Please type between 1 and 6");
                break;
        }

        input.close();
    }
                                                    // Task 5 | detecting hashtags in a string
    public static void DetectHashtags() {
                                                    // reading the post from user
        String post = IOScanner.readLine("Type your post: ");
                                                    // if the post has less than 2 chars,
                                                    // it doesn't have hashtags
        if(post.length() < 2) {
            System.out.println("No hashtags were typed.");
            return;
        }

        String finalHashes = "Hashtags found:";
                                                    // iterating though all chars in the post, searching for '#'                
        for(int i = 0; i < post.length() - 1; ++i) {
            String currHash = "";
                                                    // in case hashtags starts from the beginning of the post
            if(i == 0) {
                if(post.charAt(i) == '#' && post.charAt(i + 1) != ' ') {
                    currHash = "#";
                    ++i;
                                                    // go through the hashtag while the space (or the end of the post) is not reached
                    while(i < post.length()) {
                        if(i == post.length() - 1 && post.charAt(i) != ' ') {
                            currHash += post.charAt(i);    
                        }

                        if(post.charAt(i) == ' ' || i == post.length() - 1) {
                            finalHashes += " " + currHash;
                            break;
                        }
                        currHash += post.charAt(i);
                        ++i;
                    }
                }
            }
                                                    // for all hashtags that don't start from the beginning of the post
            if(post.charAt(i) == '#' && post.charAt(i + 1) != ' ' && post.charAt(i - 1) == ' ') {
                currHash = "#";
                ++i;
                                                    // go through the hashtag while the space (or the end of the post) is not reached
                while(i < post.length()) {
                    if(i == post.length() - 1 && post.charAt(i) != ' ') {
                        currHash += post.charAt(i);    
                    }

                    if(post.charAt(i) == ' ' || i == post.length() - 1) {
                        finalHashes += " " + currHash;
                        break;
                    }
                    currHash += post.charAt(i);
                    ++i;
                }
            }
        }
                                                    // output hashtags if found any
        if(finalHashes == "Hashtags found:") {
            System.out.println("No hashtags were typed.");
        } else {
            System.out.println(finalHashes);
        }
        OutputMenu();
    }

    public static void collectGrades() {            // Task 1 | read grades from the user
        grades = IOScanner.readGrades();

        System.out.println("Thank you for your input. Your entered scores are:");
        for(int i = 0; i < 7; i++) {
                                                    // if it's the last grade, don't print the comma after
            System.out.print( i < 6 ? (grades[i] + ", ") : grades[i]);
        }
        System.out.print("\n");
                                                    // call the menu
        OutputMenu();
    }

    public static void MeanCalculator(){            // Task 2 | calculate mean
        double sum = 0;
        double mean = 0;
        for(int i = 0; i < 7; i++){                 //Adding the numbers in the array
            sum = sum + grades[i];
        }

        mean = sum / 7.0;                           //Calculating the mean

        System.out.printf("The mean of the numbers is %.2f\n", mean);
        OutputMenu();
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        collectGrades();
    }
}
