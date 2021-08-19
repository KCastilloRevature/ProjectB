package Game;
import Fixtures.Fridge;
import Fixtures.RegularItem;
import Fixtures.Room;
import Fixtures.Plushies;

public class RoomManager {
	public Room startingRoom;
	public Room[] rooms = new Room[11];
	
	/*
	 * So for this HouseTour...I decided to use my actual apartment.
	 * The apartment is a pretty simple two bedroom and bathroom 
	 * apartment, but I decided to add in a few other rooms such 
	 * as the closets.
	 */
	
	public void init() {
		//Rooms are initialized
		Room entrance = new Room("Entrance",  
				"entrance", 
				"A small hallway to a small two bedroom apartment."
				+ " A kitchen is open to the east, where a fridge can"
				+ "be seen. \nA living room can also be seen to the north,"
				+ "where a couple of tables can be seen. \nThe exit can "
				+ "be seen to the south. ");
		this.rooms[0] = entrance;
		this.startingRoom = entrance;
		
		Room kitchen = new Room("The Kitchen", 
				"kitchen",
				"A small kitchen. A fridge and sink can be seen at the end "
				+ "of the room.");
		this.rooms[1] = kitchen;
			
		Room livingRoom = new Room("The Living Room",
				"living room",
				"A small, but open living room. A dining table and a work \ntable "
				+ "can be seen in this room. A hallway can be seen to the north.");
		this.rooms[2] = livingRoom;
		
		Room hallway = new Room("A Hallway", 
				"hallway",
				"A small hallway. A bathroom can be seen on the west, "
				+ "and two bedrooms can be seen \non the north and east.");
		this.rooms[3] = hallway;
			
		Room bathroom1 = new Room("My Roommate's Bathroom",
				"west bathroom",
				"A small bathroom that belongs to a roommate that's living "
				+ "with me.");
		this.rooms[4] = bathroom1;
			
		Room bedroom1 = new Room("My Roommate's Bedroom",
				"east bedroom",
				"A small bedroom that belongs to a roommate that's living "
				+ "with me. A closet can be seen to the west.");
		this.rooms[5] = bedroom1;
		
		Room closet1 = new Room("My Roommate's Closet",
				"west closet",
				"A small closet that belongs to my roommate. I don't know "
				+ "what's in the closet \nbut I can assume there are clothes "
				+ "there.");
		this.rooms[6] = closet1;
		
		Room bedroom2 = new Room("My Mom's Bedroom",
				"north bedroom",
				"A small bedroom where my mom sleeps. There is a regular bed"
				+ " in the room. There is a closet to the \nwest where an "
				+ "inflatable bed can be seen laying on its side and a bathroom "
				+ "to the north.");
		this.rooms[7] = bedroom2;
		
		Room closet2 = new Room("My Mom's and Mine's Closet",
				"other west closet",
				"A closet where my mom and I keep out clothes. There "
				+ "is an inflatable bed laying on its side.");
		this.rooms[8] = closet2;
		
		Room bathroom2 = new Room("My Mom's and Mine's Bathroom",
				"north bathroom",
				"A bathroom where my mom and I do our business.....when "
				+ "the other is not inside of course.");
		this.rooms[9] = bathroom2;
		
		Room exit = new Room("Exit",
				"exit",
				"Thank you for joining me on this house tour!");
		this.rooms[10] = exit;
		
		//exits, or "room links" are initialized
		entrance.setExits(livingRoom, null, kitchen, exit);
		kitchen.setExits(null, null, null, entrance);
		livingRoom.setExits(hallway, null, null, entrance);
		hallway.setExits(bedroom2, bathroom1, bedroom1, livingRoom);
		bathroom1.setExits(null, null, null, hallway);
		bedroom1.setExits(null, closet1, null, hallway);
		closet1.setExits(null, null, null, bedroom1);
		bedroom2.setExits(bathroom2, closet2, null, hallway);
		closet2.setExits(null, null, null, bedroom2);
		bathroom2.setExits(null, null, null, bedroom2);
		
		//Items are initialized
		Fridge fr = new Fridge("fridge", "A average white fridge. There's "
				+ "a freezer at the \ntop of the fridge, but let's not worry"
				+ "about that right now.\n");
		
		RegularItem sink = new RegularItem("sink", "A regular clean sink. "
				+ "The sink is empty right now \nbecause there are no "
				+ "dishes to wash.\n");
		kitchen.setFridge(fr);
		kitchen.setrItems(sink);
		
		RegularItem diningTable = new RegularItem("diningtable", "A "
				+ "regular dining table. The table is \nempty because"
				+ "it is not time for lunch nor dinner yet.\n");
		
		RegularItem workTable = new RegularItem("worktable", "The table "
				+ "where I do most of my coding \nand where this "
				+ "script is being written right now. There are \n"
				+ "plushies of the Pokemon Alolan-Vulpix, Litwick, "
				+ "and Mew \non the table.\n");
		
		Plushies aVulpix = new Plushies("alolan-vulpix", "#037 Vulpix (Alola) -"
				+ "The Fox Pokemon \n\n"
				+ "It exhales air colder than -58 degrees Fahrenheit. Elderly people in \n"
				+ "Alola call this Pokémon by an older name—Keokeo.\n", 
				"Although your hand isn't experiencing intense frostbite, you feel \nthe "
				+ "soft touch of the Alolan-Vulpix plushie.\n");
		
		Plushies litwick = new Plushies("litwick", "#607 Litwick - "
				+ "The Candle Pokemon \n\n"
				+ "Litwick shines a light that absorbs the life energy of people and Pokémon, which \n"
				+ "becomes the fuel that it burns.\n", 
				"Although your hand isn't experiencing 2nd-degree burns, you feel \n"
				+ "the soft touch of the Litwick plushie.\n");
		
		Plushies mew = new Plushies("mew", "#151 Mew - "
				+ "The New Species Pokemon \n\n"
				+ "Its DNA is said to contain the genetic codes of all Pokémon, so it can use \n"
				+ "all kinds of techniques.\n", 
				"The power...of the progenitor of creation...is in your hands...\n"
				+ "Nah just kidding! You're only petting a Mew plushie.\n");
		
		livingRoom.setrItems(diningTable, workTable);
		livingRoom.setPlushies(aVulpix, litwick, mew);
		
		RegularItem bed = new RegularItem("bed", "A bed where only my "
				+ "mom sleeps.\n");
		
		bedroom2.setrItems(bed, null);
		
		RegularItem inflateBed = new RegularItem("inflatablebed", "An inflatable bed"
				+ "where I sleep in. When it's time \nfor me to turn in for the day,"
				+ "I inflate this bed, and\ndrag it to the living room.\n");
		
		closet2.setrItems(inflateBed, null);
				
	}
}
