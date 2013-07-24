package Main_test;

import java.io.PrintStream;
import Vehicle.Vehicle;
import Main_test.Company;

public class FuelNeedsReport {
	private Company c;
	
	public FuelNeedsReport(){
		this.c = Company.getInstance();
	}
	public void generateText(PrintStream out){
		for(Vehicle a:this.c.getVehicleList()){
			out.println(a.calFuelNeeds());
		}
	}
}
