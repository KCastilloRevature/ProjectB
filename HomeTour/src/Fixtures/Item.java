package Fixtures;

/*
 * I decided to store my checkable/interactable items into
 * an abstract class since these Item objects have a common
 * functionality that they all can be checked. I also overloaded
 * the Fixture class to have a name and large description parameter
 * only since these items only need a name and description.
 */

public abstract class Item extends Fixture{
	public Item(String name, String lDesc) {
		super(name, lDesc);
	}
	
	public abstract void check();
}
