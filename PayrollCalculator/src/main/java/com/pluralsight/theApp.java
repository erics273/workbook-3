package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class theApp {

    public static void main(String[] args) {

        try{

            Scanner theScanner = new Scanner(System.in);

            System.out.println("Enter the name of the file employee file to process:");
            String inputFile = theScanner.nextLine();

            System.out.println("Enter the name of the payroll file to create:");
            String outputFile = theScanner.nextLine();

            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader("src/main/resources/" + inputFile);
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);

            // create a FileWriter
            FileWriter fileWriter = new FileWriter("src/main/resources/" + outputFile);
            // create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            //call the write methodn on the bufWriter
            bufWriter.write("id|name|gross pay\n");

            String input;
            while((input = bufReader.readLine()) != null) {

                String[] inputParts = input.split("\\|");

                //get rid of the first row
                if(inputParts[0].equals("id")){
                    continue;
                }

                Employee theEmployee = new Employee(Integer.parseInt(inputParts[0]), inputParts[1], Double.parseDouble(inputParts[2]), Double.parseDouble(inputParts[3]) );

              //  String output = String.format("%d|%s|%.2f\n", theEmployee.getEmployeeId(), theEmployee.getName(), theEmployee.getGrossPay());
                String poop = theEmployee.getEmployeeId() +"|"+theEmployee.getName()+"|"+theEmployee.getGrossPay();

                bufWriter.write(poop);
                //System.out.printf("%d - %s - $%.2f\n", theEmployee.getEmployeeId(), theEmployee.getName(), theEmployee.getGrossPay());

            }

            bufReader.close();
            bufWriter.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
