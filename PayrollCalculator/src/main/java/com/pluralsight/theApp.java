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

            String input;
            while((input = bufReader.readLine()) != null) {

                String[] inputParts = input.split("\\|");
                if(inputParts[0].equals("id")){
                    continue;
                }

                Employee theEmployee = new Employee(Integer.parseInt(inputParts[0]), inputParts[1], Double.parseDouble(inputParts[2]), Double.parseDouble(inputParts[3]) );

                System.out.printf("%d - %s - $%.2f\n", theEmployee.getEmployeeId(), theEmployee.getName(), theEmployee.getGrossPay());

            }

            bufReader.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
