package Fixtures;

public class RegularItem extends Item{
	
	/*
	 * This Item class is for items that can only be checked, since
	 * I decided to implement Item as a abstract class, I had to make 
	 * a seperate class that only has this simple functionality
	 */

	public RegularItem(String name, String lDesc) {
		super(name, lDesc);
	}

	public void check() {
		System.out.println(this.get_lDesc());
	}
}
