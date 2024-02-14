package edu.neu.mgen;

import java.util.ArrayList;
import java.util.List;

/**
 * HW to Chapter 5 "Data Structures"
 * Programming Assignment
 */
public class JINGCAOHWtoChapter5 {
    public static void main(String[] args) {
        // String operations
        String str = "Oakland";
        int length = str.length();
        char charAtTwo = str.charAt(2);

        String substringLand = "";
        if (str.contains("land")) {
            substringLand = str.substring(str.indexOf("land"));
        }

        String upperCaseStr = str.toUpperCase();

        System.out.println("Length of the string: " + length);
        System.out.println("Character at index 2: " + charAtTwo);
        System.out.println("Substring 'land': " + substringLand);
        System.out.println("All letters in capital: " + upperCaseStr);

        System.out.println("--------------------");

        // Array operations
        int[] abc = {1, 3, 5, 2, 5};
        int arrayLength = abc.length;
        int lastMember = abc[arrayLength - 1];  // Using arrayLength variable for clarity

        System.out.println("Length of the array: " + arrayLength);
        System.out.println("Last member of the array: " + lastMember);

        System.out.println("--------------------");

        // ArrayList operations
        List<String> cityList = new ArrayList<>();
        cityList.add("Austin");
        cityList.add("Houston");
        cityList.add("Oakland");
        cityList.add("Paris");
        cityList.add("San Francisco");
        cityList.add("Seattle");

        // Remove "Paris" from the ArrayList
        boolean isRemoved = cityList.remove("Paris");
        System.out.println("Was 'Paris' removed? " + isRemoved);
        System.out.println("ArrayList after removing 'Paris': " + cityList);
    }
}
