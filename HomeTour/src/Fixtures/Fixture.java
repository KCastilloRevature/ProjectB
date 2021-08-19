package Fixtures;

public abstract class Fixture {
	private String name;
	private String sDesc;
	private String lDesc;
	
	public Fixture(String name, String sDesc, String lDesc) {
		this.name = name;
		this.sDesc = sDesc;
		this.lDesc = lDesc;
	}
	
	//overloading this Fixture class to create items
	public Fixture(String name, String lDesc) {
		this(name, "There is no short description", lDesc);
	}
	
	public String getName() {
		return name;
	}
	
	public String get_sDesc() {
		return sDesc;
	}
	
	public String get_lDesc() {
		return lDesc;
	}
}
