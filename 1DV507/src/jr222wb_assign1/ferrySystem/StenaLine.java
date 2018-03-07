package jr222wb_assign1.ferrySystem;

import java.util.ArrayList;
import java.util.Iterator;

public class StenaLine implements Ferry {
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	private int money = 0, usedSpace = 0, bicycleCount = 0;	

	public int countPassengers() {		
		return passengers.size();
	}

	public int countVehicleSpace() {		
		return usedSpace;
	}

	public int countMoney() {		
		return money;
	}

	public Iterator<Vehicle> iterator() {
		return vehicles.iterator();
	}

	public void embark(Vehicle v) {
		if (vehicles.contains(v)) { //Check if vehicle is already on board
			System.out.println("That vehicle has already embarked");
			return;
		}
		
		if (hasSpaceFor(v)) { //Check if there's room for vehicle and passengers				
			vehicles.add(v); //Add vehicle to ferry			
			for (Passenger p : v.getPassengers()) //Add vehicle's passenger to ferry
				passengers.add(p);
			if (v instanceof Bicycle) {				
				bicycleCount++;
				if (bicycleCount % 5 == 1) //Increase space taken when a new lot contains bikes
					usedSpace++;
			}
			else
				usedSpace += v.space; //Increase used space
			money += calcCost(v); //Add the money from vehicle and passengers
		}		

		else
			System.out.println("Not enough room for vehicle or passengers.");		
	}

	public void embark(Passenger p) {
		if (hasRoomFor(p)) { //If there's room for passenger, let it embark
			passengers.add(p);
			money += 20; //Add 20 to earned money 
		}
		else
			System.out.println("Not enough room for the passenger.");
	}

	public void disembark() { //Empty lists and reset counters
		passengers.clear();
		vehicles.clear();
		usedSpace = 0;
		bicycleCount = 0;
	}

	public boolean hasSpaceFor(Vehicle v) {
		if (v.countPassengers() + passengers.size() <= 200) { //If there's room for passengers
			if (v.space + usedSpace <= 40 && !(v instanceof Bicycle)) //And there's space left for the vehicle type				
				return true;

			/* Or if it's a bike and there's space left or the last lot isn't full yet
			 * Since the embark method adds a used space every fifth bike, this statement 
			 * checks if the current lot has reached 5 yet */
			else if (v instanceof Bicycle && (usedSpace < 40 || (usedSpace == 40 && bicycleCount % 5 != 0)))  
				return true;
		}
		return false;
	}

	public boolean hasRoomFor(Passenger p) { 
		if (passengers.size() < 200)
			return true;
		return false;
	}

	public String toString() {
		int cars = 0, busses = 0, lorries = 0;
		for (Vehicle v : vehicles) { //Count each vehicle type
			if (v instanceof Car)
				cars++;
			else if (v instanceof Bus)
				busses++;
			else if (v instanceof Lorry)
				lorries++;
		}
		StringBuilder msg = new StringBuilder(); //Construct a return string
		msg.append("\n CURRENTLY EMBARKED:\n");
		msg.append(".-----------------------------------------------.");
		msg.append("\n|\tBicycles: " + bicycleCount + "\t|\tCars: " + cars + "\t\t|");		
		msg.append("\n|-----------------------+-----------------------|");
		msg.append("\n|\tBusses: " + busses + "\t|\tLorries: " + lorries + "\t|");		
		msg.append("\n'-----------------------------------------------'");
		msg.append("\n Space left: " + (40 - usedSpace) + "/40");
		msg.append("\n Passengers: " + passengers.size() + "/200");
		msg.append("\n Money made: " + money + " kr");
		return msg.toString();
	}	

	private int calcCost(Vehicle v) { //Helper method to calculate cost upon embarking
		if (v instanceof Bicycle)
			return 40;
		else if (v instanceof Car)
			return 100 + v.countPassengers() * 15;
		else if (v instanceof Bus)
			return 200 + v.countPassengers() * 10;
		else
			return 300 + v.countPassengers() * 15;
	}
}
