import java.awt.*;
import javax.swing.*;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out an instance of  <b>BoardView</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Anthony Abi Nader and Filip Slatinac, University of Ottawa
 */

public class GameView  extends JFrame{
	GameModel model;
	private BoardView bv;
	GameController gc;

	 /**
     * Constructor used for initializing the Frame
     * 
     * @param model
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */


	
      public GameView ( GameModel model, GameController gameController){
    	  
    	super("Dot!");
		this.model = model;
		gc = gameController;
		bv = new BoardView(model,gameController);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		JButton quit = new JButton("Quit");
		JButton reset = new JButton ("reset");
		
		quit.addActionListener(gameController);
		reset.addActionListener(gameController);
		
		quit.setActionCommand("quit");
		reset.setActionCommand("reset");

		
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout());
		
		bottom.add(reset);
		bottom.add(quit);
		
		
		add(bottom,BorderLayout.SOUTH);
		add(bv,BorderLayout.CENTER);
		pack();
		setVisible(true);
		

      }
      
     /**
     * Getter method for the attribute board.
     * 
     * @return a reference to the BoardView instance
     */

      public BoardView getBoardView(){
    		  return bv;
      }
      
      
}
