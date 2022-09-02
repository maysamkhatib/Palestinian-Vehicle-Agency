package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	// Main method
	public static void main(String[] args) throws Exception {
		int option; // variable to store the user's choosen option
		ArrayList<Vehicles> vehicles = null; // decalring an arrayList from vehicles type
		int count = 0; // variable to check if we read from the file
		int sort = 0; // variable to check if we sorted the arrayList
		Scanner sc = new Scanner(System.in);
		menu(); // call the menu
		option = sc.nextInt(); // Read the option from the user
		// while loop to perform the operations until the user enters 9
		while (option != 9) {
			// the cases to choose from depending on user's input and each case will lead to
			// a specific method
			switch (option) {
			case 1:
				vehicles = case1();
				count++; // if its not zero this mean that we read from the file.
				System.out.println("The reading from the file is done.");
				break;
			case 2:
				case2();
				break;
			case 3:
				if (count != 0) {// it should had been readen from the file before perform this case
					printList(case3(vehicles));
					sort++; // if its not zero this mean that we sorted the arrayList.
				} else {
					System.out.println("You did not read from the file.");
				}
				break;
			case 4:
				if (count != 0) {// it should had been readen from the file before perform this case
					printList(case4(vehicles));
					sort++; // if its not zero this mean that we sorted the arrayList.
				} else {
					System.out.println("You did not read from the file.");
				}
				break;
			case 5:
				if (count != 0) {// it should had been readen from the file before perform this case
					printList(case5(vehicles));
					sort++; // if its not zero this mean that we sorted the arrayList.
				} else {
					System.out.println("You did not read from the file.");
				}
				break;
			case 6:
				if (count != 0) {// it should had been readen from the file before perform this case
					case6(vehicles);
				} else {
					System.out.println("You did not read from the file.");
				}
				break;
			case 7:
				if (count != 0) {// it should had been readen from the file before perform this case
					case7(vehicles);
				} else {
					System.out.println("You did not read from the file.");
				}
				break;
			case 8:
				if (count != 0) { // it should had been readen from the file before perform this case
					if (sort != 0) { // it should had been sorted before perform this case
						case8(vehicles);
					} else {
						System.out.println("The vehicles didn't sorted yet.");
					}
				} else {
					System.out.println("You did not read from the file.");
				}
				break;
			default:
				// any other value will cause a run time error
				throw new IllegalArgumentException("Unexpected value: " + option);
			}
			menu();
			option = sc.nextInt();
		}
		// ending the program
		System.out.println("Thank you!\nThe program is ended.");
	}

	// A method to print a menu of operation that the user should choose from it.
	public static void menu() {
		System.out.println("***************************************************************************************");
		System.out.println("Select an operation: ");
		System.out.println("1.Read the data about objects from the file “inputdata.txt” and store them in Arraylist.");
		System.out.println("2.Set prices of petroleum.");
		System.out.println("3.Print sorted order Vehicles in an ascending order based on costFor100Km.");
		System.out.println("4.Print sorted order Vehicles in an ascending order based on owner name.");
		System.out.println("5.Print sorted order Vehicles in an descending order based on vehicle brand.");
		System.out.println("6.Clone Vehicle without owner.");
		System.out.println("7.Turn air-condition on.");
		System.out.println("8.Write Output on the “output.txt” file after sort them.");
		System.out.println("9.Exit from System.");
		System.out.println("***************************************************************************************");
	}

	// A method to print the information of array list contents
	public static void printList(ArrayList<Vehicles> v) {
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i).toString());
		}
	}

	// The method that read the file and fill the arrayList of vehicles type and
	// return it.
	public static ArrayList<Vehicles> case1() throws Exception {
		// declare file
		File file = new File("C:\\Users\\HP\\eclipse-workspace\\Project\\src\\Project\\inputdata.txt");
		Scanner input = new Scanner(file); // read from the file
		ArrayList<Vehicles> Vehicle = new ArrayList<Vehicles>();
		// fill the arrayList from the file
		// while loop that will continue where there is lines
		while (input.hasNextLine()) {
			String line = input.nextLine(); // read a line
			StringBuilder stringBuilder = new StringBuilder(line); // store a line in a string builder
			String[] elements = stringBuilder.toString().split(","); // split the line by the comma between the data
			String type = elements[0]; // the type of Vehicles will be the first word in the line
			Vehicles v;
			// if element[0] is not a car or truck or minivan, an error will occur.
			if (!type.equalsIgnoreCase("Car") && !type.equalsIgnoreCase("MiniVan") && !type.equalsIgnoreCase("Truck"))
				throw new IllegalArgumentException("Mismatch filling type of Vehicle.");
			// if the type is car, v will be filled according to the data after the type
			if (type.equalsIgnoreCase("Car")) {
				v = new Car(elements[1], elements[2], elements[3], new Owner(elements[4]), elements[5].trim(),
						Double.parseDouble(elements[6].trim()), Double.parseDouble(elements[7].trim()),
						Integer.parseInt(elements[8].trim()));
				// if the type is minivan, v will be filled according to the data after the type
			} else if (type.equalsIgnoreCase("MiniVan")) {
				v = new Minivan(elements[1], elements[2], elements[3], new Owner(elements[4]), elements[5].trim(),
						Double.parseDouble(elements[6].trim()), Double.parseDouble(elements[7].trim()),
						Integer.parseInt(elements[8].trim()), Boolean.parseBoolean(elements[9]));
				// if the type is truck, v will be filled according to the data after the type
			} else /* if (type.equalsIgnoreCase("Truck")) */ {
				v = new Truck(elements[1], elements[2], elements[3], new Owner(elements[4]), elements[5].trim(),
						Double.parseDouble(elements[6].trim()), Double.parseDouble(elements[7].trim()),
						Integer.parseInt(elements[8].trim()), Integer.parseInt(elements[9].trim()));
			}
			// add v to the arrayList
			Vehicle.add(v);
		}
		input.close();
		return Vehicle;
	}

	// A method that change the price of petroleum
	public static void case2() {
		Scanner in = new Scanner(System.in);
		System.out.println("Set the Price of Diesel: ");
		double dPrice = in.nextDouble(); // read diesel price
		PetroleumType.setDieselPrice(dPrice);
		System.out.println("Set the Price of Gasoline: ");
		double gPrice = in.nextDouble(); // read gasoline price
		PetroleumType.setGasolinePrice(gPrice);
	}

	// Sort the arrayList in an ascending order based on costFor100Km
	public static ArrayList<Vehicles> case3(ArrayList<Vehicles> v) {
		Collections.sort(v);
		return v;
	}

	// Sort the arrayList in an ascending order based on the owner name
	public static ArrayList<Vehicles> case4(ArrayList<Vehicles> v) {
		Vehicles temp;
		Vehicles[] arr = new Vehicles[v.size()]; // Creating an array which its size = arrayList size
		v.toArray(arr); // here we chnge the arrayList to array to make the sorting easier
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				// If the first letter of the first element is greater than the first letter in
				// the second one, they will be exchanged! and so on
				if (arr[i].owner.getName().compareTo(arr[j].owner.getName()) > 0) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		v.clear(); // clear all the elements in the arrayList
		for (int i = 0; i < arr.length; i++) {
			v.add(arr[i]); // refill the array according to the sorting
		}
		return v;
	}

	// Sort the arrayList in an descending order based on the brand name
	public static ArrayList<Vehicles> case5(ArrayList<Vehicles> v) {
		Vehicles temp;
		Vehicles[] arr = new Vehicles[v.size()]; // Creating an array which its size = arrayList size
		v.toArray(arr); // here we chnge the arrayList to array to make the sorting easier
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				// If the first letter of the first element is less than the first letter in
				// the second one, they will be exchanged! and so on
				if (arr[i].getBrand().compareTo(arr[j].getBrand()) < 0) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		v.clear();// clear all the elements in the arrayList
		for (int i = 0; i < arr.length; i++) {
			v.add(arr[i]);// refill the array according to the sorting
		}
		return v;
	}

	// Clone a selected vehicle from the user
	public static void case6(ArrayList<Vehicles> v) throws CloneNotSupportedException {
		System.out.println("Choose an object to clone it: ");
		int i;
		// Print the vehicles on the console to allow the user to choose an vehicles
		for (i = 0; i < v.size(); i++) {
			System.out.println(i + "- " + v.get(i).toString());
		}
		Scanner choose = new Scanner(System.in);
		int opt = choose.nextInt(); // read the number of the vehicles that the user choose
		v.add((Vehicles) v.get(opt).clone()); // clone the choosen vehicles
		v.get(i).owner = new Owner();
		System.out.println("Cloning is done.");
	}

	// Turn on all air conditions
	public static void case7(ArrayList<Vehicles> v) throws Exception {
		Scanner scan = new Scanner(System.in);
		// turn ACs on
		for (int i = 0; i < v.size(); i++) {
			v.get(i).SetAirConditionOn();
		}
		// allow the user to choose an option
		System.out.println("The air conditions are setted on.");
		System.out.println("You can again select one of steps 3-6, the output should be print on file.");
		System.out.println("3.Print sorted order Vehicles in an ascending order based on costFor100Km.");
		System.out.println("4.Print sorted order Vehicles in an ascending order based on owner name.");
		System.out.println("5.Print sorted order Vehicles in an descending order based on vehicle brand.");
		System.out.println("6.Clone Vehicle without owner.");
		int x = scan.nextInt(); // read the option
		switch (x) {
		case 3: {
			case8(case3(v)); // print the sorted arrayList in the file
			break;
		}
		case 4: {
			case8(case4(v)); // print the sorted arrayList in the file
			break;
		}
		case 5: {
			case8(case5(v)); // print the sorted arrayList in the file
			break;
		}
		case 6: {
			case6(v); // clone an object
			case8(v); // print the arrayList with the cloned object in the file
			break;
		}
		default:
			// any other value will cause a run time error
			throw new IllegalArgumentException("Unexpected value: " + x);
		}
	}

	// A method to print the ArrayList in file
	public static void case8(ArrayList<Vehicles> v) throws FileNotFoundException {
		File file = new File("output.txt"); // create the output file
		PrintWriter pWriter = new PrintWriter(file); // create a print writer to write on our file
		// print the all objects
		for (int i = 0; i < v.size(); i++) {
			pWriter.write(v.get(i).toString());
		}
		pWriter.close(); // close the printWriter
		System.out.println("Writing the output is done.");
	}
}
