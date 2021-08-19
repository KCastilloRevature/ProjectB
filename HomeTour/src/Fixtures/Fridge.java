package Fixtures;

public class Fridge extends Item implements OpenAndCloseable {
	/*
	 * This Fridge class is an Item that can not only be checked, but
	 * can also be opened and closed, and if the Player tries to leave
	 * the Kitchen, they will be restricted in the kitchen until the
	 * fridge is closed. This is done with a boolean flag in the class
	 * called isOpen
	 */
	private static boolean isOpen = false; 

	public Fridge(String name, String lDesc) {
		super(name, lDesc);
	} 

	//getters and setters
	public void check() {
		System.out.println(this.get_lDesc());
	}
	
	public void open() {
		System.out.println("You opened the fridge. There is an \n"
				+ "assortment of meats and vegatables laid down. \n"
				+ "There is nothing else of note here.");
		isOpen = true;
	}
	
	public void close() {
		System.out.println("You closed the fridge. The food is still "
				+ "preserved.");
		isOpen = false;
	}
	
	public static boolean getisOpen() {
		return isOpen;
	}
}
