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
	public int energy;
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
		energy += 1; 
	}
	
	public boolean move(boolean dir){
		Hex n = null;
		if(dir) {
			n = this.l.neighbors[direction];
		} if(!dir){
			n = this.l.neighbors[(direction + 3) % 6];
		}
		energy -= 3 * size;
		if (n != null) {
			location.move((direction + (dir ? 0 : 3)) % 6);
			hexChange(n);
		}

		return (n != null);
	}
		
	public void turn(boolean dir){
		if(dir) {
			direction = (direction + 5) % 6;
		} else {
			direction = (direction + 1) % 6;
		}
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










