package org.example;


public class ExampleUsage {
    
    /**
     * Filters and counts even numbers in an array.
     * @return count of even numbers
     */
    public int filterAndCountEvenNumbers() {
        int[] numbers = new int[20];
        for (int i = 0; i < 20; i++) {
            numbers[i] = i + 1;
        }
        
        int evenCount = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;

            }

        }
        return evenCount;
    }

    /**
     * Calculates the sum of diagonal elements in a 3x3 matrix.
     * @return sum of diagonal elements
     */
    public int matrixDiagonalSum() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += matrix[i][i];
        }
        return sum;

    }
}
