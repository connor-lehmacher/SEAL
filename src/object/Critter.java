package object;




import java.util.ArrayList;
import environment.*;
import math.*;
import object.Critter;
import object.Food;
import object.Object;




public class Critter extends Object {
	public ArrayList<Critter> critters = new ArrayList<Critter>();
	
	//Virtual Memory
	public final int memory; //mem[0]
	public final int defence;//mem[1]
	public final int offense;//mem[2]
	public int size; //mem[3]
	public int energy; //mem[4]
	public int passNumber;//mem[5]
	public int tag;//mem[6]
	public int posture;//mem[7]
	public int[] generalPurposeMemory; //mem[>=8]
	
	//Formal Memory
	public Point location;
	public int direction; 


	public Critter(int energy, int direction, Hex location, int defence, int offense, int[] extraInfo){
		super(location);
		this.energy = energy;
		this.direction = direction;
		this.location = new Point(location.location.x, location.location.y);
		size = 1;
		tag = 0;
		posture = 0;
		memory = 8 + extraInfo.length;
		this.defence = defence;
		this.offense = offense;
		generalPurposeMemory = extraInfo ;
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
		if (n == null) {
			System.out.println("Hello");
			return false;
		}




		location.move((direction + (dir ? 0 : 3)) % 6);
		hexChange(n);
		
		return true;
	}
		
	public void turn(boolean dir){
		if(dir) {
			direction = (direction + 5) % 6;
		} else {
			direction = (direction + 1) % 6;
		}
	}
	
	public void eat() {
		int dE = 1 - sense(direction, 1);
		
		if (dE <= 0) {
			return;
		}
		
		energy += dE;
		
		if (energy > 500 * size) {
			Food f = (Food) l.neighbors[direction].getFillVal();
			f.nutrition = energy - 500 * size;
		} else {
			l.neighbors[direction].fill(null);
		}
		
	}
	
	public boolean serve(int en) {
		if (en > size * 500 - 1) {
			return false;
		}
		
		if (sense(direction, 1) == 0) {
			return false;
		}
		
		Food f = new Food(l.neighbors[direction], en);
		l.neighbors[direction].fill(f);


		
		return true;
	}
	
	public boolean tag(int t) {
		if (sense(direction, 0) <= 0) {
			return false;
		}
		
		((Critter)(l.neighbors[direction].getFillVal())).tag = t;
		
		return true;
	}
	
	public boolean grow() {
		if (energy <= size) { //If energy if not sufficient to grow, return false
			return false;
		}
		
		size++;
		
		return true;
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
























