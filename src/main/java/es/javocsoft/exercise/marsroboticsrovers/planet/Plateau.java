package es.javocsoft.exercise.marsroboticsrovers.planet;

/**
 * 
 * @author Javier Gonzalez Serrano
 * @since May, 2015
 * @version 1.0.0
 *
 */
public class Plateau {

	private Integer xMax;
	private Integer yMax;

	public Plateau(Integer xMax, Integer yMax) {
		super();
		this.xMax = xMax;
		this.yMax = yMax;
	}

	public Integer getxMax() {
		return xMax;
	}

	public Integer getyMax() {
		return yMax;
	}

}
