/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {

  // all necessary moves to get the newspaper
	// also repositioning at the and as well as dropping the newspaper
	public void run(){
		
		doubleMove();
		turnRight();
		move();
		turnLeft();
		move();
		pickBeeper();
		turnAround();
		move();
		turnRight();
		move();
		turnLeft();
		doubleMove();
		putBeeper();
		turnAround();
	}
	
	private void doubleMove(){
		move();
		move();
	}
	
} //end class
