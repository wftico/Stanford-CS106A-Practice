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

  public void run() {
		
		while (frontIsClear()){
		firstRow();
		moveUpwardsRight();
		firstRow();
		moveUpwardsLeft();
		}
	}
	
	// puts beepers in the first column
	private void firstRow(){
		while (frontIsClear()){
			move();
			putBeeper();
			if (frontIsClear()){
				move();
			}
		}
	}
	
	// used to move one column up if karel is positioned on the right hand side
	private void moveUpwardsRight(){
		turnLeft();
		if (frontIsClear()){
		move();
		turnLeft();
		}
	}
	
	// used to move one column up of karel is positioned on the left hand side
	private void moveUpwardsLeft(){
		turnRight();
		if (frontIsClear()){
		move();
		turnRight();
		}
	}

} // end class
