package midtermexam;

public class midtermexamassignment {
    public static void main(String[] args) {
        // Initializing a 2x3 matrix
        int[][] matrix = {
            {7, 3, 1},
            {2, 9, 6}
        }; 

        // Variable to store the sum of elements
        int sum = 0;

        // Nested loops to iterate through each element of the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }

        // Output the sum
        System.out.println("The sum of all matrix elements is: " + sum);
    }
}
