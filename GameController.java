import java.awt.List;
import java.awt.event.*;
import java.util.*;

import javax.swing.JOptionPane;

/**
 * The class <b>GameController</b> is the controller of the game. It implements 
 * the interface ActionListener to be called back when the player makes a move. It computes
 * the next step of the game, and then updates model and view.
 *
 * @author Anthony Abi Nader and Filip Slatinac, University of Ottawa
 */


public class GameController implements ActionListener {
	int size;
	GameModel gm;
	GameView gv;
	Point [] pos;
	int steps = 0;
	ArrayList <Point> blocked = new ArrayList<Point>();
    
    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param size
     *            the size of the board on which the game will be played
     */    

    public GameController(int size) {
    	this.size = size;
        pos = new Point [6];
        
        pos[0] = new Point(0,1);                   
        pos[1] = new Point(0,-1);
        pos[2] = new Point(1,1);
        pos[3] = new Point(1,0);
        pos[4] = new Point(-1,1);
        pos[5] = new Point(-1,0);                                                 
    }

    /**
    * Starts the game
    */


    public void start(){
    	gm = new GameModel(size);
    	gv = new GameView(gm,this);
    	
    }

    /**
    * Resets the game
    */

    public void reset(){
    	gm .reset();
    	gv.getBoardView().update();
    	steps = 0;
    }
    
    /**
    * Mehtod that simulates the possible paths and finds a shortest path
    *
    * @param beg
    *           Starting Point
    *
    * @return q if theres a path else, null
    */  

    private ArrayList<Point> BlueMove(Point beg){
    	
    	 blocked = new ArrayList<Point>();
    	 
    	 
    	 MQueu <ArrayList<Point>> queu = new MQueu <ArrayList<Point>>();
    	 
    	 ArrayList <Point> tmp = new ArrayList <Point> ();
    	 
    	 ArrayList<Point> L = new ArrayList <Point> ();
    	 
         
         tmp.add(beg);
         
    	 queu.enqueu(tmp);
    	 
    	 tmp = new ArrayList <Point> ();
    	 
    	 ArrayList<Point> q;

    	 while (!queu.isEmpty()){
    		 q = new ArrayList<Point>();
    		 
    		 q = queu.dequeu();
    		 
    		 Point c = q.get(q.size() -1);
    		 L.add(c);
   		 
    		
     		 
    	   for (int i = 0; i < pos.length; i++){
    		   
   			int z = c.x;
   			
	  		  if ((z % 2 == 0)){ 
	    	        pos[0] = new Point(0,1);                   
	    	        pos[1] = new Point(0,-1);
	    	        pos[2] = new Point(1,0);
	    	        pos[3] = new Point(1,-1);
	    	        pos[4] = new Point(-1,0);
	    	        pos[5] = new Point(-1,-1);} 
	  		  
	  		  else{
	  	           pos[0] = new Point(0,1);                   
	  	           pos[1] = new Point(0,-1);
	  	           pos[2] = new Point(1,1);
	  	           pos[3] = new Point(1,0);
	  	           pos[4] = new Point(-1,1);
	  	           pos[5] = new Point(-1,0);    
	  		  }
	  		  
	   			int x = pos[i].x + c.x;
	   			int y = pos[i].y + c.y;
   			
    		if ( checkPath(x,y)){	  
    	       if (reachesPath(x,y)){
    	       q.add(new Point (x,y));
    	       return q;}
    	       else{
    	    	   tmp.addAll(q);
    	    	   tmp.add(new Point(x,y));
    	    	   queu.enqueu(tmp);
    	           blocked.add(new Point(x,y));
    	    	   tmp = new ArrayList <Point> ();

    	       }
    	     }
    	   }
    	 }
    	 return null;
    	}
    
    /**
    * Method that checks if a path is valid
    *
    * @param x
    *           int x coordinate of the point to be checked
    * 
    * @param y
    *
    *           int y coordinate of the point to be checked
    *
    * @return boolean
    */

    private boolean checkPath(int x , int y){

    	
    	boolean yellowOrno = true;
    	
    	for (int i =0; i < gm.points.length; i++){
    		for (int j =0; j < gm.points.length; j++){
    			
    		if (gm.points[i][j].x == x && gm.points[i][j].y == y){
    			if (!gm.points[i][j].getAvailble()){
    				yellowOrno = false;
    			}
    		}
    		}
    	}
    	
    	for (int i = 0; i < blocked.size();i++){
    		if (blocked.get(i).x == x && blocked.get(i).y == y){
    			yellowOrno = false;
    		}
    	}
    	
    	
    	return yellowOrno;
    }
        
    /**
    * Method that checks if the next point is a winning point
    *
    * @param x
    *           int x coordinate of the point to be checked
    * 
    * @param y
    *
    *           int y coordinate of the point to be checked
    *
    * @return boolean
    */

    private boolean reachesPath(int x , int y){
    	if ( y == size -1 || x == 0 || y == 0 || x == size -1){
    		return true;
    	}

    return false;
    }
    
    /**
     * Callback used when the user clicks a button or one of the dots. 
     * Implements the logic of the game
     *
     * @param e
     *            the ActionEvent
     */
    
     public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "quit"){
        	System.exit(0);
        }
        else if (e.getActionCommand() == "reset"){
        	reset();
        }
        
        else{
        	DotButton db = (DotButton) e.getSource();
        	steps++;
        	
        	int r = db.getRow();
        	int c = db.getColumn();
        	
        	gm.select(r,c);
        	gv.getBoardView().update();
        	
        	BRPath point = new BRPath(gm,size,gm.getCurrentDot());   //Created a class that does the same thing but also implements the selection of  random shortest path 
        	Point tmp = point.GetBest();
        	
        	/*ArrayList <Point> tmpA = BlueMove(gm.getCurrentDot());*/
        	
        	if (tmp/*A*/ != null){
        		
           /* Point tmp = tmpA.get(1);*/
            

        	gm.setCurrentDot(tmp.x, tmp.y);
        	gv.getBoardView().update();
        	if (tmp.y == size -1 || tmp.y == 0 || tmp.x == 0 || tmp.x == size - 1){
        		gm.points[gm.getCurrentDot().x][gm.getCurrentDot().y].DOT = false;
        		gv.getBoardView().update();
        	    String[] options = new String[] {"Quit", "New Game",};
        	    int response = JOptionPane.showOptionDialog(null,"You lost. Would you like to play again?", "Lost",
        	        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null
        	        , options, options[0]);
        	    
        	    if (response == 0){
        	    	System.exit(0);
        	    }
        	    else{
        	    	reset();
        	    }
        	}
        	}
        	else{
        	    String[] options = new String[] {"Quit", "New Game",};
        	    int response = JOptionPane.showOptionDialog(null,"You won in " + steps + " steps. Would you like to play again ?", "Won",
        	        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null
        	        , options, options[0]);
        	    
        	    if (response == 0){
        	    	System.exit(0);
        	    }
        	    else{
        	    	reset();
        	    }
        	}
        }
        }

    }

 
