package com.jloysch;

public class Projectile {
	
	private double MASS;
	
	public Projectile() {
		this.MASS = 5;
	}
	
	public Projectile(double MASS) {
		this.MASS = MASS;
	}
	
	@Override
	public String toString() {
		return "Projectile with mass of " + this.MASS + " grams.";
	}

}
