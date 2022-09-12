import java.lang.reflect.Array;
import java.util.Scanner;

                                    // Custom input scanner class. 
                                    // Do not create main function here

public class IOScanner {
                        // custom input functions here ->
    public static int[] readGrades(){
        Scanner input = new Scanner(System.in);

        int[] grades; 
        
        grades= new int[7];
        for(int i =1; i<=7; i++) {

            switch (i){

                case 1: grades[i - 1] = readInt("Enter the score for the 1st student ");
                    break;

                case 2: grades[i - 1] = readInt("Enter the score for the 2nd student ");
                    break;

                case 3: grades[i - 1] = readInt("Enter the score for the 3rd student ");
                    break;

                default: grades[i - 1] = readInt("Enter the score for the " + i + "th student ");
                    break;

                 }
            
            if (grades[i - 1]>100 || grades[i - 1]<0){
                System.out.println("Error - Input out of bound. Score can only be between 0 and 100.");
                i--;
            }

        }


        // input.close();

        return grades;

        
    }

                                            // fancy Python-style input functions ->
                                            // input with message for INT
    public static int readInt(String _message) {
        int result = 0;
        Scanner input = new Scanner(System.in);

        System.out.print(_message);
        result = input.nextInt();
        
        // input.close();
        return result;
    }
                                            // input with message for DOUBLE
    public static double readDouble(String _message) {
        double result = 0;
        Scanner input = new Scanner(System.in);

        System.out.print(_message);
        result = input.nextDouble();
        
        // input.close();
        return result;
    }
                                            // input with message for LINE (STRING)
    public static String readLine(String _message) {
        String result = "";
        Scanner input = new Scanner(System.in);

        System.out.print(_message);
        result = input.nextLine();
        
        // input.close();
        return result;
    }

}
