package jr222wb_assign1.ferrySystem;

import java.util.ArrayList;
import java.util.Random;

public abstract class Vehicle {
	protected ArrayList<Passenger> passengers = new ArrayList<Passenger>(); //List keeping passengers
	protected int space; //Space a specific vehicle takes up	

	protected Vehicle(int maxPassengers, int size) { //Each subclass has to provide its max passenger and size		
		space = size;
		Random r = new Random(); //Number of passengers in each vehicle is randomized
		int nPassenger = r.nextInt(maxPassengers) + 1;
		for (int i = 0; i < nPassenger; i++) {
			Passenger p = new Passenger();
			this.passengers.add(p);
		}		
	}

	public ArrayList<Passenger> getPassengers() { //Returns a copy of passengers for the ferry
		return new ArrayList<Passenger>(passengers);		
	}

	public int countPassengers() { //Number of passengers in the vehicle
		return passengers.size();
	}	
}
