package math;


public class Point {
	public double x, y;
	
	public Point(double x, double y) {
		
		this.x = x;
		this.y = y;
	}
	
	/**Takes an integer direction and translation matrix and moves a skewed point
	 * Includes an auto-conversion for the skew (hence the required matrix)
	 * 
	 * @param hexDirection - an integer from 0 to 5
	 * @param transMat - the translation matrix used to skew this point
	 */
	
	public void move(int hexDirection) {
		
		int MOVE_UNIT = 17;


		x += MOVE_UNIT * (((hexDirection + 1) % 3) - 1) * (2 * (hexDirection % 2) - 1);
		y += MOVE_UNIT * (((6 - hexDirection) % 3) - 1) * (2 * (hexDirection % 2) - 1);
		
	}
	
	
	
}






