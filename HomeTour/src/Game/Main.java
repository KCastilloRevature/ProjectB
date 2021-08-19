package Game;
import Fixtures.Fridge;
import Fixtures.RegularItem;
import Fixtures.Plushies;
import Fixtures.Room;
import java.util.Scanner;

public class Main {
	//This bool is meant to serve as a flag to indicate the Player 
	//has quit the game.
	private static boolean hasQuit = false; 
	
	private static void printRoom(Player player) {
		System.out.println(player.currentRoom.getName() + "\n");
		System.out.println(player.currentRoom.get_lDesc() + "\n");
		
		System.out.println("Exits: \n");
		Room[] exits = player.currentRoom.getExits();
		
		/*
		 * This switch statement prints out the available exits, if there
		 * no Room (null), then it doesn't print.
		 */
		for (int i = 0; i <= 3; i++) {
			if (exits[i] != null) {
				switch(i) {
					case 0:
						System.out.println("North: " + 
								exits[i].get_sDesc());
						break;
					case 1:
						System.out.println("West: " + 
								exits[i].get_sDesc());
						break;
					case 2:
						System.out.println("East: " +
								exits[i].get_sDesc());
						break;
					case 3:
						System.out.println("South: " +
								exits[i].get_sDesc());
						break;
				};
			}
		}
		System.out.print('\n');
	}
	
	//the exit meg is printed once the player enters the exit in the
	//Game
	private static void printExit(Player player) {
		System.out.println(player.currentRoom.getName());
		System.out.println(player.currentRoom.get_lDesc());
	}
	
	//input collector
	private static String[] collectInput() { 
		Scanner scan = new Scanner(System.in);
		return scan.nextLine().split(" ");
	}
	
	private static void parse(String[] command, Player player) {
		String instruction = command[0].toLowerCase();
		String dirOrObj = null; //this is Direction or Object
		
		/*
		 * This switch statement handles commands based on the input, 
		 * initially, I was planning to initialize the "dirOrObj"
		 * String before the switch statement, but then I spent about
		 * 30 minutes handling potential ArrayOutOfBounds exceptions when
		 * trying to include the "quit" command, before I ultimately decided
		 * to take a rather inelegant solution and just initialize
		 * dirOrObj in every case except quit and default.
		 */
		switch(instruction) {
			case "go":
				dirOrObj = command[1].toLowerCase();
				travel(player, dirOrObj);
				break;
			case "check":
				dirOrObj = command[1].toLowerCase();
				checkItem(player, dirOrObj);
				break;
			case "open":
				dirOrObj = command[1].toLowerCase();
				openFridge(player, dirOrObj);
				break;
			case "close":
				dirOrObj = command[1].toLowerCase();
				closeFridge(player, dirOrObj);
				break;
			case "pet":
				dirOrObj = command[1].toLowerCase();
				petPlushie(player, dirOrObj);
				break;
			case "quit":
				hasQuit = true;
				System.out.println("Qutting house tour...."
						+ "Sorry to see you go so soon....");
				break;
			default:
				System.out.println("I'm sorry, I didn't catch that.");
				break;
		}
	}
	
	//takes the direction input and travels
	private static void travel(Player player, String direction) {
		switch (direction){
			case "north":
				travelCheck(player, 0);
				break;
			case "west":
				travelCheck(player, 1);
				break;
			case "east":
				travelCheck(player, 2);
				break;
			case "south":
				travelCheck(player, 3);
				break;
			default:
				System.out.println("Invalid direction.");
		}
	}
	
	/*
	 * This method is meant to check if the user has made an invalid
	 * directional input, in which case, I tell the user that you
	 * can't go there. I also put in case to where if the user
	 * left the fridge open in the kitchen, I will restrict the
	 * player in the kitchen until the fridge is closed.
	 */
	private static void travelCheck(Player player, int direction) {
		boolean openFridge = false;
		if (player.currentRoom.getName().equals("The Kitchen")) {
			openFridge = Fridge.getisOpen();
		}
		
		if (player.currentRoom.getExit(direction) == null) {
			System.out.println("I'm sorry, you can't through wall.");
		}
		
		else if (openFridge) {
			System.out.println("Hey stupid, close the fridge!");
		}
		
		else {
			player.setCurrentRoom(player.currentRoom.getExit(direction));
		}
	}
	
	/*
	 * The checkItem method, first I check if the Item the player is checking is a
	 * Plushie object, then a RegularItem object, then I invoke a method that just
	 * prints the Item's description, and print a "error" message if the player made
	 * an invalid input.
	 */
	private static void checkItem(Player player, String item) {
		RegularItem[] rItems = player.currentRoom.getrItems();
		if (player.currentRoom.getName().equals("The Kitchen")) {
			Fridge fridge = player.currentRoom.getFridge();
			if (fridge.getName().equals(item)) {
				fridge.check();
			}
			if (item.equals("sink")) {
				regularItemCheck(rItems, item);
			}
		}
		
		else if (player.currentRoom.getName().equals("The Living Room")) {
			Plushies[] plushies = player.currentRoom.getPlushies();
			for (int i = 0; i < plushies.length; i++) {
				if (plushies[i].getName().equals(item)) {
					plushies[i].check();
				}
			}
			
			regularItemCheck(rItems, item);
		}
		else {
			regularItemCheck(rItems, item);
		}
	}
	
	/*
	 * This regularItemCheck method is just here because I had to 
	 * call this functionality twice in my initial checkItem method
	 */
	
	private static void regularItemCheck(RegularItem[] rItems, String item) {
		if (rItems[0].getName().equals(item)) {
			rItems[0].check();
		}
	
		else if (rItems[1] != null || rItems[1].getName().equals(item)) {
			rItems[1].check();
		}
		
		else {
			System.out.println("I'm sorry, what did you want to check?");
		}
	}
	
	/*
	 * the openFridge method, first I check if the user inputted the right Item, and
	 * then invokes open(), printing the string, and setting the isOpen variable to
	 * true
	 */
	private static void openFridge(Player player, String fridge) {
		if (!(fridge.equals("fridge"))) {
			System.out.println("I'm sorry, what did you want to open?");
		}
		
		else {
			player.currentRoom.fridge.open();
		}
	}
	
	//the closeFridge method, same deal except it sets isOpen to false
	private static void closeFridge(Player player, String fridge) {
		if (!(fridge.equals("fridge"))) {
			System.out.println("I'm sorry, what did you want to close?");
		}
		
		else {
			player.currentRoom.fridge.close();
		}
	}
	
	/*
	 * The petPlushie method, pretty simple, checks if the user inputted plushie is
	 * correct, then invoke print
	 * 
	 * Similar to checkItem, very inelegant solution, tried to do this via a for
	 * loop, but for some reason, only the 2nd Plushie in the array is being called
	 */
	private static void petPlushie(Player player, String plushie) {
		if (player.currentRoom.getName().equals("The Living Room")) {
			Plushies[] plushies = player.currentRoom.getPlushies();
			for (int i = 0; i < plushies.length; i++) {
			if (plushies[i].getName().equals(plushie)) {
				plushies[i].pet();
			}
		}
//			if (plushies[0].getName().equals(plushie)) {
//				plushies[0].pet();
//			}
//			
//			else if (plushies[1].getName().equals(plushie)) {
//				plushies[1].pet();
//			}
//			
//			else if (plushies[2].getName().equals(plushie)) {
//				plushies[2].pet();
//			}
		}
		
		else {
			System.out.println("I'm sorry, what did you want to pet?");
		}
	}
	
	/*
	 * I decided to restrict the user to input 2 strings, just because it'd be
	 * easier for me to handle 2 input strings. For any Items in the game that were
	 * 2 words, such as "inflatable bed", I just restricted it to a single word,
	 * "inflatablebed"
	 */
	private static void inputCheck(String[] command) {
		if ((command.length > 2)) {
			System.out.println("Too many inputs. Please try again.");
		}
		
	}
	
	/*
	 * Main method - creates rooms, creates and sets the player, 
	 * and runs the game until Exit is reached or "quit" is inputted
	 */
	public static void main(String[] args) {
		RoomManager roomManager = new RoomManager();
		roomManager.init();
		Player guide = new Player();
		guide.currentRoom = roomManager.startingRoom;
		while(!(guide.currentRoom.getName().equals("Exit") || hasQuit)) {
			printRoom(guide);
			String[] input = collectInput();
			inputCheck(input);
			parse(input, guide);
		}
		
		if (guide.currentRoom.getName().equals("Exit")) {
			printExit(guide);
		}
	}
}
