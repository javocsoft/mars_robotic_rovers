package es.javocsoft.tests.ofertia.marsroboticsrovers.robotics;

import java.util.List;

import es.javocsoft.tests.ofertia.marsroboticsrovers.planet.Plateau;
import es.javocsoft.tests.ofertia.marsroboticsrovers.robotics.Rover.FACING;
import es.javocsoft.tests.ofertia.marsroboticsrovers.utils.ConsoleExtractor;

/**
 * The ship.
 * 
 * @author Javier Gonzalez Serrano
 * @since May, 2015
 * @version 1.0.0
 *
 */
public class Ship {

	
	private Ship() {}
	
	/**
     * Deploys the Rovers given the input line.
     * 
     * @param input
     */
    public static void deployRovers(String input) {
    	
    	Plateau plateau = ConsoleExtractor.getPlateau(input);
    	if(plateau!=null) {
    		//We remove the plateau info from the input command line.
    		input = input.substring(3, input.length());
    		
    		//Extract the control commands
    		List<String> roverPositions = ConsoleExtractor.getRoverPositions(input);
    		List<String> roverCommands = ConsoleExtractor.getRoverCommands(input);
    		
    		if(roverPositions.size()>0 && roverCommands.size()>0 && 
    			roverPositions.size()==roverCommands.size()){
    			
	    		int rCommandIdx = 0;
	        	String rCommand = null;
	        	Rover rover = null;
	        	for(String rPosition:roverPositions){	        		
	        		rCommand = roverCommands.get(rCommandIdx);
	        		rCommandIdx++;
	        		if(rCommand!=null){
	        			rover = new Rover("Rover#" + rCommandIdx, plateau);
	        			try{
		        			String[] rPositionParts = rPosition.split(" ");
		        			rover.setPosition(Integer.valueOf(rPositionParts[0]), Integer.valueOf(rPositionParts[1]), FACING.valueOf(rPositionParts[2]));
		        			rover.process(rCommand);
		        			rover.printPosition();		        			
		        		}catch(Exception e){
		        			System.out.println("Error executing rover '" + rover.getName() +"' command '" + rCommand + ". Skipped.");
		    			}       				
	        		}
	        	}
    		}else{
    			System.out.println("Invalid command line! Aborted.");
    		}
    	}else{
    		System.out.println("No plateau found! Aborted.");
    	}
    }
}
