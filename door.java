package MontyHallSimulation;

/* @ Author  Kathryn Newbould
 * @Version 1.0
 * 
 * class door is an array of 3 strings, one of which is "Car", the other two "Goat"
 * the position of the car and the player choice is randomly assigned every time a call to the constructor is made. 
 */

public class door {
	
//	@ToDo change from String[] to separate class DoorInstance, for easier GUI adaptation
	String[] doors = new String[3];
	private int positionCar; 
	private int playerChoice; 
	private int openDoor;
	/** door() constructs the player choice and position of car randomly, then fills the array of doors
	 */
	door(){
		positionCar = (int) (3*Math.random());
		playerChoice = (int) (3*Math.random());
		for(int o=0; o<3; o++){
			if(o == positionCar){
				doors[o] = "Car";
			}
			else{
				doors[o] = "Goat";
			}
		}

	}
/** class openDoor() chooses a door which is not the one of player choice nor the one with a car, and opens it 
 *  (to reveal a goat!)
 */
	public void openDoor(){
		openDoor = (int)(3*Math.random());
		while(openDoor==playerChoice || openDoor == positionCar){	
			openDoor = (int)(3*Math.random());
		}
	}
	
	/**method playerChoice checks whether the player wins a car!
	 * if the player does not change choice, this method is called immediately 
	 * @return 1 if the player gets a car, 0 otherwise
	 */
	public int playerChoice(){
		if(playerChoice==positionCar){
			return 1;
		}
		return 0;
	}
	/**
	 * playerChoiceChange changes the player guess to the other unopened door
	 * it then recursively calls playerChoice()
	 * @return 1 if the player receives a car, 0 otherwise
	 */
	public int playerChoiceChange(){
		int currentChoice = playerChoice;
		while(playerChoice == openDoor || playerChoice ==currentChoice){
			playerChoice = (int) (3* Math.random());
		}

		return playerChoice();
	}
	
	
}
