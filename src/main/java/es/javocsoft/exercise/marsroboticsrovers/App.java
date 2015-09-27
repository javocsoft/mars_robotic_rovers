package es.javocsoft.exercise.marsroboticsrovers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import es.javocsoft.exercise.marsroboticsrovers.robotics.Ship;

/**
 * Main program for Mars Rover.
 *
 * @author Javier Gonzalez Serrano
 * @since May, 2015
 * @version 1.0.0
 */
public class App 
{
	
	/**
	 * Runs the program.
	 * 
	 * INPUT: 				5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM
     * EXPECTED OUTPUT: 	1 3 N 5 1 E
     * 
	 * @param args
	 */
    public static void main( String[] args )
    {
    	String input = "";
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.print("Enter command line (quit to abort)>");
    	try{
	    	do{
	    		input = br.readLine();
	    		if(!input.equalsIgnoreCase("quit")){
	    			Ship.deployRovers(input);
	    		}
	    	}while(!input.equalsIgnoreCase("quit"));
	    	
    	}catch(Exception e){
    		System.out.println("Error getting command prompt! Aborted [" + e.getMessage() + "]");
    	}finally {
    		try {
				br.close();
			} catch (IOException e) {}
    	}
    }
    
    
    
    
    
}
