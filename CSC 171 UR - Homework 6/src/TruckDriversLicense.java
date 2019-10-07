/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 6
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

public class TruckDriversLicense extends DriversLicense {
	
	public TruckDriversLicense() {
		super();
	}
	
	@Override
	public String toString() {
		String str = "[Truck-Drivers License Info]\n";

		String[] d = super.toString().split("\n");
		
		for (int i = 1; i < d.length; i++) { //Remove tag from parent.
			str+=d[i] + "\n";
		}
		
		return str;
	}

}
