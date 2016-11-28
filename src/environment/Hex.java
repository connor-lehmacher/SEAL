package environment;


import java.util.ArrayList;


import math.*;
import object.Object;


public class Hex {
	
	public Point location;
	public boolean rockHex, isFilled;
	public double light;
	
	public Hex[] neighbors = new Hex[6];
	
	
	Object fillVal;
	
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
		fillVal = null;
		
		light = 1;
	}
	
	public Object getFillVal() {
		return fillVal;
	}
	
	/**Fills a non-rock Hex tile with either food or a critter
	 * 
	 * @param fill
	 */
	public void fill(Object fill) {
		fillVal = fill;
	}
	
	
	/**Takes a neighboring Hex tile and stores it
	 * Does NOT test if neighbor. Do that before calling this.
	 * 
	 * @param l - the hex tile which is definitely a neighbor
	 */
	public void getNeighbor(Hex l) {


		int dx = (int)(l.location.x - location.x);
		int dy = (int)(l.location.y - location.y);
		
		if (dx != 0)
			dx = dx / Math.abs(dx);
		
		if (dy != 0)
			dy = dy / Math.abs(dy);
		
		
	//Converts position shift into integer direction
		int direction = (2 * ((dx + dy) >> 31) + 1) * (dx - dy) + 1 - 3 * ((dx + dy) >> 31);
		
		neighbors[direction] = l;
		
	}
	
}






