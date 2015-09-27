package es.javocsoft.exercise.marsroboticsrovers.robotics;

import es.javocsoft.exercise.marsroboticsrovers.planet.Plateau;


/**
 * An exploration rover implementation to
 * explore a planet.
 * 
 * @author Javier Gonzalez Serrano
 * @since May, 2015
 * @version 1.0.0
 */
public class Rover {

	/** Rover commands */
	public static enum CONTROL_COMMAND {L, R, M};
	/** Rover facing options */
	public static enum FACING {N, E, S, W};
	
	Plateau plateau = null;
	String name = null;
	Integer x = 0;
	Integer y = 0;
	//Default facing is north.
	FACING facing = FACING.N;

	
	/**
	 * Creates a new Rover.
	 * 
	 * @param name
	 */
	public Rover(String name, Plateau plateau) {
		this.name = name;
		this.plateau = plateau;
	}

	/**
	 * Establishes the rover's position.
	 * 
	 * @param x	
	 * @param y
	 * @param facing
	 */
	public void setPosition(Integer x, Integer y, FACING facing) {
		this.x = ensureInPlateauZone(x, plateau.getxMax(), plateau.getyMax());
		this.y = ensureInPlateauZone(y, plateau.getxMax(), plateau.getyMax());;
		this.facing = facing;		
	}

	/**
	 * Prints the rover current position.
	 */
	public void printPosition() {
		System.out.print(x + " " + y + " " + facing.name() + " ");
	}

	/**
	 * Makes rover to process a line of control commands.
	 * 
	 * @param commands	A line with possible control commands. 
	 * 					See {@link CONTROL_COMMAND}
	 */
	public void process(String commands) {
		char command = 0;
		for (int cIdx = 0; cIdx < commands.length(); cIdx++) {
			command = commands.charAt(cIdx); 
			processCommand(command);
		}
	}

	public String getName() {
		return name;
	}
	
	
	//AUXILIAR
	
	private int ensureInPlateauZone(int value, int min, int max) {
		if(value<0)
			value = 0;
		if(value>max)
			value = max;
		
        return value;
    }
	
	private void processCommand(Character command) {
		try {
			CONTROL_COMMAND c = 
					CONTROL_COMMAND.valueOf(String.valueOf(command));
			
			switch (c) {
				case L:
					turnLeft();
					break;
				case R:
					turnRight();
					break;
				case M:
					move();
					break;
			}
			
		}catch(Exception e) {
			throw new IllegalArgumentException("Wrong command, aborted.");
		}
	}
		
	private void move() {
		if (facing == FACING.N) {
			this.y++;
		} else if (facing == FACING.E) {
			this.x++;
		} else if (facing == FACING.S) {
			this.y--;
		} else if (facing == FACING.W) {
			this.x--;
		}
	}
	
	private void turnLeft() {
		switch (facing) {
			case N:
				facing = FACING.W;
				break;
			case E:
				facing = FACING.N;
				break;
			case S:
				facing = FACING.E;
				break;
			case W:
				facing = FACING.S;
		}		
	}

	private void turnRight() {
		switch (facing) {
			case N:
				facing = FACING.E;
				break;
			case E:
				facing = FACING.S;
				break;
			case S:
				facing = FACING.W;
				break;
			case W:
				facing = FACING.N;
		}
	}
	
}
