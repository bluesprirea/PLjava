package Vehicle;

public abstract class Vehicle {

	public abstract double clacFuelEfficiency();
	public abstract double clacTripDistance();
	
	public final double calFuelNeeds()
	{
		return clacTripDistance() / clacFuelEfficiency();
	}
	
}
