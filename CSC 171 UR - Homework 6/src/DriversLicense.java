/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 6
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

public class DriversLicense extends License{

	private String STATE_OF_RESIDENCE;
	
	public DriversLicense() {
		super();
		this.STATE_OF_RESIDENCE = null;
	}
	
	public DriversLicense(String STATE_OF_RESIDENCE) {
		super();
		this.STATE_OF_RESIDENCE = STATE_OF_RESIDENCE;
	}
	
	public String getStateOfResidence() {
		return this.STATE_OF_RESIDENCE;
	}
	
	@Override
	public boolean equals(License l) {
		String a[] = super.getLicenseStats();
		String b[] = l.getLicenseStats();
		int c = 0;
		
		/*
		 * Just simply getting the attributes of the parent as an array, not including the state of course, and comparing them.
		 */
		
		for (int i = 0; i < super.getLicenseStats().length; i++) {
			if (a[i].equalsIgnoreCase(b[i])) {
				c++;
			} 
		}
		
		if (c == a.length) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		
		String str = "[Drivers License Info]\nState of Residence\t>> " + this.STATE_OF_RESIDENCE + "\n";

		String[] d = super.toString().split("\n");
		
		for (int i = 1; i < d.length; i++) { //Remove tag from parent.
			str+=d[i] + "\n";
		}
		
		return str;
	}
}
