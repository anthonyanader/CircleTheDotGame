
import javax.swing.*;
import java.awt.*;

/**
 * In the application <b>Circle the dot</b>, a <b>DotButton</b> is a specialized type of
 * <b>JButton</b> that represents a dot in the game. It uses different icons to
 * visually reflect its state: a blue icon if the blue dot is currently on this location
 * an orange icon is the dot has been selected and a grey icon otherwise.
 * 
 * The icon images are stored in a subdirectory ``data''. They are:
 * data/ball-0.png => grey icon
 * data/ball-1.png => orange icon
 * data/ball-2.png => blue icon
 *
 * @author Anthony Abi Nader and Filip Slatinac, University of Ottawa
 */

public  class DotButton extends JButton {
	int row;
	int column;
	int type;
	
	ImageIcon image;
    
    /**
     * Constructor used for initializing a cell of a specified type.
     * 
     * @param row
     *            the row of this Cell
     * @param column
     *            the column of this Cell
     * @param type
     *            specifies the type of this cell
     */


    public DotButton(int row, int column, int type) {
    	this.row = row;
    	this.column = column;
    	this.type = type; 
    	
    	if (type == 0){
    		image = new ImageIcon("DATA/ball-0.png");
    		setIcon(image);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setContentAreaFilled(false);
    	
    	}
    	else if(type == 1){
    		image = new ImageIcon("DATA/ball-1.png");
    		setIcon(image);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setContentAreaFilled(false);
    		setEnabled(false);
    		setDisabledIcon(image);
    	}
    	else if(type == 2){
    		image = new ImageIcon("DATA/ball-2.png");
    		setIcon(image);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setContentAreaFilled(false);
    		setEnabled(false);
    		setDisabledIcon(image);

    	}

    }

    /**
     * Changes the cell type of this cell. The image is updated accordingly.
     * 
     * @param type
     *            the type to set
     */

	public void setType(int type) {
    	this.type = type;
    	
    	if (type == 0){
    		image = new ImageIcon("DATA/ball-0.png");
    		setIcon(image);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setContentAreaFilled(false);
    	
    	}
    	else if(type == 1){
    		image = new ImageIcon("DATA/ball-1.png");
    		setIcon(image);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setContentAreaFilled(false);
    		setEnabled(false);
    		setDisabledIcon(image);

    	}
    	else if(type == 2){
    		image = new ImageIcon("DATA/ball-2.png");
    		setIcon(image);
    		setBorderPainted(false);
    		setFocusPainted(false);
    		setContentAreaFilled(false);
    		setEnabled(false);
    		setDisabledIcon(image);

    	}
    	
    }

    /**
     * Getter method for the attribute row.
     * 
     * @return the value of the attribute row
     */

    public int getRow() {
    	return row;
    }

    /**
     * Getter method for the attribute column.
     * 
     * @return the value of the attribute column
     */
    
    public int getColumn() {
    	return column;
    }
    

}