package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class theApp {

    public static void main(String[] args) {

        try{

            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);

            //creating a variable to hold the input
            String theLine;
            while((theLine = bufReader.readLine()) != null) {

                String[] inputParts = theLine.split("\\|");

                //check to see if the first part of the line is equal to id
                if(inputParts[0].equals("id")){
                    continue;
                }

                //create the employee with the data we parsed from the csv line
                Employee theEmployee = new Employee(Integer.parseInt(inputParts[0]), inputParts[1], Double.parseDouble(inputParts[2]), Double.parseDouble(inputParts[3]) );

                //print out the info to the user
                System.out.printf("%d - %s - $%.2f\n", theEmployee.getEmployeeId(), theEmployee.getName(), theEmployee.getGrossPay());

            }

            //close the buffer(file)
            bufReader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
