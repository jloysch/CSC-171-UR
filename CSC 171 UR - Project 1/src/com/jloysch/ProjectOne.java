package com.jloysch;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ProjectOne {

	private static String LAUNCH_RESULT_PFX = "\t[Launch Result] >> ", DEBUG_PFX = "[*] @Debug >> ";
	private static int USER_SCORE, ROUND_NUMBER, WALL_NUMBER, WALL_ATTEMPTS;
	private static boolean PLAY = true, DEBUG = false;
	private static Catapult CATAPULT;
	private static DecimalFormat DF;
	private static Wall WALL;
	private static Scanner s;
	
	private static void initializeGame() {
		ROUND_NUMBER = 0;
		WALL_ATTEMPTS = 1;
		USER_SCORE = 0;
		WALL = new Wall();
	}
	
	private static void sleep(int n) {
		try {
			TimeUnit.MILLISECONDS.sleep(n);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void postProgressBar(int steps, int timeDelay) {
		for (int i = 0; i < steps; i++) {
			System.out.print("\t*");
			sleep(timeDelay);
		}
	}
	
	private static void freeUpConsole() {
		for (int i = 0; i < 15; i++) {
			System.out.print("\n");
		}
	}
	
	private static String decFmt(double d, String places) { 
		DF = new DecimalFormat(places);
		return DF.format(d);
	}
	
	private static void postStats(double difference) {
		System.out.println("\t\t\tWall height >> " + WALL.getHeight() + "m\n\t\t\tWall Distance >> " 
				+ WALL.getDistance() + "m\n\t\t\tDifference between wall and projectile >> " 
				+ decFmt(difference,"#.#") + "m\n");
	}
	
	private static void buildCatapult(double cAngle, double vel, int targetDistance) {
		CATAPULT.setAngle(cAngle);
		CATAPULT.setSpeed(vel);
		CATAPULT.setTargetDistance(targetDistance);
	}
	
	public static void startGame() {
		
		CATAPULT = new Catapult();
		
		if (DEBUG) {
			
			PLAY = false;
			System.out.println(DEBUG_PFX + "Creating an array of 100 walls.");
			Wall[] dbWallArr = new Wall[100];
			Wall[] badWalls = new Wall[100];
			int BAD_WALLS = 0;
			
			for (int i = 0; i < 100; i++) {
				dbWallArr[i]= new Wall();
				System.out.println(DEBUG_PFX + "Wall " + (i+1) + " created.");
			}
			
			freeUpConsole();
			
			for (int i = 0; i < dbWallArr.length; i++) {
				System.out.println(DEBUG_PFX + " WALL STATS {" + (i+1) + "} (DxH)> " +  dbWallArr[i].getDistance() + "x" +dbWallArr[i].getHeight() + "m");
			}
			
			System.out.print("\n" + DEBUG_PFX + "Would you like to test launch each wall?\n\t[Yy/Nn]>> ");
			
			if (s.next().equalsIgnoreCase("y")) {
				for (int i = 0; i < dbWallArr.length; i++) {
					
					System.out.println(DEBUG_PFX + "Auditing Wall [" + (i+1) + "]\t***\t***");
					boolean t = true;
					double DIFF = 100, ANGLE=0, VEL=0;
					int tmp = 0;
					
					while (t) {
						
						buildCatapult(ANGLE, VEL, dbWallArr[i].getDistance());
						
						/* --Replaced by buildCatapult(double,double,int)--
						CATAPULT.setAngle(ANGLE);
						CATAPULT.setSpeed(VEL);
						CATAPULT.setTargetDistance(dbWallArr[i].getDistance());
						*/
						
						System.out.print(DEBUG_PFX + "Wall {" + (i+1) + "} [" + dbWallArr[i].getDistance() + "x" + dbWallArr[i].getHeight() + "] | Shooting at " + decFmt(VEL,"#.##") + "m/s @" + decFmt(ANGLE, "#.##") + " DEGREES");
						
						
						DIFF = CATAPULT.calculateProjectileHeight()-dbWallArr[i].getHeight();
						System.out.print("\tDifference >> " + decFmt(DIFF,"#.###") +"m\n");
						
						ANGLE+=0.008;
						VEL  +=0.02;
						
						if (ANGLE > 90 ) {
							ANGLE = 17;
						}
						
						if (VEL > 120) {
							VEL = 12;
						}
						
						if (DIFF < 2) {
							System.out.println(DEBUG_PFX + "\n\tWall {" + i + "}, [" + dbWallArr[i].getDistance() + "x" + dbWallArr[i].getHeight() + "] Passed under 2m, [" + decFmt(VEL,"#.##") + "m/s @ " + decFmt(ANGLE,"#.##") + "degrees]\t***");
							break;
						}
						tmp++;
						
						if (tmp > 5000) {
							System.out.println(DEBUG_PFX + "\nBad wall? Couldn't get it in under 5000 tries. Moving to next. \t ***");
							badWalls[BAD_WALLS++] = dbWallArr[i];
							break;
						}
					} 
				}
				
				System.out.println(DEBUG_PFX + " Wall audit complete. " + BAD_WALLS + " 'bad' walls >> ");
				//TODO Fix badwalls
				if (BAD_WALLS > 0) {
					for (int i = 0; i < badWalls.length; i++) {
						System.out.println(DEBUG_PFX + " Bad wall with dimensions " + badWalls[i].getDistance() + " away and " + badWalls[i].getHeight() + " high.");
					} 
				} else {
					System.out.println(DEBUG_PFX + " DEBUG COMPLETE, TERMINATING.");
				}	
			}
		} 
		
		else {
			while (PLAY) { //TODO add timer
				ROUND_NUMBER++; //TODO add more comments
		
				//System.out.println("\n\tIn front of you stands a wall " + WALL.getDistance() + "m away, and " + WALL.getHeight() + "m tall.\n\n");

				System.out.print("\n[Round " + ROUND_NUMBER + " | Wall " + WALL_NUMBER +  ", Attempt " + WALL_ATTEMPTS + "] Launch Phase | Score >> " + USER_SCORE
						+" |\t[In front of you stands a wall " + WALL.getDistance() + "m away and " + WALL.getHeight() + "m tall.]\n\n\tEnter the speed (Velocity in m/s) at which you'll shoot the projectile\n\t>> ");
				double cSpeed = s.nextDouble();
				if (cSpeed == -1) {
					PLAY = false;
					break;
				}
				
				System.out.print("\tEnter the angle (in degrees) at which you wish to launch\n\t>> ");
				double cAngle = s.nextDouble();
				if (cAngle == -1) {
					break;
				} 
				
				System.out.println("\n\t{Launching the catapult at " + cSpeed + " m/s and " + cAngle + " degrees}");
				postProgressBar(7,500);
				
				buildCatapult(cAngle, cSpeed, WALL.getDistance());
				
				/* --deprecated, use buildCatapult(double,double,int)
				CATAPULT.setSpeed(cSpeed);
				CATAPULT.setAngle(cAngle);
				CATAPULT.setTargetDistance(WALL.getDistance());
				*/
				
				double difference = (CATAPULT.calculateProjectileHeight()-WALL.getHeight());
				
				USER_SCORE--; //Each shot costs a point, of course.
				
				System.out.print("\n");
				freeUpConsole();
				
				if (difference < 0) {
					System.out.println(LAUNCH_RESULT_PFX + "Ouch, you hit the wall.");
					USER_SCORE-=1;
				} else if (difference < 2) {
					System.out.println(LAUNCH_RESULT_PFX + "Incredible shot, you got it within two meters!");
					USER_SCORE+=5;
					System.out.println(LAUNCH_RESULT_PFX + "You did good on this one, let's try a new wall!");
					WALL = new Wall();
					WALL_NUMBER++;
					WALL_ATTEMPTS = 0;
				} else if (difference < 5) {
					System.out.println(LAUNCH_RESULT_PFX + "Nice shot, you got it within five meters!");
					USER_SCORE+=3;
				} else if (difference < 10) {
					System.out.println(LAUNCH_RESULT_PFX + "Not bad, you got it within ten meters!");
					USER_SCORE+=2;
				} else {
					System.out.println(LAUNCH_RESULT_PFX + "You made it, but you can do better! (You shot it with over 10m of clearance.)");
					USER_SCORE+=1;
				}
				
				postStats(difference);
				
				if (WALL_ATTEMPTS == 4) {
					System.out.println("\t\t\t*You've attempted this wall three times, time for a new one!");
					WALL = new Wall();
					WALL_NUMBER++;
					WALL_ATTEMPTS = 0;
				}
				
				sleep(5200);
				freeUpConsole();
				
				WALL_ATTEMPTS++;
			}
			
			if (!DEBUG) { // Separate to catch quitting break, redundant but avoids awkward output.
				freeUpConsole();
				System.out.print("Would you like to quit the game, or pass on this round for a new wall?\nEnter [Yy] to quit, and [Nn] for a new wall.\nChoice >> ");
			    String choice = s.next();
			    
			    if (choice.equalsIgnoreCase("n")) {
			    	PLAY = true;
			    	initializeGame();
			    	WALL_NUMBER++;
			    	freeUpConsole();
			    	startGame();
			    } else {
			    	freeUpConsole();
			    	System.out.println("Thanks for playing.");
			    }
			}	
		}
	}
	
	private static void postIntroText() {
		System.out.print("Welcome to TTY Projectiles -- the game!\nThe objective of the game is to launch a catapult such that the projectile\n"
				+ "makes it over the wall. You will gain points for making it over the wall, as well as BONUS points for making it over\n"
				+ "with minimal overshot. You will LOSE points for hitting the wall. Would you like to see the scoring rubric?\n[Yy/Nn] >> ");
	}
	
	private static void postScoringRubric() {
		System.out.println("\n[-1] Point for the cost for the launch, this will be deducted from your score.\n"
				+ "[+0] Points for hitting the wall.\n"
				+ "[+1] Point for making it over the wall for any distance.\n"
				+ "[+3] Points for making a farther clear of the wall.\n"
				+ "[+5] Points for *just* clearing the wall.\n"
				+ "[-1] Point for hitting the wall.\n");
	}
	
	public static void main(String args[]) {
		s = new Scanner(System.in);
		WALL_NUMBER = 1;
		
		initializeGame();
		postIntroText();
		
		if (s.next().equalsIgnoreCase("y")) {
			freeUpConsole();
			postScoringRubric();
			sleep(8000);
			freeUpConsole();
		} 
		
		System.out.print("\n*During the game, enter -1 for any response to promptly quit.\nWould you like to begin? [Yy/Nn] >> ");
		String c = s.next(); //Only created variable because I'd need it twice for debug mode.
		
		if (c.equalsIgnoreCase("y")) {
				freeUpConsole();
				startGame();

		} else {
			if (c.equals("!Debug")) {
				DEBUG = true;
				startGame();
			}
			else {
				System.out.println("\nIt's fine, this game isn't for everyone.");
			}	
		}
	}
}
