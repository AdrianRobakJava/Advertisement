

public class Car extends Advertisement{
	
	private String mark, model, fuel;
	private double mileage, engineCapacity;
	private int year, enginePower;
	
	public Car() {
		
	}
	
	public  Car(String type, String title, String place, double price, int phoneNumber, String mark, String model, String fuel, int year, int enginePower, double mileage, double engineCapacity) {
		setType(type);
		setTitle(title);
		setPlace(place);
		setPrice(price);
		setPhoneNumber(phoneNumber);
		this.mark = mark;
		this.model = model;
		this.fuel = fuel;
		setYear(year);
		setEnginePower(enginePower);
		setMileage(mileage);
		setEngineCapacity(engineCapacity);
	}
	
	@Override
	public String toString() {
			String firstPart = String.format("%s %s w miejscowości %s za %.2fzł. Mój numer to: %d.\n", getType(), getTitle(), getPlace(), getPrice(), getPhoneNumber(), getDescription());
			String secondPart = String.format("%s %s z %d roku, ma przejechane %.1fkm. %s ma silnik o pojemności %.1f %s, który generuje %d KM.\n%s\n", mark, model, year, mileage, getTitle(), engineCapacity, fuel, enginePower, getDescription() );
			return firstPart + secondPart;
	}
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public double getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(double engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getEnginePower() {
		return enginePower;
	}
	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}
	
	
}
