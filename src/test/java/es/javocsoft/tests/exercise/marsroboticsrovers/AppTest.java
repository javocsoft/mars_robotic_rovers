package es.javocsoft.tests.exercise.marsroboticsrovers;

import es.javocsoft.exercise.marsroboticsrovers.planet.Plateau;
import es.javocsoft.exercise.marsroboticsrovers.robotics.Rover;
import es.javocsoft.exercise.marsroboticsrovers.robotics.Rover.FACING;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 * 
 * @author Javier Gonzalez Serrano
 * @since May, 2015
 * @version 1.0.0
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
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
    
    public void testMarsRovers() {
    	Plateau plateau = new Plateau(5, 5);
    	
    	Rover rover1 = new Rover("mars_rover1", plateau);
		rover1.setPosition(1, 2, FACING.N);
		rover1.process("LMLMLMLMM");
		rover1.printPosition(); // prints 1 3 N

		Rover rover2 = new Rover("mars_rover2", plateau);
		rover2.setPosition(3, 3, FACING.E);
		rover2.process("MMRMMRMRRM");
		rover2.printPosition(); // prints 5 1 E
    }
}
