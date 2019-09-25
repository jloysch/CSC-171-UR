package com.jloysch;

import java.util.Scanner;

public class ProjectOne {
	
	private static int USER_SCORE, ROUND_NUMBER;
	private static String LAUNCH_RESULT_TAG = "\t[Launch Result] >> ";
	private static Scanner s;
	static Wall WALL;
	static Catapult CATAPULT;
	private static boolean PLAY = true;
	
	private static void startGame() {
		while (PLAY) {
			ROUND_NUMBER++;
			
			
			WALL = new Wall();
			CATAPULT = new Catapult();
			
			//System.out.println("\n\tIn front of you stands a wall " + WALL.getDistance() + "m away, and " + WALL.getHeight() + "m tall.\n\n");
			
			System.out.print("\n[Round " + ROUND_NUMBER + "] " + "Launch Phase | Score >> " + USER_SCORE
					+" |\n** In front of you stands a wall " + WALL.getDistance() + "m away and " + WALL.getHeight() + "m tall. **\nEnter the speed at which you'll shoot the projectile\n>> ");
			double cSpeed = s.nextDouble();
			if (cSpeed == -1) {
				PLAY = false;
				break;
			}
			
			System.out.print("\nEnter the angle at which you wish to launch\n>> ");
			double cAngle = s.nextDouble();
			if (cAngle == -1) {
				break;
			}
			CATAPULT.setSpeed(cSpeed);
			CATAPULT.setAngle(cAngle);
			CATAPULT.setHeight(WALL.getHeight());
			CATAPULT.setTargetDistance(WALL.getDistance());
			
			double result = CATAPULT.calculateProjectileHeight();
			double difference = (result-WALL.getHeight());
			
			USER_SCORE--; //Each shot costs a point
			
			System.out.print("\n");
			
			if (difference < 0) {
				System.out.println(LAUNCH_RESULT_TAG + "Ouch, you *just* hit the wall.");
				//Don't add any points
			} else if (difference < 2) {
				System.out.println(LAUNCH_RESULT_TAG + "Incredible shot, you got it within two meters!");
				USER_SCORE+=5;
			} else if (difference < 5) {
				System.out.println(LAUNCH_RESULT_TAG + "Nice shot, you got it within five meters!");
				USER_SCORE+=3;
			} else if (difference < 10) {
				System.out.println(LAUNCH_RESULT_TAG + "Not bad, you got it within ten meters!");
				USER_SCORE+=2;
			} else {
				System.out.println(LAUNCH_RESULT_TAG + "You made it, but you can do better! (You shot it with over 10m of clearance.)");
				USER_SCORE+=2;
			}
			
		}
		
		System.out.println("Thanks for playing!");
	}
	
	private static void postIntroText() {
		System.out.print("Welcome to TTY Projectiles -- the game!\nThe objective of the game is to launch a catapult such that the projectile\n"
				+ "makes it over the wall. You will gain points for making it over the wall, as well as BONUS points for making it over\n"
				+ "with minimal overshot. You will LOSE points for hitting the wall. Would you like to see the scoring rubric?\n[Yy/Nn] >> ");
	}
	
	private static void postScoringRubric() {
		System.out.println("\n[-1] Point for the cost for the launch, this will be deducted from your score.\n"
				+ "[+0] Points for hitting the wall."
				+ "[+1] Point for making it over the wall for any distance.\n"
				+ "[+3] Points for making a farther clear of the wall.\n"
				+ "[+5] Points for *just* clearing the wall.\n"
				+ "[-1] Point for hitting the wall.\n");
		
		/*
		 * Your program must keep track of the user’s score. Each launch costs 1 point. A close
clear gets 5 points (so +4 net). A far clear gets +2 net. A near miss loses 1 point net
and a far miss loses 3 points net. Your program must inform the user of their score
after each launch and at the end of each round. You may adjust these scoring rules—
document any changes in your code and in your
		 */
	}
	
	public static void main(String args[]) {
		s = new Scanner(System.in);
		ROUND_NUMBER = 0;
		USER_SCORE = 0;
		
		postIntroText();
		
		if (s.next().equalsIgnoreCase("y")) {
			postScoringRubric();
		} 
		
		System.out.print("\nDuring the game, enter -1 for any response to promptly quit.\nWould you like to begin? [Yy/Nn] >> ");
		
		if (s.next().equalsIgnoreCase("y")) {
	

				startGame();

		} else {
			System.out.println("\nIt's fine, this game isn't for everyone.");
		}
	}

}
