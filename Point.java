/**
 * The class <b>Point</b> is a simple helper class that stares a 2 dimentional element on a grid
 *
 * @author Anthony Abi Nader and Filip Slatinac, University of Ottawa
 */
class Point {
	 int x;
	 int y;
	 
	protected boolean selected;
	protected boolean DOT;
	protected boolean available;
	 
    /**
     * Constructor 
     * 
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     */


    public Point(int x, int y){
    	this.x = x;
    	this.y = y;
    	
    	selected = false;
    	DOT = false;
    	available = false;
    }
    
    /**
     * Getter method for the attribute x.
     * 
     * @return the value of the attribute x
     */

    public int getX(){ 
    	return this.x;
    }
    /**
     * Getter method for the attribute y.
     * 
     * @return the value of the attribute y
     */    

    public int getY(){
    	return this.y;
    }

    /**
     * Setter for x and y.
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     */

    public void reset(int x, int y){
    	this.x = x;
    	this.y = y;
    	
    	selected = false;
    	DOT = false;
    	available = false;
    }
    
    /**
    * Setter that sets the Point instance as selected
    *
    *
    */   
    
    protected void setSelected(){
    	this.selected = true;
    	this.available = false;
    	
    }
    /**
    * Seter that sets the Point as the blue dot
    *
    */

    protected void setDOT(){
    	this.DOT = true;
    	this.available = false;
    }
    /**
    * Setter that sets the Point as available
    *
    *
    */

    protected void setAvailable(){
    	this.available = true;
    }

    /**
    * Getter that return if the Point instance is selected
    *
    * @return selected
    *
    */    

    protected boolean getSelected(){
    	return this.selected;
    	
    }
    /**
    * Getter that gets the position of the blue dot
    *
    *
    * @return DOT
    *
    */

    protected boolean getDOT(){
    	return this.DOT;
    }
    /**
    *
    * Getter that return if a Point instance is available
    *
    *
    *
    * @return Available
    *
    */

    protected boolean getAvailble(){
    	return this.available;
    }
    /**
    * Overwritten equals method 
    *
    * @param other
    *               Point
    *
    * @return ST
    *
    */
    
    protected boolean isEqual(Point other){
    	 boolean ST = true;
    	 if (!(this.x == other.x && this.y == other.y)){
    		 ST = false;
    	 }
    	 
    	 return ST;
     }

 }