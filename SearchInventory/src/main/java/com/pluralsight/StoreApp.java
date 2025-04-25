package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args) {
        //call the get inventory method to get our products
        ArrayList<Product> inventory = getInventory();

        boolean appRunning = true;
        while (appRunning) {

            int mainMenuChoice = mainMenu();

            switch (mainMenuChoice) {
                case 1:
                    //display all the products
                    displayAllProducts(inventory);
                    break;
                case 2:
                    int productID = productByIdMenu();
                    displayProductById(inventory, productID);
                    break;
                case 5:
                    //exit the app
                    System.out.println("Goodbye!");
                    appRunning = false;
                    break;
            }

        }


    }

    //our getInventory method that create an array-list of products and returns it
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        //use getFileReader() to get us a buffered reader for inventory.csv
        BufferedReader inventoryCsv = getFileReader("inventory.csv");

        //read the file line by line
        try {

            String line;
            while ((line = inventoryCsv.readLine()) != null) {
                //split the line into the individual product parts
                String[] productParts = line.split("\\|");
                //generate a new product using the correct data types for the product attributes
                Product newProduct = new Product(Integer.parseInt(productParts[0]), productParts[1], Float.parseFloat(productParts[2]));
                //add the product to our inventory ArrayList
                inventory.add(newProduct);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //sort inventory in alphbetical order using a comparator referencing Product::getName
        Collections.sort(inventory, Comparator.comparing(Product::getName));

        //return the inventory
        return inventory;
    }

    //method to get a file reader by passing in the file name for a file in src/main/resources
    public static BufferedReader getFileReader(String fileName) {

        try {

            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader("src/main/resources/" + fileName);
            // create a BufferedReader to manage input stream
            return new BufferedReader(fileReader);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static void displayAllProducts(ArrayList<Product> inventory) {

        //start user messaging
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }

    }

    public static void displayProductById(ArrayList<Product> inventory, int id) {

        //start user messaging
        System.out.println("These are the products that match Product ID " + id +":  ");
        String output = "";
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            if(p.getId() == id){
                output += String.format("id: %d %s - Price: $%.2f%n",
                        p.getId(), p.getName(), p.getPrice());
            }
        }

        if(output.equals("")){
            System.out.println("No products found for the provided ID!");
        }else{
            System.out.println(output);
        }



    }

    public static int mainMenu() {

        //create the scanner to use to capture user input
        Scanner theScanner = new Scanner(System.in);

        // Default to invalid value to start
        int choice = -1;

        while (true) {
            //ask the user what they want to do
            System.out.println("What do you want to do?\n" +
                    "1-List all products\n" +
                    "2-Lookup a product by its id\n" +
                    "3-Find all products within a price range\n" +
                    "4-Add a new product\n" +
                    "5-Quit the application Enter command:"
            );

            if (theScanner.hasNextInt()) {
                choice = theScanner.nextInt();
                theScanner.nextLine(); // consume the newline
                break;
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                theScanner.nextLine(); // clear the invalid input
            }

        }

        //return the valid choice
        return choice;
    }

    public static int productByIdMenu() {
        Scanner theScanner = new Scanner(System.in);
        int productID;

        while (true) {
            System.out.println("What is the product id?");

            if (theScanner.hasNextInt()) {
                productID = theScanner.nextInt();
                // consume the newline
                theScanner.nextLine();
                break; // valid input, exit the loop
            } else {
                System.out.println("Invalid input. Please enter a numeric product ID.");
                // discard invalid input
                theScanner.nextLine();
            }
        }

        return productID;
    }

}