package com.georgioskachrimanis.javacourse;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    System.out.println("The program is now ending.\nHave a nice day.");
                    quit = true;
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("Press: ");
        System.out.println("\t0 - To choose Options.");
        System.out.println("\t1 - To print the grocery list.");
        System.out.println("\t2 - To add an item to the list.");
        System.out.println("\t3 - To Modify an item of the list.");
        System.out.println("\t4 - To Remove an item from the list.");
        System.out.println("\t5 - To Search the list.");
        System.out.println("\t6 - To process List.");
        System.out.println("\t7 - To quit the program.");

    }

    public static void addItem() {
        System.out.print("Please enter the new grocery item:\n");
        String newItem = scanner.nextLine();
        groceryList.addGroceryItem(newItem);
    }

    private static void modifyItem() {
        System.out.print("Enter the item you want to modify: ");
        String currentItem = scanner.nextLine();
        if (groceryList.inList(currentItem)) {
            System.out.println("Enter the new item: ");
            String newItem = scanner.nextLine();
            groceryList.modifyGroceryItem(currentItem, newItem);
        }
    }

    private static void removeItem() {
        System.out.print("Enter the item you want removed: ");
        String item = scanner.nextLine();
        groceryList.removeItem(item);
    }

    private static void searchForItem() {
        System.out.print("Enter the item you want to search: ");
        String searchItem = scanner.nextLine();
        if (groceryList.inList(searchItem)) {
            System.out.println("The " + searchItem + ", was found in your grocery list.");
        } else {
            System.out.println(searchItem + ", is not in the grocery list.");
        }
    }

    public static void processArrayList() {
        // Ways to copy an array. Mainly to get used to use the build in functions of Java to work for us.

        ArrayList<String> newArray = new ArrayList<>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<>(groceryList.getGroceryList());

        // The last code is to return/convert a list into an array.
        // Still is a bit complicated and have to see it to understand it.
        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}


