package com.jloysch;

public class Universe {
	
	private double GRAVITY;
	
	public Universe() {
		this.GRAVITY = -9.8;
	}

	public double getGravity() {
		return this.GRAVITY;
	}
	
	public void setGravity(double gravity) {
		this.GRAVITY = gravity;
	}
	
	public double addDrag(double VELOCITY, double ANGLE, double TARGET_DISTANCE) {
		//Vx = VoCos(Theta)*e^(-gt/Vt)
		
		double xTAN = TARGET_DISTANCE*Math.tan(Math.toRadians(ANGLE));
		double gxSquared = this.GRAVITY*Math.pow(TARGET_DISTANCE, 2);
		double bottomTan = 2*(Math.pow((VELOCITY*Math.cos(Math.toRadians(ANGLE))), 2));
		return (xTAN - ((gxSquared)/(bottomTan)));
	}
	
	public double getDragDifference(Catapult c) {
		return c.getProjectileHeight() - addDrag(c.getVelocity(), c.getAngle(), c.getTargetDistance());
	}
	
	
}
