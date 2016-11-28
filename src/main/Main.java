package main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import math.Matrix2D;
import math.Point;


public class Main {
	public static int width = 10, height = 10;
	public static Point[] points = new Point[15];
	public static Matrix2D defMat;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[][] m = {{Math.sqrt(3)/2, 0},
						{-0.5, 1}};
		
		defMat = new Matrix2D(m);


		points[0] = new Point(100, 100);
		points[1] = new Point(100, 200);
		points[2] = new Point(100, 300);
		points[3] = new Point(200, 200);
		points[4] = new Point(200, 300);
		points[5] = new Point(200, 400);
		points[6] = new Point(300, 200);
		points[7] = new Point(300, 300);
		points[8] = new Point(300, 400);
		points[9] = new Point(400, 300);
		points[10] = new Point(400, 400);
		points[11] = new Point(0, 0);
		points[12] = new Point(0, 100);
		points[13] = new Point(0, 200);
		points[14] = new Point(0, 300);
		
		
		
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
	    		
	    	    printPoint(g, ptp[i]);
	    	}
	    	i++;
	    }


	    Point a = new Point(300, 300);
	    g.setColor(Color.GREEN);
	    printPoint(g, a);
	    
	    a.move(5);
	    g.setColor(Color.YELLOW);
	    printPoint(g, a);
	    
	    a.move(3);
	    g.setColor(Color.ORANGE);
	    printPoint(g, a);
	    
	    a.move(4);
	    g.setColor(Color.RED);
	    printPoint(g, a);
	    
	    a.move(5);
	    g.setColor(Color.MAGENTA);
	    printPoint(g, a);
	    
	    
	}
	
	public void printPoint(Graphics g, Point p) {
		
		Point a = matrix.transMat(p);
		g.fillRect((int)a.x, (int)(500 - a.y), 10, 10);
		
	}


	public Dimension getPreferredSize() {
		return new Dimension(500, 600); // appropriate constants
	}
}




