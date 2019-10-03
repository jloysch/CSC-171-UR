package com.jloysch;


public class Wall {
	
	private int WALL_DISTANCE, WALL_HEIGHT, GB_L = 0, REGENERATIONS = 0;
	private String DEBUG_TAG = "@DEBUG >> ";
	private boolean DEBUG = false;

	public Wall() {
		this.regenerate();
	}
	
	public Wall(int[] DISTANCE_BOUNDS, int[] HEIGHT_BOUNDS) {
		this.WALL_DISTANCE = generateGoodBoundNumber(DISTANCE_BOUNDS[0], DISTANCE_BOUNDS[1], true);
		this.WALL_HEIGHT = generateGoodBoundNumber(HEIGHT_BOUNDS[0], HEIGHT_BOUNDS[1], false);
		this.REGENERATIONS++;
	}
	
	private int generateGoodBoundNumber(int LOWER_BOUND, int UPPER_BOUND, boolean DIST_HEIGHT) {
		int factor = 1;
		while (true) {
			int temp = (int) ((UPPER_BOUND-LOWER_BOUND+factor)*Math.random());

			if (this.DEBUG) {
				if (DIST_HEIGHT) {
					System.out.println(DEBUG_TAG + " " + temp + " generated for wall distance.");
				} else {
					System.out.println(DEBUG_TAG + " " + temp + " generated for wall height.");
				}
			}
			
			if ((temp > LOWER_BOUND) && (temp < UPPER_BOUND)) {
				if ((temp-LOWER_BOUND > 1) && (UPPER_BOUND-temp > 1)) {
					if (this.isUnique(temp, DIST_HEIGHT)) {
						if (this.DEBUG) {
							if (DIST_HEIGHT) {
								System.out.println(DEBUG_TAG + "Unique number generated for wall distance.");
							} else {
								System.out.println(DEBUG_TAG + "Unique number generated for wall height.");
							}
						}
						GB_L = 0;
						return temp;
					}
				} 
			} 
			if (this.DEBUG) {
				System.out.println(DEBUG_TAG + " LOOP FAILS = " + GB_L + " with factor count " + factor);
			}
			if (GB_L >= 50) {
				
				factor++;
				GB_L=0;
			}
			
			if (factor >= UPPER_BOUND) {
				factor=1;
			}
			GB_L++;
		}
	}
	
	private boolean isUnique(int x, boolean DIST_HEIGHT) {
		if (DIST_HEIGHT) {
			if (!(x==this.WALL_DISTANCE)) {
				if (this.DEBUG) {
					if (DIST_HEIGHT) {
						System.out.println(DEBUG_TAG + "Number generated for wall distance IS unique.");
					} else {
						System.out.println(DEBUG_TAG + "Number generated for wall distance IS unique");
					}
				}
				return true;
			} else {
				if (DIST_HEIGHT) {
					System.out.println(DEBUG_TAG + "Number generated for wall distance IS NOT unique.");
				} else {
					System.out.println(DEBUG_TAG + "Number generated for wall distance IS NOT unique");
				}
				return false;
			}
		} else {
			if (!(x==this.WALL_HEIGHT)) {
				if (this.DEBUG) {
					if (DIST_HEIGHT) {
						System.out.println(DEBUG_TAG + "Number generated for wall height IS unique.");
					} else {
						System.out.println(DEBUG_TAG + "Number generated for wall height IS unique");
					}
				}
				return true;
			} else {
				if (this.DEBUG) {
					if (DIST_HEIGHT) {
						System.out.println(DEBUG_TAG + "Number generated for wall distance IS NOT unique.");
					} else {
						System.out.println(DEBUG_TAG + "Number generated for wall height IS NOT unique");
					}
				}
				return false;
			}
		}
	}

	/*	-- Deprecated --
	private void regenerateWallHeight(int LOWER_BOUND, int UPPER_BOUND) {
		 this.WALL_HEIGHT = generateGoodBoundNumber(LOWER_BOUND, UPPER_BOUND);
	}
	
	private void regenerateWallDistance(int LOWER_BOUND, int UPPER_BOUND) {
		this.WALL_DISTANCE = generateGoodBoundNumber(LOWER_BOUND, UPPER_BOUND);
	}
	 */
	
	public void regenerate() {
		
		if (this.DEBUG) {
			System.out.println(DEBUG_TAG + "Regenerating wall.");
		}
		
		this.WALL_DISTANCE = generateGoodBoundNumber(10, ((int) (31 * Math.random())+20), true);
		this.WALL_HEIGHT = generateGoodBoundNumber(12, ((int) (20 * Math.random())+22), false);
		this.REGENERATIONS++;
	}
	
	public void regenerate(int[] DISTANCE_BOUNDS, int[] HEIGHT_BOUNDS) {
		
		if (this.DEBUG) {
			System.out.println(DEBUG_TAG + "Regenerating wall.");
		}
		
		this.WALL_DISTANCE = generateGoodBoundNumber(DISTANCE_BOUNDS[0], DISTANCE_BOUNDS[1], true);
		this.WALL_HEIGHT = generateGoodBoundNumber(HEIGHT_BOUNDS[0], HEIGHT_BOUNDS[1], false);
		this.REGENERATIONS++;
	}
	
	public void setDebugMode(boolean TF) {
		this.DEBUG = TF;
	}
	
	public void DEBUG(int LOOPS, boolean VERBOSE) {
		
		this.setDebugMode(VERBOSE);
		
		for (int i = 0; i < LOOPS; i++) {
			this.regenerate();
			this.toString();
		}
	}
	
	public void setHeight(int HEIGHT) {
		this.WALL_HEIGHT = HEIGHT;
	}
	
	public void setDistance(int DISTANCE) {
		this.WALL_DISTANCE = DISTANCE;
	}
	
	public int getHeight() {
		return this.WALL_HEIGHT;
	}
	
	public int getDistance() {
		return this.WALL_DISTANCE;
	}
	
	public void DEBUG(int LOOPS, boolean VERBOSE, int[] DISTANCE_BOUNDS, int[] HEIGHT_BOUNDS) {
		for (int i = 0; i < LOOPS; i++) {
			this.regenerate(DISTANCE_BOUNDS, HEIGHT_BOUNDS);
		}
	}
	
	@Override //--debug purposes--
	public String toString() {
		if (this.DEBUG) {
			System.out.println("This wall is " + this.WALL_DISTANCE + "ft. away from the user, and " 
					+ this.WALL_HEIGHT + "ft. tall.\nThis wall also has " + this.REGENERATIONS 
					+ " regenerations." );
			return "";
		} else {
			return "This wall is " + this.WALL_DISTANCE + "ft. away from the user, and " 
					+ this.WALL_HEIGHT + "ft. tall.\nThis wall also has " + this.REGENERATIONS 
					+ " regenerations." ;
		}
	}
}
