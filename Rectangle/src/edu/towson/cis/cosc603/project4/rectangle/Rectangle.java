package edu.towson.cis.cosc603.project4.rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class Rectangle.
 */
public class Rectangle {
	
	/** The p2. */
	private Point p1, p2;
	
	/**
	 * Instantiates a new rectangle.
	 *
	 * @param p1 the p1
	 * @param p2 the p2
	 */
	Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public Double getArea() {
		
		double height = 0.0;
		double length = 0.0;
		
		height = getHeight();
		length = getLength();
		
		return height * length;
	}
	
	/**
	 * Gets the diagonal.
	 *
	 * @return the diagonal
	 */
	public Double getDiagonal() {
		
		double height = 0.0;
		double length = 0.0;
		
		height = getHeight();
		length = getLength();
		
		/*
		 * Pythagorean Theorem
		 * a^2 + b^2 = c^2
		 * c = sqrt(a^2 + b^2)
		 */
		return Math.sqrt(Math.pow(height, 2) + Math.pow(length, 2));
	}
	
	public Double getHeight(){
		
		return ( Math.abs(p2.y - p1.y));
		
	}
	
	public Double getLength(){
		
		return ( Math.abs(p2.x - p1.x));
		
	}
}
