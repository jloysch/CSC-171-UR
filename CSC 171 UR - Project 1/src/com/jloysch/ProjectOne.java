package com.jloysch;

import java.util.Scanner;

public class ProjectOne {
	
	private static int USER_SCORE, ROUND_NUMBER;
	private static boolean PLAY = true;
	
	/*
	 * In this game, the user has a
	catapult that can launch projectiles. In each round of the game, the computer places a wall
	in front of the user. The user aims their catapult by setting the launch angle and speed. The
	computer then computes whether the projectile makes it over the wall and informs the user.
	The user gets points for clearing the wall and loses points for hitting the wall. The game
	continues through successive rounds until the user quits.
	 */
	
	
	private static void startGame() {
		
	}
	
	private static void postIntroText() {
		System.out.print("Welcome to TTY Projectiles -- the game!\nThe objective of the game is to launch a catapult such that the projectile\n"
				+ "makes it over the wall. You will gain points for making it over the wall, as well as BONUS points for making it over\n"
				+ "with minimal overshot. You will LOSE points for hitting the wall. Would you like to see the scoring rubric?\n[Yy/Nn] >> ");
	}
	
	private static void postScoringRubric() {
		System.out.println("\n[-1] Point for the cost for the launch, this will be deducted from your score.\n"
				+ "[+1] Point for making it over the wall for any distance.\n"
				+ "[+3] Points for making a farther clear of the wall.\n"
				+ "[+5] Points for *just* clearing the wall.\n"
				+ "[-1] Points for hitting the wall.\n");
		
		/*
		 * Your program must keep track of the user’s score. Each launch costs 1 point. A close
clear gets 5 points (so +4 net). A far clear gets +2 net. A near miss loses 1 point net
and a far miss loses 3 points net. Your program must inform the user of their score
after each launch and at the end of each round. You may adjust these scoring rules—
document any changes in your code and in your
		 */
	}
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		ROUND_NUMBER = 1;
		USER_SCORE = 0;
		
		//postIntroText();
		Wall w = new Wall();
		Catapult c = new Catapult();
		
		//w.regenerate();
		
		w.setHeight(25);
		w.setDistance(10);
		
		System.out.print("You'll now launch.\nEnter the speed at which you'll shoot the projectile\n>> ");
		double cSpeed = 10;
		System.out.print("\nEnter the angle at which you wish to launch\n>> ");
		double cAngle = 53;
		
		c.setSpeed(cSpeed);
		c.setAngle(cAngle);
		c.setHeight(w.getHeight());
		c.setTargetDistance(w.getDistance());
		
		System.out.println("Current wall height >> " + w.getHeight() + "\nCurrent wall distance >> " + w.getDistance() +"\n");
		System.out.println("Projectile  Max height = " + c.calculateProjectileHeight()+"\n\n");
		//System.out.println("Projectile coincides with wall at " + c.calculateProjectileHeight());
		
		/*
		if (s.next().equalsIgnoreCase("y")) {
			postScoringRubric();
		} 
		
		System.out.print("Would you like to begin? [Yy/Nn] >> ");
		
		if (s.next().equalsIgnoreCase("y")) {
			while (PLAY) {	
				startGame();
				ROUND_NUMBER++;
			}
		} else {
			System.out.println("\nIt's fine, this game isn't for everyone.");
		}
		*/	
	}

}
