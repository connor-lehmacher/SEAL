package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {
	public static int width = 10, height = 10;
	public static Point[] points = new Point[15];
	public static Matrix2D defMat;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[][] m = {{Math.sqrt(3)/2, 0},
						{-0.5, 1}};
		
		defMat = new Matrix2D(m);


		points[0] = defMat.transMat((new Point(100, 100)));
		points[1] = defMat.transMat((new Point(100, 200)));
		points[2] = defMat.transMat((new Point(100, 300)));
		points[3] = defMat.transMat((new Point(200, 200)));
		points[4] = defMat.transMat((new Point(200, 300)));
		points[5] = defMat.transMat((new Point(200, 400)));
		points[6] = defMat.transMat((new Point(300, 200)));
		points[7] = defMat.transMat((new Point(300, 300)));
		points[8] = defMat.transMat((new Point(300, 400)));
		points[9] = defMat.transMat((new Point(400, 300)));
		points[10] = defMat.transMat((new Point(400, 400)));
		points[11] = defMat.transMat((new Point(0, 0)));
		points[12] = defMat.transMat((new Point(0, 100)));
		points[13] = defMat.transMat((new Point(0, 200)));
		points[14] = defMat.transMat((new Point(0, 300)));
		
		
		
		printPoints(points);
	}
	
	
	
	
	
	
	
	
	public static void printPoints(Point[] points) {
		JPanel content = new JPanel();
        PointDraw newrect= new PointDraw(points, defMat);
        content.add(newrect);
        JFrame window = new JFrame("GUI Test");
        window.setContentPane(content);
        window.setSize(500, 600);
        window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}


class PointDraw extends JPanel {
	
	Point[] ptp;
	Matrix2D matrix;
	
	public PointDraw(Point[] ps, Matrix2D m) {
		ptp = ps;
		matrix = m;
	}
	
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.setColor(Color.BLUE);
	    
	    int i = 0;
	    while (i < ptp.length) {
	    	if (ptp[i] != null) {
	    		
	    		System.out.println(i + ":   " + ptp[i].x + ", " + ptp[i].y);
	    		
	    		g.fillRect((int)ptp[i].x, (int)(500 - ptp[i].y), 10, 10);
	    	}
	    	i++;
	    }


	    Point a = matrix.transMat(new Point(300, 300));
	    g.setColor(Color.GREEN);
	    g.fillRect((int)a.x, (int)(500 - a.y), 10, 10);
	    
	    a.move(5, matrix);
	    g.setColor(Color.YELLOW);
	    g.fillRect((int)a.x, (int)(500 - a.y), 10, 10);
	    
	    a.move(3, matrix);
	    g.setColor(Color.ORANGE);
	    g.fillRect((int)a.x, (int)(500 - a.y), 10, 10);
	    
	    a.move(4, matrix);
	    g.setColor(Color.RED);
	    g.fillRect((int)a.x, (int)(500 - a.y), 10, 10);
	    
	    a.move(5, matrix);
	    g.setColor(Color.MAGENTA);
	    g.fillRect((int)a.x, (int)(500 - a.y), 10, 10);
	    
	    
	}


	public Dimension getPreferredSize() {
		return new Dimension(500, 600); // appropriate constants
	}
}
