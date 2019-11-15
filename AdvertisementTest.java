/*
*Program łaczy zadania 7.1, 7.2 i 7.3.
*/

package pl.alx.kpij.Ogloszenia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AdvertisementTest {

	private static ArrayList<Advertisement> advertisementList = new ArrayList<>();

	public static void main(String[] args) {

		addAdvertisement();
		saveAll();

		/*
		 * //Aby przetestować program z wczytywania plików, należy po pierwszym
		 * uruchomieniu programu zakomentować dwie powyższe linijki, aby nie dublować
		 * ogłoszeń i odkomentować metodę loadAll.
		 */

		 //loadAll();
		 //Wypisuje wsystkie ogłoszenia
		for (Advertisement adw : advertisementList) {
			System.out.println(adw);
		}
		//Metoda pozwalająca wybrać rzecz do kupienia z podanego zakresu cenowego
		priceRange("Auto", 10000, 30000);
		//Metoda wyszukująca auta, motory lub domy, mieszkania do określonej kwoty, a powyżej odpowieniej pojemności lub powierzchni
		maxPriceMinCapacityOrArea("Motocykl", 50000, 0.5);

	}

	public static void addAdvertisement() {

		Advertisement ad1 = new House("Sprzedam", "Mieszkanie", "Kraków", 350000.0, 123123123, 3, 55.5);
		ad1.setDescription("Ładne zadbane mieszkanie z balkonem i widokiem na park.");
		advertisementList.add(ad1);

		Advertisement ad2 = new House("Sprzedam", "Dom", "Wieliczka", 550000.0, 223223223, 5, 130.0, 14.5);
		ad2.setDescription("Duży dom z garażem i podjazdem. Dwie łazienki oraz altana na ogrodzie.");
		advertisementList.add(ad2);

		Advertisement ad3 = new Car("Sprzedam", "Auto", "Tarnów", 17000, 113113113, "Opel", "Astra", "Benzyna", 2011,
				130, 202000.0, 1.9);
		ad3.setDescription("Pierwszy właściciel Niemiec płakał jak sprzedawał.");
		advertisementList.add(ad3);

		Advertisement ad4 = new Car("Sprzedam", "Auto", "Warszawa", 88000, 221221221, "Mazda", "6", "Dizel", 2017, 190,
				32000.0, 2.3);
		ad4.setDescription("Jeszcze ma folie na siedzeniach :).");
		advertisementList.add(ad4);

		Advertisement ad5 = new Motorcycle("Sprzedam", "Motocykl", "Gdańsk", 32000, 554554554, "Suzuki", "GSX-R750",
				"Benzyna", 2015, 150, 5500.0, 0.750);
		ad5.setDescription("Bez obcierek stan idealny.");
		advertisementList.add(ad5);

		Advertisement ad6 = new Motorcycle("Sprzedam", "Motocykl", "Wrocław", 55000, 443443443, "Kawasaki",
				"Ninja ZX-10RR", "Benzyna", 2019, 204, 22000.0, 1.0);
		ad6.setDescription("Włąściciel jeszcze żyje :).");
		advertisementList.add(ad6);

		System.out.println("Dodano kilka ogłoszeń.\n");
	}

	public static void loadAll() {
		try {
			File file1 = new File("OgłoszeniaDomy.csv");
			Scanner sc1 = new Scanner(file1);
			int temporary1 = 0;
			while (sc1.hasNextLine()) {
				String str = sc1.nextLine();
				String[] values = str.split(",");
				if (temporary1 > 0) {
					Advertisement ad = new House(values[0], values[1], values[2], Double.parseDouble(values[3]),
							Integer.parseInt(values[4]), Integer.parseInt(values[5]), Double.parseDouble(values[6]),
							Double.parseDouble(values[7]));
					
					ad.setDescription(values[8]);
					advertisementList.add(ad);
				}
				temporary1++;
			}
			sc1.close();

			File file2 = new File("OgłoszeniaAutoMotocykl.csv");
			Scanner sc2 = new Scanner(file2);
			int temporary2 = 0;
			while (sc2.hasNextLine()) {
				String str = sc2.nextLine();
				String[] values = str.split(",");
				if (temporary2 > 0 && values[1].equals("Auto")) {
					Advertisement ad = new Car(values[0], values[1], values[2], Double.parseDouble(values[3]),
							Integer.parseInt(values[4]), values[5], values[6], values[7], Integer.parseInt(values[8]),
							Integer.parseInt(values[9]), Double.parseDouble(values[10]),
							Double.parseDouble(values[11]));
					
					ad.setDescription(values[12]);
					advertisementList.add(ad);
				}
				if (temporary2 > 0 && values[1].equals("Motocykl")) {
					Advertisement ad = new Motorcycle(values[0], values[1], values[2], Double.parseDouble(values[3]),
							Integer.parseInt(values[4]), values[5], values[6], values[7], Integer.parseInt(values[8]),
							Integer.parseInt(values[9]), Double.parseDouble(values[10]),
							Double.parseDouble(values[11]));
					
					ad.setDescription(values[12]);
					advertisementList.add(ad);
				}
				temporary2++;
			}
			sc2.close();
		} catch (FileNotFoundException e) {
			System.out.println("Nie ma takiego pliku");
		}
		System.out.println("Wczytano ogłoszenia z plików.\n");
	}

	public static void saveAll() {

		try {
			PrintWriter pwD = new PrintWriter(new File("OgłoszeniaDomy.csv"));
			pwD.append("Typ,");
			pwD.append("Tytuł,");
			pwD.append("Miejsce,");
			pwD.append("Cena,");
			pwD.append("Telefon,");
			pwD.append("Ilość pokoji,");
			pwD.append("Metry^2,");
			pwD.append("Działka,");
			pwD.append("Opis");
			pwD.append("\n");

			for (Advertisement adw : advertisementList) {
				if (adw.getTitle().equals("Dom") || adw.getTitle().equals("Mieszkanie")) {
					House house = (House) adw;
					pwD.append(adw.getType() + ",");
					pwD.append(adw.getTitle() + ",");
					pwD.append(adw.getPlace() + ",");
					pwD.append(adw.getPrice() + ",");
					pwD.append(adw.getPhoneNumber() + ",");
					pwD.append(house.getNumberOfRooms() + ",");
					pwD.append(house.getHouseArea() + ",");
					pwD.append(house.getLandArea() + ",");
					pwD.append(house.getDescription());
					pwD.append("\n");
				}
			}
			pwD.close();

			PrintWriter pwA = new PrintWriter(new File("OgłoszeniaAutoMotocykl.csv"));
			pwA.append("Typ,");
			pwA.append("Tytuł,");
			pwA.append("Miejsce,");
			pwA.append("Cena,");
			pwA.append("Telefon,");
			pwA.append("Marka,");
			pwA.append("Model,");
			pwA.append("Paliwo,");
			pwA.append("Rok,");
			pwA.append("Moc,");
			pwA.append("Przebieg,");
			pwA.append("Pojemność,");
			pwA.append("Opis");
			pwA.append("\n");

			for (Advertisement adw : advertisementList) {
				if (adw.getTitle().equals("Auto")) {

					Car car = (Car) adw;
					pwA.append(adw.getType() + ",");
					pwA.append(adw.getTitle() + ",");
					pwA.append(adw.getPlace() + ",");
					pwA.append(adw.getPrice() + ",");
					pwA.append(adw.getPhoneNumber() + ",");
					pwA.append(car.getMark() + ",");
					pwA.append(car.getModel() + ",");
					pwA.append(car.getFuel() + ",");
					pwA.append(car.getYear() + ",");
					pwA.append(car.getEnginePower() + ",");
					pwA.append(car.getMileage() + ",");
					pwA.append(car.getEngineCapacity() + ",");
					pwA.append(car.getDescription());
					pwA.append("\n");
				}
				if (adw.getTitle().equals("Motocykl")) {
					Motorcycle mot = (Motorcycle) adw;
					pwA.append(adw.getType() + ",");
					pwA.append(adw.getTitle() + ",");
					pwA.append(adw.getPlace() + ",");
					pwA.append(adw.getPrice() + ",");
					pwA.append(adw.getPhoneNumber() + ",");
					pwA.append(mot.getMark() + ",");
					pwA.append(mot.getModel() + ",");
					pwA.append(mot.getFuel() + ",");
					pwA.append(mot.getYear() + ",");
					pwA.append(mot.getEnginePower() + ",");
					pwA.append(mot.getMileage() + ",");
					pwA.append(mot.getEngineCapacity() + ",");
					pwA.append(mot.getDescription());
					pwA.append("\n");
				}
			}
			pwA.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Zapisano ogłoszenia do plików.\n");

	}

	public static void priceRange(String title, double minPrice, double maxPrice) {

		System.out.println("Rozpoczęto wyszukiwanie ogłoszeń.\n");
		int counter = 0;
		for (Advertisement adw : advertisementList) {

			if (title.equals(adw.getTitle())) {
				if (minPrice <= adw.getPrice() && maxPrice >= adw.getPrice()) {
					System.out.println(adw);
					counter++;
				}
			}
		}
		if (counter == 0) {
			System.out.println("Brak ogłoszeń spełniających twoje kryteria.\n");
		} else {
			System.out.println("Ilość ogłoszeń spełniających kryteria: " + counter + "\n");
		}

	}
	
	public static void maxPriceMinCapacityOrArea(String title, double maxPrice, double minCapacityOrArea) {

		System.out.println("Rozpoczęto wyszukiwanie ogłoszeń.\n");
		int counter = 0;
		for (Advertisement adw : advertisementList) {

			if (title.equals(adw.getTitle())) {
				if (title.equals("Dom") || title.equals("Mieszkanie")) {
					House house = (House) adw;
					if (maxPrice >= house.getPrice() && minCapacityOrArea <= house.getHouseArea()) {
						System.out.println(house);
						counter++;
					}
				}
				if (title.equals("Auto") || title.equals("Motocykl")) {
					Car car = (Car) adw;
					if (maxPrice >= car.getPrice() && minCapacityOrArea <= car.getEngineCapacity()) {
						System.out.println(car);
						counter++;
					}
				}
			}
		}
		if (counter == 0) {
			System.out.println("Brak ogłoszeń spełniających twoje kryteria.\n");
		} else {
			System.out.println("Ilość ogłoszeń spełniających kryteria: " + counter + "\n");
		}

	}

}
