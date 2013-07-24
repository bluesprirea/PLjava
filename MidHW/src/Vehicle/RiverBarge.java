package Vehicle;

public class RiverBarge extends Vehicle{
	private double distance;
	private double efficiency;
	
	public RiverBarge(double distance, double efficiency)
	{
		this.distance = distance;
		this.efficiency = efficiency;
	}
	
	public double clacFuelEfficiency(){
		return this.efficiency;
	}
	public double clacTripDistance(){
		return this.distance;
	}
}
