package com.pluralsight;

import java.util.Scanner;

public class theApp {

    public static void main(String[] args) {

        boolean appRunning = true;

        Scanner theScanner = new Scanner(System.in);

        String[] quotes = {
                "The only thing we have to fear is fear itself. – Franklin D. Roosevelt",
                "That's one small step for man, one giant leap for mankind. – Neil Armstrong",
                "In the middle of difficulty lies opportunity. – Albert Einstein",
                "To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment. – Ralph Waldo Emerson",
                "Success is not final, failure is not fatal: It is the courage to continue that counts. – Winston Churchill",
                "You must be the change you wish to see in the world. – Mahatma Gandhi",
                "Life is what happens when you're busy making other plans. – John Lennon",
                "I think, therefore I am. – René Descartes",
                "The journey of a thousand miles begins with one step. – Lao Tzu",
                "Imagination is more important than knowledge. – Albert Einstein"
        };

        while(appRunning) {

            try {
                //ask the user for a number
                System.out.println("Please give me a number between 1 and 10");
                int numberSelected = theScanner.nextInt();

                //print out the quote that matches the numnber, remember to subtract 1 since
                //the user is counting from 1 and the list starts at 0
                System.out.println(quotes[numberSelected - 1]);
            } catch (Exception e) {
                System.out.println("something went wrong but lets start over");
                continue;
            }

            //eat the leftover newline
            theScanner.nextLine();

            System.out.println("Do you want to choose another quote? (y/n)");
            String userAnswer = theScanner.nextLine();


            if(userAnswer.equalsIgnoreCase("y")){
                continue;
            }else{
                appRunning = false;
            }



        }

    }

}
