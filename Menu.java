import java.util.Locale;
import java.util.Scanner;                                           // compile with javac *.java
                                                // run with java ScoresSystem.java


public class Menu {
                                                // global array for student grades
    static int[] grades = new int[7];
                                                // functions here ->

    public static void OutputMenu() {                  // outputing the menu

        int option = 0;
                            // !!REMOVED TABS (\t) BECAUSE OF THE WRONG TESTS!!
        System.out.println("Welcome to the menu. Choose one of the options below:");
        System.out.println("1. Register new scores for students.");
        System.out.println("2. Calculate the mean of the entered scores.");
        System.out.println("3. Find the two highest and two lowest scores.");
        System.out.println("4. Find the highest score and its position.");
        System.out.println("5. Collect hashtags from a post.");
        System.out.println("6. To exit.");
        // System.out.print("Type your option: ");

        // option = input.nextInt();
        option = IOScanner.readInt("Type your option: ");
                                                        // checking if user's input is between 1 and 6
                                                        // if not -> read the value again
        while(option > 6 || option < 1) {
            option = IOScanner.readInt("Error - Invalid value. Please type between 1 and 6\n");
        }

        switch(option) {
            case(1):
                collectGrades();
                break;
            case(2):
                MeanCalculator();
                break;
            case(3):
                highestandLowest();
                break;
            case(4):
                bestStudent();
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
                                                    //Calculating the mean
        mean = sum / 7.0;                           

        System.out.printf("The mean of the numbers is %.2f\n", mean);
        OutputMenu();
    }
                                                    //Task 4
    public static void bestStudent(){
        String ordinal = "";
        int highestGrade = 0;
        int position = 0;
                                                    //Determining the highest score
        for(int i = 0; i < 7; i++){

            if(grades[i] > highestGrade){
                highestGrade = grades[i];
                position = i + 1;
            }

        }
                                                    //Making the position an ordinal number
        switch(position){                       
            case(1): ordinal = "st";
            break;

            case(2): ordinal = "nd";
            break;

            case(3): ordinal = "rd";
            break;

            default: ordinal = "th";
        }

        System.out.println("The highest score is " + highestGrade + " and belongs to the " + position + ordinal + " student");

        OutputMenu();
    }

    //task 3
    public static void highestandLowest(){

        int highestScore= 0;  
        int lowestScore= 100;
        int secondHighest= 0;
        int secondLowest= 100;
        
        for(int i=0; i < grades.length; i++){     
            if (grades[i] > highestScore){          
                secondHighest= highestScore;        
                highestScore= grades[i];
            }
            else if (grades[i] > secondHighest){
                secondHighest= grades[i];                        
            }
            if (grades[i] < lowestScore){
                secondLowest=lowestScore;
                lowestScore=grades[i];
            }
            else if (grades[i] < secondLowest){
                secondLowest=grades[i];
            } 
        }
            
        System.out.println("The two lowest scores provided are " + lowestScore + ", and " + secondLowest);
        System.out.println("The two highest socres provided are " + highestScore + ", and " + secondHighest);


    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        collectGrades();
    }


}

        


  

        
        

             






