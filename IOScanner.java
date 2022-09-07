import java.lang.reflect.Array;
import java.util.Scanner;

                                    // Custom input scanner class. 
                                    // Do not create main function here

public class IOScanner {
                        // custom input functions here ->
    public int[] readGrades(){
        Scanner input = new Scanner(System.in);

        int[] grades; 
        
        grades= new int[7];
        for(int i =1; i<=7; i++) {

            switch (i){

                case 1: System.out.print("Enter the score for the 1st student ");
                    break;

                case 2: System.out.print("Enter the score for the 2nd student ");
                    break;

                case 3: System.out.print("Enter the score for the 3rd student ");
                    break;

                default: System.out.print("Enter the score for the " + i + "th student ");
                    break;

                 }

        grades[i]= input.nextInt();
        
        if (grades[i]>100 || grades[i]<0){
            System.out.println("Error - Input out of bound. Score can only be between 0  and 100.");
            i--;
        }










        }


        input.close();

        return grades;

        
    }

                                    
                                    // some test code for later 
    // public int[] readFiveNums() {
    //     int[] inputNums = new int[5];
    //     Scanner in = new Scanner(System.in);
    //     for(int i = 0; i < 5; ++i) {
    //         inputNums[i] = in.nextInt();
    //     }
    //     in.close();
    //     return inputNums;
    // }
}
