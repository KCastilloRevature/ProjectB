package Game;
import Fixtures.Room;

public class RoomManager {
	public Room startingRoom;
	public Room[] rooms = new Room[11];
	
	
	public void init() {
		Room entrance = new Room("Entrance",  
				"entrance", 
				"A small hallway to a small two bedroom apartment."
				+ " A kitchen is open to the east, where a fridge can"
				+ "be seen. A living room can also be seen to the north,"
				+ "where a couple of tables can be seen. The exit can "
				+ "be seen to the south. ");
		this.rooms[0] = entrance;
		this.startingRoom = entrance;
		
		Room kitchen = new Room("The Kitchen", 
				"kitchen",
				"A small kitchen. Drawers lined up the walls of the room, "
				+ "and a fridge and sink can be seen at the end of the room.");
		this.rooms[1] = kitchen;
			
		Room livingRoom = new Room("The Living Room",
				"living room",
				"A small living room. An open room that with a couple couches"
				+ "lined against the walls. A dining table and a work table"
				+ "can be seen in this room. A hallway can be seen to the north.");
		this.rooms[2] = livingRoom;
		
		Room hallway = new Room("A Hallway", 
				"hallway",
				"A small hallway. A bathroom can be seen on the west, "
				+ "and two bedrooms can be seen on the north and east.");
		this.rooms[3] = hallway;
			
		Room bathroom1 = new Room("My Roommate's Bathroom",
				"west bathroom",
				"A small bathroom that belongs to a roommate that's living "
				+ "with me. There is a sink in here.");
		this.rooms[4] = bathroom1;
			
		Room bedroom1 = new Room("My Roommate's Bedroom",
				"east bedroom",
				"A small bedroom that belongs to a roommate that's living "
				+ "with me. A closet can be seen to the west.");
		this.rooms[5] = bedroom1;
		
		Room closet1 = new Room("My Roommate's Closet",
				"west closet",
				"A small closet that belongs to my roommate. I don't know "
				+ "what's in the closet but I can assume there are clothes "
				+ "there.");
		this.rooms[6] = closet1;
		
		Room bedroom2 = new Room("My Mom's Bedroom",
				"north bedroom",
				"A small bedroom where my mom sleeps. There is a regular bed"
				+ " in the room. There is a closet to the west where an"
				+ "inflatable bed can be seen laying on its side and a bathroom"
				+ "to the north.");
		this.rooms[7] = bedroom2;
		
		Room closet2 = new Room("My Mom's and Mine's Closet",
				"other west closet",
				"A closet where my mom and I keep out clothes. There "
				+ "is an inflatable bed laying on its side.");
		this.rooms[8] = closet2;
		
		Room bathroom2 = new Room("My Mom's and Mine's Bathroom",
				"north bathroom",
				"A bathroom where my mom and I do our business.....when"
				+ "the other is not inside of course. There is a sink in "
				+ "here.");
		this.rooms[9] = bathroom2;
		
		Room exit = new Room("Exit",
				"exit",
				"Thank you for joining me on this house tour!");
		this.rooms[10] = exit;
		
		entrance.setExits(livingRoom, null, kitchen, exit);
		kitchen.setExits(null, null, null, entrance);
		livingRoom.setExits(hallway, null, null, entrance);
		hallway.setExits(bedroom2, bedroom1, bathroom1, livingRoom);
		bathroom1.setExits(null, null, null, hallway);
		bedroom1.setExits(null, null, closet1, hallway);
		closet1.setExits(null, null, null, bedroom1);
		bedroom2.setExits(bathroom2, null, closet2, hallway);
		closet2.setExits(null, null, null, bedroom2);
		bathroom2.setExits(null, null, null, bedroom2);
	}
}
