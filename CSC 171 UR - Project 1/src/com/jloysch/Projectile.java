/*
 * Name: Joshua Loysch
 * NetID: jloysch
 * Assignment Number: Project One
 * Lab Section Day/Time: MW, 2:00-3:15PM
 * 
 * I did not collaborate with anyone on this assignment.
 * 
 */
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
