import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class contains the code needed to compute a path from the entrance of the pyramid to all the treasure chambers.
 * @author Jordan Buckindale
 * @Student #251246279
 * @Date March 22th 2022
 */

public class FindPath {

	/**
	 * This is a private variable that is a reference to an object of the provided class Map that represents the chambers of the pyramid.
	 */
	private Map pyramidMap;
	
	
	/**
	 * This is the constructor for the class. It receives as input the name of a file containing a description of the chambers of the pyramid.
	 * @param fileName is the input file.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws InvalidMapCharacterException 
	 */
	public FindPath(String fileName) {
	
		// try to open parameter file.
		try {
			
			// assign provided map to pyramid map variable.
			this.pyramidMap = new Map(fileName); 
		}
		// catch expections that occur while trying to open file.
		catch (Exception e){
			// present message from given files.
			e.getMessage();
		}
		
	}
	
	/**
	 *  This method finds a path from the entrance to all the treasure chambers that can be reached by satisfying the constraints specified in the introduction.
	 *  @return
	 */
	public DLStack<Chamber> path() { //refer comments at bottom of file
		
		// delcare stack for potential chambers of path.
		DLStack<Chamber> chamberStack;
		// create empty stack for chambers.
		chamberStack = new DLStack<Chamber>();
		
		// get the starting chambers and number of treasures.
		
		// variable for starting chamber.
		Chamber enterance = pyramidMap.getEntrance();
		// variable for number of treasures.
		int numTreasures = pyramidMap.getNumTreasures();
		// creates a variable for treasures found by program.
		int numTreasuresFound = 0;
		
		// put enterance in stack and begin.
		chamberStack.push(enterance);
		// once enterance chamber is pushed, mark as pushed.
		enterance.markPushed();
		
		// while stack is NOT EMPTY.
		while (!chamberStack.isEmpty()) {
			
			// peak top stack to get current chamber.
			Chamber current = chamberStack.peek();
			
			// check if treasure chamber and if all treasures are found, exit while loop.
			if (current.isTreasure() && numTreasures == numTreasuresFound) {
				
				// exits while loop.
				break;
			}
			// use bestChamber method to get best neighbouring chamber.
			else {
				
				// initialize next chamber.
				Chamber nextChamber;
				// use bestChamber method to get best chamber.
				nextChamber = current.bestChamber();
				
				// if next chamber is NOT NULL, push into stack and mark and pushed, otherwise pop and mark popped.
				if (!(nextChamber == null)) {
					
					// push into stack.
					chamberStack.push(nextChamber);
					// mark chamber as pushed.
					nextChamber.markPushed();
					
					// check to see if next chamber was treasure.
					if (nextChamber.isTreasure()) {
						
						// increment treasures found if current chamber contains treasure.
						numTreasuresFound ++;
					}
				}
				// pop last chamber and mark as popped. (dead end)
				else {
					
					// pop out the last chamber of stack.
					Chamber last = chamberStack.pop();
					// mark last chamber of stack as popped.
					last.markPopped();
				}
				
			}
				
		}
		
		// return stack.
		return chamberStack;
	}
	
	
	/**
	 * Returns the value of pyramidMap.
	 * @return map.
	 */
	public Map getMap() {
		
		// returns the value of pyramid map.
		return pyramidMap;
	}
	
	
	/**
	 * Returns true if currentChamber is dim, returns false otherwise; currentChamber is dim if it is not null, it is not sealed, it is not lighted and one of its neighboring chambers is lighted.
	 * @param currentChamber is the cureent chamber.
	 * @return true if current chamber is dim, return false otherwise.
	 */
	public boolean isDim (Chamber currentChamber) {
		return false;
	
	}
	
	
	/**
	 * Selects the best chamber to move to from currentChamber according to restrictions.
	 * @param currentChamber
	 */
	public void bestChamber (Chamber currentChamber) {
		
	}
	
	
	
}

/* FINDPATH ALGORITHM
 * 
 * 1. Get empty stack
 * 2. Get the starting chamber and number of treasures
 * 3. Push chamber into stack, mark chamber as pushed
 * 4. While stack is NOT EMPTY:
 * 		- peak top stack to get the current chamber
 * 		- check if the treasure chamber, and if it is equal to treasure exit while loop
 * 		- use FindPath class and bestChamber method to get best neighbouring chamber
 * 		- if c is not null push in stack and mark as pushed, otherwise Pop and mark Popped
 * 5. After while loop, return stack
 * 
 */
