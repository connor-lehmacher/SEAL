package object;

import java.util.ArrayList;

import environment.Hex;

public class Critter extends Object {
	public ArrayList<Critter> critters = new ArrayList<Critter>();
	
	public int energy;
	public double direction;
	
	public Critter(int energy, int direction, Hex location){
		super(location);
		this.energy = energy;
		this.direction = direction;
	}
	
	public void charge(){
		energy += super.l.light;
	}
	
	public void moveForward(){
		//Find Hex From ArrayList
	}
		
	public void moveBackward(){
		
	}
		
		
	public void turnLeft(){
		
	}
		
	public void turnRight(){
		
	}
}
