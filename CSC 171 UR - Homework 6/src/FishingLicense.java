/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Homework 6
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */

import java.util.ArrayList;

public class FishingLicense extends License {
	
	private ArrayList<String> ALLOWED_FISH;
	
	public FishingLicense() {
		super();
		this.ALLOWED_FISH = new ArrayList<String>();
	}
	
	public FishingLicense(String[] ALLOWED_FISH) {
		for (int i = 0; i < ALLOWED_FISH.length; i++) {
			this.ALLOWED_FISH.set(i, ALLOWED_FISH[i]);
		}
	}
	
	public void addAllowedFish(String FISH) {
		this.ALLOWED_FISH.add(FISH);
	}
	
	public void setAllowedFish(String[] FISH) {
		this.ALLOWED_FISH = new ArrayList<String>();
		for (int i = 0; i < FISH.length; i++) {
			this.ALLOWED_FISH.add(FISH[i]);
		}
	}
	
	
	@Override
	public String toString() {
		String str = "[Fishing License Info]\nFish Allowed\t\t>> ";
		
		if (ALLOWED_FISH.size() == 0) {
			str+="(This person isn't allowed to fish for anything.)";
		} else {
			for (int i = 0; i < ALLOWED_FISH.size(); i++) {
				str+= ALLOWED_FISH.get(i);
				
				if ((ALLOWED_FISH.size() >= 2) && (i < ALLOWED_FISH.size()-1)) {
					str+= ", ";
				} 
			}
		}
		
		
		str+="\n";
		
		String[] a = super.toString().split("\n");
		
		for (int i = 1; i < a.length; i++) {
			str+=a[i]+"\n";
		}
		
		return str;
		
	}

}
