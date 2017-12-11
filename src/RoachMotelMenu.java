import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/* Authors: Ricardo Alcaraz, Jacob Olsøn, Elizabeth Him
   Purpose: This class was created to display menu options to the console without cluttering our main program
 */

public class RoachMotelMenu {

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

}