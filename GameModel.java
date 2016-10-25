import java.util.Random;

/**
 * The class <b>GameModel</b> holds the model, the state of the systems. 
 * It stores the followiung information:
 * - the current location of the blue dot
 * - the state of all the dots on the board (available, selected or occupied by the blue dot  
 * - the size of the board
 * - the number of steps since the last reset
 *
 * The model provides all of this informations to the other classes trough appropriate Getters.
 *   
 * The controller can also update the model through Setters.
 * Finally, the model is also in charge of initializing the game
 *
 * @author Anthony Abi Nader and Filip Slatinac, University of Ottawa
 */

public class GameModel {
    /**
     * Predefined values to capture the state of a point
     */

    protected Point [][] points;
 	public static final int AVAILABLE 	= 0;
	public static final int SELECTED 	= 1;
	public static final int DOT 		= 2;
	
	protected int size;
	protected int steps = 0;
    
    /**
     * Constructor to initialize the model to a given size of board.
     * 
     * @param size
     *            the size of the board
     */

    public GameModel(int size) {
    	this.size = size;
    	playG();
    }
    
    /**
     * Resets the model to (re)start a game. The previous game (if there is one)
     * is cleared up. The blue dot is positioned as per instructions, and each 
     * dot of the board is either AVAILABLE, or SELECTED (with
     * a probability 1/INITIAL_PROBA). The number of steps is reset.
     */


    public void reset(){
    	steps = 0;
    	playG();
    	

    }

    /**
     * Getter <b>class</b> method for the size of the game
     * 
     * @return the value of the attribute sizeOfGame
     */
 
    public  int getSize(){
    	return size;
   }
    
    /**
     * returns the current status (AVAILABLE, SELECTED or DOT) of a given dot in the game
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */
  
    public int getCurrentStatus(int i, int j){
    	if (points ==null){
    		return -1;}
    	if (points[i][j].getDOT()){
    		return DOT;
    	}
    	else if(points[i][j].getSelected()){
    		return SELECTED;
    	}
    	return AVAILABLE;
    }

    /**
     * Sets the status of the dot at coordinate (i,j) to SELECTED, and 
     * increases the number of steps by one
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     */ 

    public void select(int i, int j){
    	if (points != null){
    		if (points[i][j].getDOT() || points[i][j].getSelected()){
    			
    		}
    		else{
    			points[i][j].setSelected();
    			steps++;
    		}
    	
    }
    }

    /**
     * Puts the blue dot at coordinate (i,j). Clears the previous location 
     * of the blue dot. If the i coordinate is "-1", it means that the blue 
     * dot exits the board (the player lost)
     *
     * @param i
     *            the new x coordinate of the blue dot
     * @param j
     *            the new y coordinate of the blue dot
     */ 
    
 
    public void setCurrentDot(int i, int j){
        if ( i != -1){
    	for (int t = 0; t < size; t++){
    		for (int w = 0; w < size; w++){
    			if (points[t][w].getDOT()){
    				points[t][w].reset(t,w);
    				points[t][w].setAvailable();
    			}
    		}
    	}
    	
    	points[i][j].setDOT();

   }
    }
    /**
     * Getter method for the current blue dot
     * 
     * @return the location of the curent blue dot
     */

    public Point getCurrentDot(){
    	Point tmp = null;
    	for ( int i = 0; i< size;i++){
    		for (int j = 0; j < size; j ++){
    			if (points[i][j].getDOT()){
    				return points[i][j];
    			}
    		}
    	}
    	
    	return tmp;

    }
   
    /**
     * Getter method for the current number of steps
     * 
     * @return the current number of steps
     */

  
    public int getNumberOfSteps(){
    	return steps;

    }
    /**
    * Method that creates the model for the game
    *
    *
    */
        
    private void playG(){
		Random odds = new Random();
		int chance = odds.nextInt(5);
        points = new Point[size][size];
        Point [] tmp = new Point [size];
    	
    	for (int i = 0; i < size; i++ ){
    		for(int j = 0; j< size; j++){
    			tmp[j] = new Point(i,j);
    		}
    		points[i] = tmp;
    		tmp = new Point[size];
	
    	}
    	
    	if (size%2 == 0){
    		Random random1 = new Random();
    		int blue = random1.nextInt(4);
    		
    		if (blue == 0){
    			points[size/2 -1][size/2 -1].setDOT();
    			}
    		
    		else if (blue == 1){
    			points[size/2 -1][size/2].setDOT();
    		}
    		
    		else if(blue == 2){
    			points[size/2][size/2 -1].setDOT();
    		}
    		
    		else{
    			points[size/2][size/2].setDOT();
    		}
    		
    		}
    	
    	else{
    		Random random1 = new Random();
    		int blue = random1.nextInt(9);
    		
    		if (blue == 0){
    			points[(int)size/2 -1][(int)size/2 -1].setDOT();
    		}
    		
    		else if (blue == 1){
    			points[(int)size/2 -1][(int)size/2].setDOT();

    		}
    		
    		else if (blue == 2){
    			points[(int)size/2 -1][(int)size/2 +1].setDOT();

    		}
    		else if (blue == 3){
    			points[(int)size/2][(int)size/2 -1].setDOT();

    		}
    		
    		else if (blue == 4){
    			points[(int)size/2][(int)size/2].setDOT();

    		}
    		
    		else if (blue == 5){
    			points[(int)size/2][(int)size/2 +1].setDOT();

    		}
    		
    		else if (blue == 6){
    			points[(int)size/2 +1][(int)size/2 -1].setDOT();

    		}
    		
    		else if (blue == 7){
    			points[(int)size/2 +1][(int)size/2].setDOT();

    		}
    		
    		else {
    			points[(int)size/2 +1][(int)size/2 +1].setDOT();
    		}

    	}
    	for (int i = 0; i < size; i++){
    		for ( int j = 0; j < size; j++){
    			Random cb = new Random();
    			int combo = cb.nextInt(10);
    			if (combo == chance && !(points[i][j].getDOT())){
    				points[i][j].setSelected();
    			}
    		}
    	}
    	
    	for (int i  = 0; i < size; i++){
    		for (int j = 0; j < size; j++){
    			if (!(points[i][j].getDOT() || points[i][j].getSelected())){
    				points[i][j].setAvailable();
    			}
    		}
    	}
    }

}