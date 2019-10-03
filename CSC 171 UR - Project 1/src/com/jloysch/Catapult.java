package com.jloysch;

public class Catapult {
	
	//TODO Add height arguments

	private double VELOCITY, ANGLE, TARGET_DISTANCE, PJ_HEIGHT, GRAV_CONSTANT;
	private Universe UNIVERSE;

	public Catapult() {
		this.UNIVERSE = new Universe();
		this.GRAV_CONSTANT = UNIVERSE.getGravity();
		this.VELOCITY = 0;
		this.ANGLE = 0;
		this.TARGET_DISTANCE = 0;
	}

	public double calculateProjectileHeight(boolean drag) { //The height of the projectile at TARGET_DISTANCE.
		if (!drag) {
			/*
			double xTAN = this.TARGET_DISTANCE*Math.tan(Math.toRadians(ANGLE));
			double gxSquared = this.GRAV_CONSTANT*Math.pow(this.TARGET_DISTANCE, 2);
			double bottomTan = 2*(Math.pow((this.VELOCITY*Math.cos(Math.toRadians(ANGLE))), 2));
			this.PJ_HEIGHT = (xTAN - ((gxSquared)/(bottomTan)));
			*/
			
			return this.PJ_HEIGHT = (((this.TARGET_DISTANCE*Math.tan(Math.toRadians(ANGLE))) - (((this.GRAV_CONSTANT*Math.pow(this.TARGET_DISTANCE, 2))/(2*(Math.pow((this.VELOCITY*Math.cos(Math.toRadians(ANGLE))), 2)))))));
			//System.out.println(" DEBUGGG >>>> In line calculation good");
			
			//return this.PJ_HEIGHT;
			
		} else {
			return this.UNIVERSE.addDrag(this.VELOCITY, this.ANGLE, this.TARGET_DISTANCE);
		}
	}
	

	public void setSpeed(double SPEED) {
		this.VELOCITY = SPEED;
	}

	public void setAngle(double ANGLE) {
		this.ANGLE = ANGLE;
	}
	
	public void setTargetDistance(int DISTANCE) {
		this.TARGET_DISTANCE = DISTANCE;
	}
	
	public double getProjectileHeight() {
		return this.PJ_HEIGHT;
	}
	
	public double getVelocity() {
		return this.VELOCITY;
	}
	
	public double getAngle() {
		return this.ANGLE;
	}
	
	public double getTargetDistance() {
		return this.TARGET_DISTANCE;
	}
	
	public void reset() {
		this.VELOCITY = 0;
		this.ANGLE = 0;
		this.TARGET_DISTANCE = 0;
	}
	
}
