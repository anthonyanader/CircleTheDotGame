import javax.swing.*;
import java.awt.*;

/**
 * The class <b>BoardView</b> provides the current view of the board. It extends
 * <b>JPanel</b> and lays out a two dimensional array of <b>DotButton</b> instances.
 *
 * @author Anthony Abi Nader and Filip Slatinac, University of Ottawa
 */

public class BoardView  extends JPanel{ 

       private DotButton [][] buttons;
       int status;
       GameModel gm;
       int size;
       JPanel [] panels;
       GameController gc;
    
    /**
     * Constructor used for initializing the board. The action listener for
     * the board's DotButton is the game controller
     * 
     * @param gameModel
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

         public BoardView(GameModel gameModel ,GameController gameController) {
        	 gc = gameController;
        	 gm = gameModel;
        	 runBV();
        	 
        	 
        	 
         }
        /**
        * Update the status of the board's DotButton instances based on the current game model
         */

         public void update(){
        	 removeAll();
        	 runBV();
        	 revalidate();
        	 repaint();
        	 
         }
         
        /**
         * Creates a boardView upon calling
         *
         *
         */

         protected void runBV(){
        	 buttons = new DotButton[gm.getSize()][gm.getSize()];
        	 size = gm.getSize();
        	 panels = new JPanel [size];
        	 setLayout(new GridLayout(size,0));


        	 for (int i = 0; i < gm.getSize(); i++){
        		 for (int j = 0; j < gm.getSize();j++){
        			status = gm.getCurrentStatus(i,j);
        			
        			DotButton bu = new DotButton(i,j,status);
        			bu.addActionListener(gc);
        			buttons[i][j] = bu;
        		 }
        	 }
        	 
        	 for (int i = 0; i < size; i++){
    			 JPanel tmp = new JPanel();
    			 tmp.setLayout( new GridLayout(0,size));
    			 tmp.setPreferredSize(new Dimension(44 * size, 40));

    			 if (i % 2 != 0){
    			    tmp.setBorder(BorderFactory.createEmptyBorder(0,20, 0, 0));


    			 }
    			 
    			 else if (i % 2 == 0){
     			    tmp.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 20));

    			 }
        		 for (int j = 0; j < size; j++){
        			 tmp.add(buttons[i][j]);
        		 }
        		 panels[i] = tmp;
        	 }
        	 
        	 for (int i =0; i < size; i++){
        		 add(panels[i]);
        	 }
        	 setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        	 setVisible(true);
         }

}
