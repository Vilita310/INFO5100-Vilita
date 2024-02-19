package edu.neu.mgen;

import java.util.Scanner;


public class HWtoChapter6 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the terminal
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a word
        System.out.print("Enter any word: ");
        
        // Record the start time
        long startTime = System.currentTimeMillis();
        
        // Read the user's input
        String word = scanner.nextLine();
        
        // Record the end time
        long endTime = System.currentTimeMillis();

        // Check if the user entered a word
        if (word.isEmpty()) {
            System.out.println("You did not enter any word");
            scanner.close();
            return;
        }

        // Calculate the length of the entered word
        int length = word.length();
        
        // Calculate the elapsed time in seconds
        long elapsedSeconds = (endTime - startTime) / 1000;
        
        // Classify the word based on its length
        String classification;
        if (length <= 5) {
            classification = "short";
        } else if (length <= 10) {
            classification = "medium";
        } else {
            classification = "long";
        }

        // Print the results
        System.out.println("Your word is " + word);
        System.out.println("The length of the word is " + length);
        System.out.println("It is a " + classification + " word");
        System.out.println("Your reaction time is " + elapsedSeconds + " seconds");

        // Close the scanner
        scanner.close();
    }
}
