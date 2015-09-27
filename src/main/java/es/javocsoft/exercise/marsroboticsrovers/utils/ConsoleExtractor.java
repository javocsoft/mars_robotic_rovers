package es.javocsoft.exercise.marsroboticsrovers.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.javocsoft.exercise.marsroboticsrovers.planet.Plateau;

/**
 * A command prompt line control extractor.
 * 
 * @author Javier Gonzalez Serrano
 * @since May, 2015
 * @version 1.0.0
 *
 */
public class ConsoleExtractor {
	
	private static final String REGEX_PlATEAU = "([0-9] [0-9])?";
	private static final String REGEX_ROVER_POSITION = "([0-9] [0-9] [A-Z])+";
	private static final String REGEX_ROVER_COMMANDS = "([LRM])+";
	
	
	private ConsoleExtractor(){}
	
	public static Plateau getPlateau(String input) {
		Plateau plateau = null;
		
		try{
			Pattern pattern = Pattern.compile(REGEX_PlATEAU);
			Matcher matcher = pattern.matcher(input);    	
			if(matcher.find()){
				String plateauInfo = matcher.group(0);
				if(plateauInfo!=null && plateauInfo.length()>0) {
					String[] plateauLimits = plateauInfo.split(" ");
					plateau = new Plateau(Integer.parseInt(plateauLimits[0]), Integer.parseInt(plateauLimits[1]));
				}
			}
		}catch(Exception e) {
			System.out.println("Error establishing plateau configuration [" + e.getMessage() + "]");
		}
		
		return plateau;
	}
	
	public static List<String> getRoverPositions(String input) {
		List<String> roverPositions = new ArrayList<String>();
		
		try{
			Pattern pattern = Pattern.compile(REGEX_ROVER_POSITION);
			Matcher matcher = pattern.matcher(input);    	
			while (matcher.find()){
				String roverPosition = matcher.group(0);
	    		if(roverPosition!=null && roverPosition.length()>0)
	    			roverPositions.add(roverPosition);
	    	}
		}catch(Exception e) {
			roverPositions.clear();
			System.out.println("Error getting rover positions from input string [" + e.getMessage() + "]");
		}
		
		return roverPositions;
	}
	
	public static List<String> getRoverCommands(String input) {
		List<String> roverCommands = new ArrayList<String>();
		
		try{
			Pattern pattern = Pattern.compile(REGEX_ROVER_COMMANDS);
			Matcher matcher = pattern.matcher(input);    	
			while (matcher.find()){
				String roverCommand = matcher.group(0);
	    		if(roverCommand!=null && roverCommand.length()>0)
	    			roverCommands.add(roverCommand);
	    	}
		}catch(Exception e) {
			roverCommands.clear();
			System.out.println("Error getting rover commands from input string [" + e.getMessage() + "]");
		}
		
		return roverCommands;
	}
	
}