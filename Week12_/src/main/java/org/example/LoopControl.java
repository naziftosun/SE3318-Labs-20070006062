package org.example;

public class LoopControl {
    public int sumOfSquares() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i * i;
        }
        return sum;

    }

    public void printTriangle() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    public void modifyIndexIncorrectly() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                i++; // This is incorrect - modifying loop variable
            }
            System.out.println("Value: " + i);

        }


    }

    public void avoidEmptyBlock() {
        for (int j = 0; j < 10; j++) {
            if (j == 5) {
                System.out.println("Midpoint at: " + j);
            } else {

            }
        }
    }

    public void modifiedControlVariable() {
        for (int m = 0; m < 10; m++) {
            if (m == 5) {
                System.out.println("Adjusting loop index from " + m);
                m += 3; // Incorrect - modifying control variable inside the loop
                System.out.println("to " + m);
            }
        }
    }
}
