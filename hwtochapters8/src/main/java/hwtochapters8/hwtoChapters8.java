package hwtochapters8;

public class hwtoChapters8 {

    public static String[] reverseArrayAndStrings(String[] originalArray) {
        String[] reversedArray = new String[originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            // Reverse the string and capitalize the first letter
            String reversedString = new StringBuilder(originalArray[i]).reverse().toString();
            reversedString = reversedString.substring(0, 1).toUpperCase() + reversedString.substring(1).toLowerCase();

            // Store the reversed string in the new array
            reversedArray[originalArray.length - 1 - i] = reversedString;
        }

        return reversedArray;
    }

    public static void printArray(String[] array, String arrayType) {
        System.out.println(arrayType + " array:");
        for (String element : array) {
            System.out.println("\"" + element + "\",");
        }
        System.out.println("End of the array\n");
    }

    public static void main(String[] args) {
        String[] originalArray1 = {"Anne", "John", "Alex", "Jessica"};
        String[] originalArray2 = {"Sun", "Mercury", "Venis", "Earth", "Mars", "Jupiter"};

        String[] reversedArray1 = reverseArrayAndStrings(originalArray1);
        String[] reversedArray2 = reverseArrayAndStrings(originalArray2);

        printArray(originalArray1, "Original");
        printArray(reversedArray1, "Resultant");

        printArray(originalArray2, "Original");
        printArray(reversedArray2, "Resultant");
    }


}
