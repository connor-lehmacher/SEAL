package environment;


import math.*;


public class Hex {
	
	Point location;
	boolean rockHex, isFilled;
	
	/**Takes a Point p which is the tile's location
	 * Takes a boolean value which stores whether the  
	 * tile is a rock hex or not (true if rock)
	 * 
	 * @param p
	 * @param isRock
	 */
	public Hex(Point p, boolean isRock) {
		location = p;
		rockHex = isRock;
		isFilled = isRock;
	}
	
	public void fill() {
		
	}
	
}




