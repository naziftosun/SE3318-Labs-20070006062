package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Simple test class for our application.
 */
public class AppTest extends TestCase {
    private LoopControl loopControl;
    private ExampleUsage exampleUsage;

    protected void setUp() {
        loopControl = new LoopControl();
        exampleUsage = new ExampleUsage();
    }

    public void testSumOfSquares() {
        assertEquals(385, loopControl.sumOfSquares());
    }

    public void testFilterAndCountEvenNumbers() {
        assertEquals(10, exampleUsage.filterAndCountEvenNumbers());
    }

    public void testMatrixDiagonalSum() {
        assertEquals(15, exampleUsage.matrixDiagonalSum());
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
