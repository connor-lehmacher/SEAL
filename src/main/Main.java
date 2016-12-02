package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JPanel;


import math.*;
import environment.*;
import object.*;


public class Main {
	public static int width = 50, height = 68, tileWidth = 17;
	public static Matrix2D defMat;
	public static ArrayList<Hex> board = new ArrayList<Hex>();
	public static Critter guy;
	
	public static void main(String[] args) {
		
		defMat = new Matrix2D(new double[][]{{Math.sqrt(3)/2, 	0},
											 {-0.5, 			1}});
		
		//Board initializer
		Point end = defMat.transMat(width * tileWidth, height * tileWidth);
		
		int i = 0;
		while (i < height * tileWidth) {
			
			int j = 0;
			Point a = defMat.transMat(j, i);
			
			while (a.x >= 0 && j < width * tileWidth) {
				
				if (a.y >= 0 && a.y < end.y) {
					board.add(new Hex(new Point(j, i), false));
				}
				
				j += tileWidth;
				a = defMat.transMat(j, i);
			}
			i += tileWidth;
		}
		
		//Finds and stores neighbors
		for(Hex l : board) {
			for (Hex k : board) {
				double dx = l.location.x - k.location.x;
				double dy = l.location.y - k.location.y;
				
				if (l != k && dx * dy >= 0) {
					if (dx * dx + dy * dy <= 2.1 * tileWidth * tileWidth) {
						l.getNeighbor(k);
					}
				}
				
			}
			
		}
		
		int s = board.size();
		int r = (int)(Math.sqrt(s) + s) / 2;
		
		
		guy = new Critter(0, 0, board.get(r), 1, 1, null);
		
		printPoints(board);
	}
	
	public static void printPoints(ArrayList<Hex> board) {
		JPanel content = new JPanel();
        PointDraw newrect= new PointDraw(board, defMat, guy);
        content.add(newrect);
        JFrame window = new JFrame("GUI Test");
        window.setContentPane(content);
        window.setSize(1200, 810);
        window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}


@SuppressWarnings("serial")
class PointDraw extends JPanel {
	
	public static int tileWidth = 17;


	double r3 = Math.sqrt(3) - 0.1;
	double m = tileWidth / (r3);


	//Stored points of the polygon (hexagon) printed over every tile
    int[] xPoints = {(int)m, 
    				 (int)(0.5 * m),
    				 (int)(-0.5 * m), 
    				 (int)(-m), 
    				 (int)(-0.5 * m), 
    				 (int)(0.5 * m)};
    
    int[] yPoints = {0, 
    				 (int)(r3 * m * 0.5), 
    				 (int)(r3 * m * 0.5), 
    				 0, 
    				 (int)(-r3 * m * 0.5), 
    				 (int)(-r3 * m * 0.5)};
    
    Polygon p = new Polygon(xPoints, yPoints, 6);
    
	ArrayList<Hex> board;
	Matrix2D matrix;
	Critter guy;
	
	public PointDraw(ArrayList<Hex> b, Matrix2D m, Critter c) {
		board = b;
		matrix = m;
		guy = c;
	}
	
	protected void paintComponent(Graphics g) {
		
	    super.paintComponent(g);
	    
	    Color[] shades = {Color.RED,
	    				  Color.ORANGE,
	    				  Color.YELLOW,
	    				  Color.GREEN,
	    				  Color.CYAN,
	    				  Color.BLUE,
	    				  Color.MAGENTA};
	    
	    Random rn = new Random();
	    
	    int k = 0;
	    while (k < 1000){    
		    g.setColor(shades[k % 7]);
		    
		    int v = rn.nextInt(3);
		    int t = rn.nextInt(6);
		    
		   	guy.turn(t == 0);
		    
		  	guy.move(v == 0);
		    
		    printCritter(g, guy.location);
		    
			k++;
		}


	    g.setColor(Color.BLUE);
	    for (Hex l: board) {
	    	printTile(g, l.location);
	    }
	}
	
	/**Graphically prints un critter
	 * Give critter's computational location
	 * 
	 * @param g - Graphics object
	 * @param p - Point location of the tile (COMPUTATIONAL)
	 */
	public void printCritter(Graphics g, Point p) {
		
		Point a = matrix.transMat(p);
		
		this.p.translate((int)a.x + tileWidth, 750 - (int)a.y);
		g.fillPolygon(this.p);
		this.p.translate((int)-a.x - tileWidth, (int)a.y - 750);
		
	}
	
	/**Graphically prints un tile
	 * 
	 * @param g - Graphics object
	 * @param p - Point location of the tile
	 */
	public void printTile(Graphics g, Point p) {
		
		Point a = matrix.transMat(p);
		
		this.p.translate((int)a.x + tileWidth, 750 - (int)a.y);
		g.drawPolygon(this.p);
		this.p.translate((int)-a.x - tileWidth, (int)a.y - 750);
		
	}


	public Dimension getPreferredSize() {
		return new Dimension(810, 810); // appropriate constants
	}
}




