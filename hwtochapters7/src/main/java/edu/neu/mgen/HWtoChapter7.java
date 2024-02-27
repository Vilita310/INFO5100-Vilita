package edu.neu.mgen;


public class HWtoChapter7 {
    public static void main(String[] args) {
        // Define two matrices A and B
        int[][] A = {{2, 3, 4}, {3, 4, 5}};
        int[][] B = {{1, 2}, {3, 4}, {5, 6}};
        
        // Initialize the result matrix C with the appropriate dimensions
        int[][] C = new int[A.length][B[0].length];

        // Check if the number of columns in A is equal to the number of rows in B
        if (A[0].length == B.length) {
            // Perform matrix multiplication
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    for (int k = 0; k < A[0].length; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }

            // Print the result matrix C
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[0].length; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            // Print an error message if the matrices cannot be multiplied
            System.out.println("The matrices cannot be multiplied");
        }
    }
}

