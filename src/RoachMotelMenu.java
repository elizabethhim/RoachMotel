import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: This class was created to display menu options to the console without cluttering our main program
 */

public class RoachMotelMenu {

    /**String holding the initial menu choices*/
    private static String initialMenu = "1.Start\n2.Quit";

    /*String holding the running program choices*/
    private static String programMenu = "1.Next Day\n2.Quit";

    /**Displays Vacancy sign on console output*/
    public static void displayVacancy() {
        ArrayList<String> vacancySign = textReader( "VacancySign.txt" );
        for( int i = 0; i < vacancySign.size(); i++){
            System.out.println(vacancySign.get(i));
        }
        System.out.println("");
    }

    /**Displays the roachmotel sign on console output*/
    public static void displaySign() {
        ArrayList<String> roachMotelSign = textReader("MotelSign.txt");
        for( int i = 0; i < roachMotelSign.size(); i++){
            System.out.println(roachMotelSign.get(i));
        }
        System.out.println("");
    }

    /**Display the initial menu for our program and grabs a user input
     * @return user inputted number
     */
    public static int initialMenu() {
        displaySign();
        System.out.println(initialMenu);
        int userInput = inputValidation(1,2);
        return userInput;
    }

    /**Displays a no vacancy sign in the console output*/
    public static void displayNoVacancy() {
        ArrayList<String> noVacancySign = textReader("NoVacancySign.txt");
        for( int i = 0; i < noVacancySign.size(); i++){
            System.out.println(noVacancySign.get(i));
        }
        System.out.println("");
    }

    /**Display the main menu for our program and grabs a user input
     * @return user inputted number
     */
    public static int mainMenu() {
        if(RoachMotel.getMotel().isVacant()){
            displayVacancy();
        } else {
            displayNoVacancy();
        }
        System.out.println(programMenu);
        int user_input = inputValidation(1,2);
        return user_input;
    }

    /**
     * Function to read in text from a file
     * @param fileName
     * @return ArrayList of Strings of each line of the text document
     */
    private static ArrayList<String> textReader(String fileName) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Scanner fileRead = new Scanner(new File(fileName));
            while (fileRead.hasNextLine()) {
                String temp = fileRead.nextLine();
                list.add(temp);
            }
        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getStackTrace());
        }
        return list;
    }

    /** validates user input by ensuring they enter an integer in the appropriate range
     * @param lowRange the lowest integer the user is allowed to enter
     * @param highRange the highest integer the user is allowed to enter
     * @return the user's valid input
     */
    public static int inputValidation( int lowRange, int highRange ) {
        Scanner in = new Scanner(System.in);
        int userInput = 0;
        boolean validInput = false;
        while ( !validInput ){ //will loop until valid input is provided
            System.out.print( "Enter option: " );
            if( in.hasNextInt() ) {
                userInput = in.nextInt();
                if( userInput <= highRange && userInput >= lowRange ) {
                    validInput = true; //input within valid range => valid input
                } else {
                    System.out.println( "Invalid Range. Please enter a valid range." );
                }
            } else {
                in.next();
                System.out.println( "Invalid Input. Please enter a valid option." );
            }
        }
        return userInput;
    }

}