package edu.neu.mgen;

import java.util.Scanner;

/**
 * Hello world!
 *
 */

// This is my first Java program
public class HWtoChapter4 
{
    public static void main( String[] args )
    {
        /* I plan to print "It is my first Java program!" on the screen
            * I will use System.out.println() to print the string
        */
        System.out.println("HWtoChapter4");

        // Declare and initialize variables of types "int", "long", "double", "boolean", and "char".
        int attendees = 150;
        int pagesInBook = 300;

        long worldPopulation = 7800000000L;
        long lightYearDistance = 5878625373183L;

        double diveDepth = 36.5;
        double fuelInTank = 52.3;

        boolean isLightOn = true;
        boolean isLoggedIn = false;

        char initial = 'J';
        char testGrade = 'A';

        // Convert initialized variables of type "int" to "long".
        long longAttendees = attendees;
        long longPages = pagesInBook;

        // Convert initialized variables of type "long" to "int".
        int intWorldPop = (int) worldPopulation;
        int intLightYear = (int) lightYearDistance;

        // Enter values for variables from the terminal.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of attendees: ");
        attendees = scanner.nextInt();

        // Perform arithmetic operations
        int sumOfAttendeesAndPages = attendees + pagesInBook;
        long distanceSum = worldPopulation + lightYearDistance;
        double totalDepthAndFuel = diveDepth + fuelInTank;

        // Logical operations
        boolean bothLightsOn = isLightOn && isLoggedIn; // Assuming 'isLoggedIn' implies a second 'light'
        boolean eitherCondition = isLightOn || isLoggedIn;

        // Printing arithmetic results
        System.out.println("Sum of attendees and pages: " + sumOfAttendeesAndPages);
        System.out.println("Total distance: " + distanceSum);
        System.out.println("Total depth and fuel: " + totalDepthAndFuel);

        // Printing logical operation results
        System.out.println("Both lights on: " + bothLightsOn);
        System.out.println("Either condition true: " + eitherCondition);

        // Close scanner
        scanner.close();
    }
}
    
    

