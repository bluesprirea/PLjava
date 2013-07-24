package Main_test;

import java.util.ArrayList;

import Vehicle.Vehicle;

public class Company {
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	private static Company c = new Company();
	public static Company getInstance(){
		return c;
	}
	public ArrayList<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void addVehicle(Vehicle vehicle) {
		vehicleList.add(vehicle);
	}
	
} 



