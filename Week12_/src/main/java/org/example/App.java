package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Create instances of our classes
        LoopControl loopControl = new LoopControl();
        ExampleUsage exampleUsage = new ExampleUsage();

        // Demonstrate LoopControl methods
        System.out.println("Sum of squares (1-10): " + loopControl.sumOfSquares());
        
        System.out.println("\nPrinting triangle:");
        loopControl.printTriangle();
        
        System.out.println("\nDemonstrating incorrect loop variable modification:");
        loopControl.modifyIndexIncorrectly();

        // Demonstrate ExampleUsage methods
        System.out.println("\nNumber of even numbers (1-20): " + 
            exampleUsage.filterAndCountEvenNumbers());
        
        System.out.println("Sum of matrix diagonal: " + 
            exampleUsage.matrixDiagonalSum());
    }
}
