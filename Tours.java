
public class Tours {
	private int id;
	private double duration;
	private String type;
	private String difficulty;
	private String area;
	private int price;
	private int seatsTotal;
	private int seatsAvailable;
	private String language;
	private boolean pickup;
	private boolean handicap;
	private String date; // form of date = DD.MM.YYYY
	
	public int getPrice() {
		return price;
	}
	
	public String getType() {
		return type;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public String getArea() {
		return area;
	}
	
	public boolean getPickup() {
		return pickup;
	}
	
	public boolean getHandicap() {
		return handicap;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public int getId() {
		return id;
	}
	
	public int getSeatsTotal() {
		return seatsTotal;
	}
	
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
        public String getDate() {
            return date;
        }
	
	public void setPrice(int n) {
		price = n;
	}
	
	public void setType(String n) {
		type = n;
	}
	
	public void setDuration(double n) {
		duration = n;
	}
	
	public void setArea(String n) {
		area = n;
	}
	
	public void setPickup(boolean isPickup) {
		pickup = isPickup;
	}
	
	public void setHandicap(boolean isHandy) {
		handicap = isHandy;
	}
	
	public void setLanguage(String lang) {
		language = lang;
	}
	
	public void setDifficulty(String diff) {
		difficulty = diff;
	}
	
	public void setId(int n) {
		id = n;
	}
	
	public void setSeatsAvailable(int n) {
		seatsAvailable = n;
	}
	
	public void setSeatsTotal(int n) {
		seatsTotal = n;
	}
        public void setDate(String n) {
            date = n;
        }
}
