package info5100lab1;
import java.util.ArrayList;
import java.util.Arrays;

public class INFO5100Lab1 {
    public static void main(String[] args) {
        // Lab 1 part 1 - Array
        // Initialize two arrays x and y
        int[] x = {1, 2, 3, 4, 5};
        int[] y = {5, 4, 3, 2, 1};

        // Print the arrays
        System.out.println("Array x = " + Arrays.toString(x));
        System.out.println("Array y = " + Arrays.toString(y));

        // Create an array z to store the max values
        int[] z = new int[5];

        // Compare elements of x and y and store the max in z
        for (int i = 0; i < 5; i++) {
            z[i] = Math.max(x[i], y[i]);
        }

        // Print the max values
        System.out.println("Array z = " + Arrays.toString(z));

        //According to the output, Array z = x + y
        for (int i = 0; i < 5; i++) {
            z[i] = x[i] + y[i];
        }

        // Print the sum of x and y
        System.out.println("Array z = x + y = " + Arrays.toString(z));

        // Lab 1 part 2 - ArrayList
        // Initialize an ArrayList with names
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Vilita", "Shirley", "Ben", "Daniel", "Eva"));

        // Create a new ArrayList to store the names with switched letters
        ArrayList<String> switchedNames = new ArrayList<>();

        // Switch the first and last letters of each name
        for (String name : names) {
            String switchedName = name.substring(name.length() - 1).toUpperCase() +
                                  name.substring(1, name.length() - 1) +
                                  name.substring(0, 1).toLowerCase();
            switchedNames.add(switchedName);
        }

        // Print the original and modified lists of names
        System.out.println("Names = " + names);
        System.out.println("Names (switched) = " + switchedNames);
    }

}
