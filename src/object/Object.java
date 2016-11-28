package object;


import environment.*;


public class Object {
	public Hex l;
	public Object(Hex h) {
		l = h;
	}
	
	/**Changes an Object's Hex location
	 * 
	 * @param l - the Object's new Hex Location
	 */
	public void hexChange(Hex l) {
		this.l = l;
	}
}