package Fixtures;

public class Room extends Fixture {
	public Room[] exits;

	public Room(String name, String sDesc, String lDesc) {
		super(name, sDesc, lDesc);
		this.exits = new Room[4]; 
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
