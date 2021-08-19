package Fixtures;

public class Room extends Fixture {
	public Room[] exits;
	
	//all of the checkable and interactable items
	public Fridge fridge; //item that can be checked and opened/closed
	public RegularItem[] rItems; //item that can only be checked
	public Plushies[] plushies; //item that can be checked or petted

	public Room(String name, String sDesc, String lDesc) {
		super(name, sDesc, lDesc);
		this.exits = new Room[4]; //array of 4, 4 directions: north, west, east, south in that order
		this.fridge = new Fridge(name, lDesc); //only one fridge in the kitchen
		this.rItems = new RegularItem[2]; //there were a maximum of 2 checkable items 
		this.plushies = new Plushies[3]; //there are only 3 plushies in the living room
	}
	
	//getters and setters
	public Fridge getFridge() {
		return fridge;
	}

	public void setFridge(Fridge fridge) {
		this.fridge = fridge;
	}

	public RegularItem[] getrItems() {
		return rItems;
	}

	public void setrItems(RegularItem... rItems) {
		this.rItems = rItems;
	}

	public Plushies[] getPlushies() {
		return plushies;
	}

	public void setPlushies(Plushies... plushies) {
		this.plushies = plushies;
	}

	/*
	 * This is my main "room linker" method, instead of writing a bunch of 
	 * clunky assignments in the RoomManager class, I decided to create 
	 * a setter method that just assigns that for me. The reason why this
	 * is public is just because RoomManager is in another package, and
	 * RoomManager is the only class that does this anyway.
	 */
	public void setExits(Room... exit) {
		this.exits = exit;
	}

	public Room[] getExits() {
		return exits;
	}
		
	public Room getExit(int direction) {
		return exits[direction];
	}
	

}
