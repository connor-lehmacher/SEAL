package math;

public class Matrix2D {
	double[][] matrix, inverse;
	
	public Matrix2D(double[][] m) {


		matrix = new double[][]{{m[0][0], m[0][1]},
				  				{m[1][0], m[1][1]}};
		
		inverse = new double[][]{{m[1][1], -m[0][1]},
					  			 {-m[1][0], m[0][0]}};
		
		scalarInv(det());


		System.out.println(inverse[0][0] + ", " + inverse[0][1]);
		System.out.println(inverse[1][0] + ", " + inverse[1][1]);
		
	}
	
	public double det() {
		return matrix[0][0] * matrix[1][1] -  matrix[0][1] * matrix[1][0];
	}
	
	
	/**Applies a scalar value to the inverse matrix
	 * 
	 * @param sca - a double scalar value
	 */
	public void scalarInv(double sca) {
		
		inverse[0][0] *= sca;
		inverse[0][1] *= sca;
		inverse[1][0] *= sca;
		inverse[1][1] *= sca;
			
	}
	
	/**Applies a scalar value to the regular matrix
	 * 
	 * @param sca - a double scalar value
	 */
	public void scalarMat(double sca) {


		matrix[0][0] *= sca;
		matrix[0][1] *= sca;
		matrix[1][0] *= sca;
		matrix[1][1] *= sca;
		
	}
	
	/**Takes a Point p and translates the point according to the Inverse Matrix
	 * Transforms skewed coordinate into s compatible coordinate
	 * 
	 * @param p - the point to be converted
	 */
	public Point transInv(Point p) {


		double x = inverse[0][0] * p.x + inverse[0][1] * p.y;
		double y = inverse[1][0] * p.x + inverse[1][1] * p.y;
		
		return new Point(x, y);
		
	}
	
	/**Takes a Point p and translates the point according to the Regular Matrix
	 * Transforms computing-compatible coordinate into a skewed coordinate
	 * 
	 * @param p - the point to be converted
	 */
	public Point transMat(Point p) {


		double x = matrix[0][0] * p.x + matrix[0][1] * p.y;
		double y = matrix[1][0] * p.x + matrix[1][1] * p.y;
		
		return new Point(x, y);
		
	}
	
	/**Takes manual coordinates and translates the point according to the Regular Matrix
	 * Transforms computing-compatible coordinate into a skewed coordinate
	 * 
	 * @param x - the x-coordinate of the point to be converted
	 * @param y - the y-coordinate of the point to be converted
	 */
	public Point transMat(double x, double y) {


		return new Point(matrix[0][0] * x + matrix[0][1] * y,
				   		matrix[1][0] * x + matrix[1][1] * y);
		
	}
	
}




