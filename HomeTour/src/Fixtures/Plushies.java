package Fixtures;

public class Plushies extends Item implements Pettable {
	private String petDescription;
	
	/*
	 * This Plushies class is an Item class where you can check the 
	 * description of the class like other items, but can also be
	 * invoked with the method pet() to give a seperate description.
	 */
	
	/*
	 * So I had the idea of restricting the player's access to the
	 * plushies until the player has checked the work table
	 * Item, but I ran into the issue where certain Plushie objects
	 * didn't have their boolean field false, so I decided to 
	 * scrap that idea altogether for the sake of finishing this
	 * project.
	 */
	//private static boolean checkedWorkTable = false;

	public Plushies(String name, String lDesc, String petDescription) {
		super(name, lDesc);
		this.petDescription = petDescription;
	}
	
	public void check() {
		System.out.println(this.get_lDesc());
	}
	
	public void pet() {
		System.out.println(petDescription);
	}
	
//	public static boolean isCheckedWorkTable() {
//		return checkedWorkTable;
//	}
//
//	public static void setCheckedWorkTable(boolean checkedWorkTable) {
//		Plushies.checkedWorkTable = checkedWorkTable;
//	}
	
}
