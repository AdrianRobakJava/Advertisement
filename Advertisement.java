

public class Advertisement {
	
	private String type, title, place, description;
	private int phoneNumber;
	private double price;
	
	public Advertisement() {
		
	}
	
	public Advertisement(String type, String title, String place, double price, int phoneNumber) {
		this.title = title;
		this.place = place;
		setPrice(price);
		setPhoneNumber(phoneNumber);
	}
	
	@Override
	public String toString() {
		return String.format("%s %s w miejscowości %s za %.2fzł. Mój numer to: %d.\n%s", type, title, place, price, phoneNumber, description);
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
