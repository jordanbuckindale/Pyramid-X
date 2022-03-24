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
	 * @return
	 */
	public DLStack path() {
		return null;
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
