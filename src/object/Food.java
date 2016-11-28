package object;


import environment.Hex;


public class Food extends Object {
	
	public int nutrition;
	
	public Food(Hex h, int n) {
		super(h);
		nutrition = n;
	}


}


