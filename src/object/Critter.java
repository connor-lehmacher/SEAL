package object;


import java.util.ArrayList;
import environment.*;
import math.*;
import object.Critter;
import object.Food;
import object.Object;


public class Critter extends Object {
	public ArrayList<Critter> critters = new ArrayList<Critter>();
	
	//To be stored in critter's Memory
	public double energy;
	public int direction;
	public int size;
	
	public Point location;
	
	public Critter(int energy, int direction, Hex location){
		super(location);
		this.energy = energy;
		this.direction = direction;
		this.location = new Point(location.location.x, location.location.y);
		size = 1;
	}
	
	public void charge(){
	energy += super.l.light;
	}
	
	public boolean moveForward(){
		Hex n = this.l.neighbors[direction];
		
		if (n == null) {
			return false;
		}
		
		location.move(direction);
		hexChange(n);
		
		energy -= 3 * size;
		return true;
	}
		
	public boolean moveBackward(){
		Hex n = this.l.neighbors[(direction + 3) % 6];
		
		if (n == null) {
			return false;
		}
		
		location.move((direction + 3) % 6);
		hexChange(n);
		
		energy -= 3 * size;
		return true;
	}
		
	public void turnLeft(){
		direction = (direction + 5) % 6;
	}
		
	public void turnRight(){
		direction = (direction + 1) % 6;
	}
	
	public int sense(int dire, int dist) {
		
		Hex check = this.l;
		
		int i = 0;
		while (i < dist) {
			check = check.neighbors[dire];
			i++;
		}
		
		Object fv = check.getFillVal();
		if (fv == null) {
			return 0;
		}
		if (check.rockHex) {
			return -1;
		}
		if (fv instanceof Critter) {
			return ((Critter) fv).size;
		}
		if (fv instanceof Food) {
			return -1 - ((Food) fv).nutrition;
		}
		
		return 0;
	}
}










