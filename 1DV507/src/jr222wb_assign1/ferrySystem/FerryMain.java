package jr222wb_assign1.ferrySystem;

public class FerryMain {
	public static void main(String[] args) {
		StenaLine ferry = new StenaLine();
				
		//Create and embark cars
		for (int i = 0; i < 7; i++) { 
			Vehicle car = new Car();
			ferry.embark(car);
		}
		
		//Create and embark busses
		Vehicle bus1 = new Bus();
		Vehicle bus2 = new Bus();
		Vehicle bus3 = new Bus();
		Vehicle bus4 = new Bus();
		Vehicle bus5 = new Bus();
		ferry.embark(bus1);
		ferry.embark(bus1); //Try to embark a vehicle twice
		ferry.embark(bus2);
		ferry.embark(bus3);
		ferry.embark(bus4);
		ferry.embark(bus5);
		
		
		//Create and embark lorries
		Vehicle lorry1 = new Lorry();
		Vehicle lorry2 = new Lorry();		
		ferry.embark(lorry1);
		ferry.embark(lorry2);
		
		
		//Create and embark bikes
		for (int i = 0; i < 27; i++) {
			Vehicle bicycle = new Bicycle();
			ferry.embark(bicycle);
		}
		
		//Bring on passengers without vehicles
		for (int i = 0; i < 120; i++) {
			Passenger person = new Passenger();
			ferry.embark(person);
		}
		
		//The public methods of the ferry
		System.out.println("Money: " + ferry.countMoney());
		System.out.println("Passengers: " + ferry.countPassengers());
		System.out.println("Vehicle space: " + ferry.countVehicleSpace());
		System.out.println(ferry.toString());
		
		//Disembarking
		ferry.disembark();
		System.out.println(ferry.toString());
	}
}
