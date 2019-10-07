/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 6
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

public class Main {

	
	public static void main(String args[]) {
		
		Student a = new Student("University of Rochester", "Computer Science");
		Student b = new Student();
		
		a.setName("Josh");
		b.setName("Avery");
		
		License d = new License();
		License e = new License();
		
		License f = new DriversLicense();
		
		License g = new DriversLicense();
		
		License z = new TruckDriversLicense();
		
		FishingLicense x = new FishingLicense();
		
		
		System.out.println(a + "\n" + b);
		
		System.out.println(a.getName() + "'s greeting > " +  a.greeting() + "\n" + b.getName() + "'s greeting > " + b.greeting() + "\n\n");
		
		System.out.println(d);
		
		System.out.println(d.equals(e));
		
		System.out.println("\n\n" + f);
		
		System.out.println("\n\nDrivers License equals check >> " + f.equals(g) + "\n\n");
		
		System.out.println(z+"\n\n");
		
		x.addAllowedFish("BASS");
		x.addAllowedFish("SEAL");
		x.addAllowedFish("TROUT");
		
		System.out.println(x);
	}

}
