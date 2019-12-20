	/*
	 * As you work on these problems, remember the basic structure of a graphical animation app
	as seen in class (sample code posted):
	• Main class extends JFrame sets up the UI in its constructor; main method creates
	instance and makes it visible
	• Inner class extends JComponent used for drawing; instance stored in main class
	instance variable and added to frame layout
	• javax.swing.Timer instance connected to event listener and started (usually done
	in JFrame constructor)
	• Inner classes for event handlers (timer and UI controls): update state and request
	repaint of the canvas
	Other arrangements are also possible, of course, but this is a good starting point.
	Workshop Problems
	
	1. Create an application that allows a user to direct a “robot” around its window. Start
	with the robot (some shape or icon) at the center of the window. The user can enter X
	and Y coordinates and then press a “Go” button to send the robot to that location. Your
	application should animate the robot’s move to the new location. If you like, allow the
	user to set the speed of the robot also, and use that in the animation.
	
	2. Create an application that allows a user to direct a “robot” around its window using
	a joystick-style GUI. That is, there are buttons arranged in a north-south-east-west
	pattern. Pressing the button starts the robot moving in that direction. Pressing the
	center button (or something) stops the robot. You could also use keyboard input (e.g.,
	arrow keys and spacebar) as alternate controls.
	
	3. Create an application that displays a triangle in the center of the screen. The user
	should be able to rotate the triangle using either the mouse or the keyboard or both.
	
	4. Extend the rotating triangle application so that the user can fire a shot from the apex
	of the triangle. The projectile should be drawn leaving from the triangle in the appropriate direction (depends on the rotation) 
	and traveling to the edge of the screen. You
	can assume simple linear motion (no gravity, etc.). Congratulations: you’re more than
	halfway to writing Asteroids.

	5. Animation isn’t just about moving things around. All that has to happen is that something has to change through time. 
	Content, color, line and shape styles, transparency
	(think fading one image into another), text overlays, etc. Think of an interesting type of
	animation and describe how you would implement it. If you need a practical application,
	maybe these could be part of a screensaver.
	 */
public class Main {
	
	public static void main(String args[]) {
		
	}

}
