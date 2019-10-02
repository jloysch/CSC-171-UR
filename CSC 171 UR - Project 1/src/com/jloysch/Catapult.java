package com.jloysch;

public class Catapult {
	
	//TODO Add height arguments
	
	private double VELOCITY, ANGLE, TARGET_DISTANCE, PJ_HEIGHT;
	private double GRAV_CONSTANT = -9.8;

	public Catapult() {
		this.VELOCITY = 0;
		this.ANGLE = 0;
		this.TARGET_DISTANCE = 0;
	}

	public double calculateProjectileHeight() { //The height at distance X
		double xTAN = this.TARGET_DISTANCE*Math.tan(Math.toRadians(ANGLE));
		double gxSquared = this.GRAV_CONSTANT*Math.pow(this.TARGET_DISTANCE, 2);
		double bottomTan = 2*(Math.pow((this.VELOCITY*Math.cos(Math.toRadians(ANGLE))), 2));
		this.PJ_HEIGHT = (xTAN - ((gxSquared)/(bottomTan)));
		return this.PJ_HEIGHT;
	}
	
	//TODO add argument to calculateProjectileHeight(boolean wind) to account for wind resistance (Extra credit)3qr
	
	
	/* --deprecated--
	public void launch() {
		
	}
	*/
	/* --deprecated--
	public void launch(double SPEED, double ELEVATION, double HEIGHT) {
		
	}
	*/
	
	public void setSpeed(double SPEED) {
		this.VELOCITY = SPEED;
	}
	/* -- deprecated
	public void setElevation (double ELEVATION) {
		this.ELEVATION = ELEVATION;
	}
	
	public void setHeight (double ELEVATION) {
		this.HEIGHT = ELEVATION;
	}
	*/
	public void setAngle(double ANGLE) {
		this.ANGLE = ANGLE;
	}
	
	public void setTargetDistance(int DISTANCE) {
		this.TARGET_DISTANCE = DISTANCE;
	}
	
	/* --Not needed--
	public int getHeightAt(int DISTANCE) {
		
		return 0;
	}
	*/
	
	public void reset() {
		this.VELOCITY = 0;
		this.ANGLE = 0;
		this.TARGET_DISTANCE = 0;
		//this.ELEVATION = 0;
		//this.HEIGHT = 0;
	}
	
}
