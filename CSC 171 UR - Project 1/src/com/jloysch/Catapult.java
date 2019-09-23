package com.jloysch;

public class Catapult {
	
	private double VELOCITY, ELEVATION, HEIGHT, ANGLE, TARGET_DISTANCE;
	private double GRAV_CONSTANT = -9.8;

	public Catapult() {
		this.VELOCITY = 0;
		this.ELEVATION = 0;
		this.HEIGHT = 0;
		this.ANGLE = 0;
		this.TARGET_DISTANCE = 0;
	}

	public double calculateProjectileHeight() {
		return ((this.TARGET_DISTANCE*(Math.tan(Math.toDegrees(this.ANGLE)))-((this.GRAV_CONSTANT*(Math.pow(this.TARGET_DISTANCE, 2.0)))/(2.0*(Math.pow(((this.VELOCITY)*Math.cos(this.ANGLE)),2))))));
	}
	
	public void launch() {
		
	}

	public void launch(double SPEED, double ELEVATION, double HEIGHT) {
		
	}
	
	public void setSpeed(double SPEED) {
		this.VELOCITY = SPEED;
	}
	
	public void setElevation (double ELEVATION) {
		this.ELEVATION = ELEVATION;
	}
	
	public void setHeight (double ELEVATION) {
		this.HEIGHT = HEIGHT;
	}
	
	public void setAngle(double ANGLE) {
		this.ANGLE = ANGLE;
	}
	
	public void setTargetDistance(int DISTANCE) {
		this.TARGET_DISTANCE = DISTANCE;
	}
	
	public void reset() {
		this.VELOCITY = 0;
		this.ELEVATION = 0;
		this.HEIGHT = 0;
	}
	
}
