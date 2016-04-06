
public class Tours {
	private int id;
	private double duration;
	private int type;
	private int difficulty;
	private int area;
	private int price;
	private int seatsTotal;
	private int seatsBooked;
	private int language;
	private boolean pickup;
	private boolean handicap;
	private int date;
	
	public int getPrice() {
		return price;
	}
	
	public int getType() {
		return type;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public int getArea() {
		return area;
	}
	
	public boolean getPickup() {
		return pickup;
	}
	
	public boolean getHandicap() {
		return handicap;
	}
	
	public int getLanguage() {
		return language;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public int getId() {
		return id;
	}
	
	public int getSeatsT() {
		return seatsTotal;
	}
	
	public int getSeatsB() {
		return seatsBooked;
	}
	
	public void setPrice(int n) {
		price = n;
	}
	
	public void setType(int n) {
		type = n;
	}
	
	public void setDuration(int n) {
		duration = n;
	}
	
	public void setArea(int n) {
		area = n;
	}
	
	public void setPickup(boolean isPickup) {
		pickup = isPickup;
	}
	
	public void setHandicap(boolean isHandy) {
		handicap = isHandy;
	}
	
	public void setLanguage(int lang) {
		language = lang;
	}
	
	public void setDifficulty(int diff) {
		difficulty = diff;
	}
	
	public void setId(int n) {
		id = n;
	}
	
	public void setSeatsB(int n) {
		seatsBooked = n;
	}
	
	public void setSeatsT(int n) {
		seatsTotal = n;
	}
}
