/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run (){

		if (frontIsBlocked()){ 	// when just a one line column
			positionNorth();	// distributes vertically
			distributeBeepers();
		} else {
			distributeBeepers();
			
			while (leftIsClear()){
				repositionForRowToWest();
			 	if (rightIsClear()){
				repositionForRowToEast();
			}	else {
				turnAround();
				}
			}
		}
		
	}

	// lets karel face north
	private void positionNorth(){
		while (notFacingNorth()){
			turnLeft();
		}
	}
	
	// move when no wall in front
	private void moveIfClear(){
		if (frontIsClear()){
			move();
		}
	}
	
	// moves one space backwards
	private void moveBackwards(){
		turnAround();
		moveIfClear();
		turnAround();
	}
	
	// distribute Beepers in every second spot
	private void distributeBeepers(){
		while (frontIsClear()){
			move();
			putBeeper();
			moveIfClear();
		}
		moveBackwards();
	}
	
	
	// at the end of the column karel positions himself one column up
	// and starts distributing the beepers for the column.
	// It also checks if a beeper is or isn't present on the given
	// spot, so that the Checkerboard pattern is guaranteed. 
	private void repositionForRowToWest(){
			if (beepersPresent()){
				move();
				turnLeft();
				move();
				turnLeft();
				putBeeper();
				move();
				distributeBeepers();
			} else {
				move();
				turnLeft();
				move();
				turnLeft();
				distributeBeepers();
			}
		
	}
	
	// same as repositionForRowToWest - just for the Row to East! :)
	private void repositionForRowToEast(){
		 if (beepersPresent()){
			move();
			turnRight();
			move();
			turnRight();
			putBeeper();
			move();
			distributeBeepers();
		 } else {
			move();
			turnRight();
			move();
			turnRight();
			distributeBeepers();
		 }
		
	}
	
} //end class
