package pl.alx.kpij.Ogloszenia;

public class House extends Advertisement{
	
	private int numberOfRooms;
	private double houseArea, landArea;
	
	public House() {
		
	}
	
	public House(String type, String title, String place, double price, int phoneNumber, int numberOfRooms, double houseArea) {
		setType(type);
		setTitle(title);
		setPlace(place);
		setPrice(price);
		setPhoneNumber(phoneNumber);
		setNumberOfRooms(numberOfRooms);
		setHouseArea(houseArea);
		
	}
	public House(String type, String title, String place, double price, int phoneNumber, int numberOfRooms, double houseArea, double landArea) {
		setType(type);
		setTitle(title);
		setPlace(place);
		setPrice(price);
		setPhoneNumber(phoneNumber);
		setNumberOfRooms(numberOfRooms);
		setHouseArea(houseArea);
		setLandArea(landArea);
	}
	
	@Override
	public String toString() {
		if (landArea == 0.0) {
			String firstPart = String.format("%s %s w miejscowości %s za %.2fzł. Mój numer to: %d.\n", getType(), getTitle(), getPlace(), getPrice(), getPhoneNumber());
			String secondPart = String.format("%s ma %d pokoje i powierzchnię %.2f m^2\n%s\n", getTitle(), numberOfRooms, houseArea, getDescription());
			return firstPart + secondPart;
		} else {
			String firstPart = String.format("%s %s w miejscowości %s za %.2fzł. Mój numer to: %d.\n", getType(), getTitle(), getPlace(), getPrice(), getPhoneNumber());
			String secondPart = String.format("%s ma %d pokoji i powierzchnię %.2f m^2, oraz działkę o powierzchni %.2f ara.\n%s\n", getTitle(),numberOfRooms, houseArea, landArea, getDescription());
			return firstPart + secondPart;
		}
		
	}
	
	
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public double getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(double houseArea) {
		this.houseArea = houseArea;
	}
	public double getLandArea() {
		return landArea;
	}
	public void setLandArea(double landArea) {
		this.landArea = landArea;
	}
	
	

}
