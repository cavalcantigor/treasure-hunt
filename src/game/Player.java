package game;


public class Player {
	private int age;
	private String name;
	private String surname;
	private int piratePoints;
	private int digPoints;
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setSurname(String name) {
		this.surname = name;
	}

	public int getDigPoints() {
		return digPoints;
	}

	public void setDigPoints(int digPoints) {
		this.digPoints = digPoints;
	}

	public int getPiratePoints() {
		return piratePoints;
	}

	public void setPiratePoints(int piratePoints) {
		this.piratePoints = piratePoints;
	}
}
