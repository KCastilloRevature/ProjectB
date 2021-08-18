package Game;
import Fixtures.Room;
import java.util.Scanner;

public class Main {
	private static boolean hasQuit = false;
	private static void printRoom(Player player) {
		System.out.println(player.currentRoom.getName() + "\n");
		System.out.println(player.currentRoom.get_lDesc() + "\n");
		
		System.out.println("Exits: \n");
		Room[] exits = player.currentRoom.getExits();
		
		//System.out.println("Room: " + exits[3].getName() + '\n');
		
		for (int i = 0; i <= 3; i++) {
			if (exits[i] != null) {
				switch(i) {
					case 0:
						System.out.println("north: " + 
								exits[i].get_sDesc());
						break;
					case 1:
						System.out.println("west: " + 
								exits[i].get_sDesc());
						break;
					case 2:
						System.out.println("east: " +
								exits[i].get_sDesc());
						break;
					case 3:
						System.out.println("south: " +
								exits[i].get_sDesc());
						break;
				};
			}
		}
		System.out.print('\n');
	}
	
	
	private static String[] collectInput() { 
		Scanner scan = new Scanner(System.in);
		return scan.nextLine().split(" ");
	}
	
	private static void parse(String[] command, Player player) {
		String instruction = command[0];
		String dirOrObj = command[1]; //this is Direction or Object
		
		switch(instruction.toLowerCase()) {
			case "go":
				travel(player, dirOrObj);
				break;
			case "check":
				break;
			case "open":
				break;
			case "pet":
				break;
			case "quit":
				System.out.println("Qutting house tour...."
						+ "Sorry to see you go so soon....");
			default:
				System.out.println("I'm sorry, I didn't catch that.");
				break;
		}
	}
	
	private static void travel(Player player, String direction) {
		switch (direction){
			case "north":
				player.setCurrentRoom(player.currentRoom.getExit(0));
				break;
			case "west":
				player.setCurrentRoom(player.currentRoom.getExit(1));
				break;
			case "east":
				player.setCurrentRoom(player.currentRoom.getExit(2));
				break;
			case "south":
				player.setCurrentRoom(player.currentRoom.getExit(3));
				break;
			default:
				System.out.println("Invalid direction.");
		}
	}
	
	private static void inputCheck(String[] command) {
		if (!(command.length == 1 || command.length == 2)) {
			System.out.println("Invalid input. Please try again.");
		}
		if (!(command[0] == "go" || command[0] == "check" || 
				command[0] == "open" || command[0] == "pet")) {
			System.out.println("Invalid input. Please try again.");
		}
	}
	
	
	public static void main(String[] args) {
		RoomManager roomManager = new RoomManager();
		roomManager.init();
		Player guide = new Player();
		guide.currentRoom = roomManager.startingRoom;
		while(!(guide.currentRoom.getName() == "Exit" || hasQuit)) {
			printRoom(guide);
			String[] input = collectInput();
			inputCheck(input);
			parse(input, guide);
		}
	}
}
