package MontyHallSimulation;

import java.util.ArrayList;

/**
 * 
 * @author Kathryn Newbould
 * @Version 1.0
 * 
 * DoorsMain is the showfloor class, containing an array list of door classes
 * and then manipulating them through the whole show
 */
public class DoorsMain {
	
	static ArrayList<door> showfloor = new ArrayList<door>();
	static double carUnchangedGuess = 0;
	static int numberUnchangedGuess = 0;
	static double carChangedGuess = 0;

	/** populateShow() fills the ArrayList up to the desired number of instances of door
	 *  more instances = more reliable statistics
	 * @param n  - indicates the number of times you wish to run the show
	 */
	
	private static void populateShow(long n){
		showfloor.clear();
		System.out.println("The show has begun! ");
		for(int i = 0; i<n; i++){
			showfloor.add(new door());
		}
	}
	
	/*showTime goes through the array list, and for each door object goes through every aspect of the show
	 * opening a 'goat' door, then telling us the result for an unchanged, then a changed guess
	 * these are tallied up until the ratio for change or stick is printed
	 * @param n - indicates the number of times you wish to run through the show, passed to populateShow()
	 */
	public static void showTime(long n){
		populateShow(n);
		for(door door1 : showfloor){
			door1.openDoor();
			numberUnchangedGuess ++;
			carUnchangedGuess += door1.playerChoice();
			carChangedGuess +=door1.playerChoiceChange();
		}
		System.out.println("The success rate for an unchanged test is: " + 100*carUnchangedGuess/numberUnchangedGuess + "%.");
		System.out.println("The success rate for a changed guess is : " + 100*carChangedGuess / numberUnchangedGuess + "%.");
	}
	
	
	public static void main(String[] args){
		DoorsMain.showTime(100000);
	}

}
