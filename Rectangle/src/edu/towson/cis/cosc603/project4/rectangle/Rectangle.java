package edu.towson.cis.cosc603.project4.rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class Rectangle.
 */
public class Rectangle {
	
	/** The p2. */
	private Point p1, p2;
	private Double height, length;
	
	/**
	 * Instantiates a new rectangle.
	 *
	 * @param p1 the p1
	 * @param p2 the p2
	 */
	Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		
		calculateHeight();
		calculateLength();
	}
	
	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public Double getArea() {
		
		return ( height * length );
	}
	
	/**
	 * Gets the diagonal.
	 *
	 * @return the diagonal
	 */
	public Double getDiagonal() {
		
		/*
		 * Pythagorean Theorem
		 * a^2 + b^2 = c^2
		 * c = sqrt(a^2 + b^2)
		 * a is the height
		 * b is the length
		 * 
		 */
		return (Math.sqrt(Math.pow(height, 2) + Math.pow(length, 2)));
	}
	
	/**
	 * Gets the Height
	 * 
	 * @return
	 */
	public void calculateHeight(){
		
		height = Math.abs(p2.y - p1.y);
		
	}
	
	/**
	 * Gets the Length
	 * 
	 * @return
	 */
	public void calculateLength(){
		
		length = Math.abs(p2.x - p1.x);
		
	}
}
