package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class BedtimeStoryApp {

    static Scanner userInputScanner = new Scanner(System.in);

    public static void main(String[] args) {

        try{

            //ask the user what story they want to see
            System.out.print("Enter the name of a story:");

            //store their answer in a variable
            String whichStory = userInputScanner.nextLine();

            //try to open the file and pass it to the scanner
            FileInputStream fis = new FileInputStream("src/main/resources/" + whichStory);
            Scanner fileScanner = new Scanner(fis);

            //loop that checks to make sure we have a line or next lines in our file
            //prints the lines out if they exist
            int lineNumber = 1;
            while(fileScanner.hasNextLine()) {
                //print out each line in the file
                System.out.println(lineNumber + ": " + fileScanner.nextLine());
                lineNumber++;
            }


        }catch (Exception e){
            //if things fail, let the user know
            System.out.println("Story does not exist");
        }






    }

}
