package Game;

import Fixtures.Room;

public class Player {
	/*
	 * So instead of setting currentRoom as a String, like what the 
	 * template instructed, I decided to make currentRoom as a Room
	 * object, because it is easier for me to determine where the player
	 * can go and more importantly, set the player's location within 
	 * the Game.
	 */
	Room currentRoom;
	
	//getters and setters
	public Room getcurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room cRoom) {
		this.currentRoom = cRoom;
	}
}
