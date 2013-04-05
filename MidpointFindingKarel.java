/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * This program lets Karel find the middle of the map
 * and places a beeper there.
 * 
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

  public void run() {
		
		firstRowBeepers();
		collectBeepers();
		runToWall();
		turnAround();
		distributeBeepers();
		runToWall();
		turnAround();
		locateMiddle();
	}
	
	
	// Karel moves until it reaches a wall.
	private void runToWall() {
		while (frontIsClear()){
			move();
		}
	}
	
	// places beepers on every second spot in the first line.
	// pre: position 1 of line one - faces east
	// post: position end of line one - faces east
	private void firstRowBeepers(){
		while (frontIsClear()){
			move();
			putBeeper();
			if (frontIsClear()){
				move();
			}
		}
		turnAround();
	}
	
	// collects the beepers who are placed in every second field.
	private void collectBeepers(){
		while (frontIsClear()){
			move();
			if (beepersPresent()){
				pickBeeper();
				turnAround();
				runToWall();
				putBeeper();
				turnAround();
			}
		}
		turnAround();
	}
	
	// puts beepers from one pile into the line until the middle is reached
	private void distributeBeepers(){
		while (beepersPresent()){
			pickBeeper();
			move();
			runToNoBeeper();
			putBeeper();
			positioning();
		}
	}
	
	// clears all the other beepers except the middle one.
	private void locateMiddle() {
		runToFirstBeeper();
		move();
		pickBeeper();
		while(frontIsClear()){
			move();
			if (beepersPresent()){
				pickBeeper();
			}
		}
	}
	
	
	// karel runs until he reaches a field without standing on a beeper
	public void runToNoBeeper(){
		while (beepersPresent()){
			move();
		}
	}
	
	// karel runs until he reaches the first beeper on line.
	public void runToFirstBeeper(){
		while (noBeepersPresent()){
			move();
		}
	}
	
	// pre: karel faces west at any location
	// post: karel faces west at the end of the map
	public void positioning() {
		turnAround();
		runToWall();
		turnAround();
	}
	
	
}//public class end
