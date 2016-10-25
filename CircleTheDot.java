/**
 * The class <b>CircleTheDot</b> launches the game
 *
 * @author Anthony Abi Nader and Filip Slatinac, University of Ottawa
 */

public class CircleTheDot {
    
    /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If a game size (>4) is passed as parameter, it is 
     * used as the board size. Otherwise, a default value is passed
     * 
     * @param args
     *            command line parameters
     */

     public static void main(String[] args) {
        int size = 9;
        if (args.length == 1) {
            try{
                size = Integer.parseInt(args[0]);
                if(size<4){
                    System.out.println("Invalid argument, using default...");
                    size = 9;
                }
            } catch(NumberFormatException e){
                System.out.println("Invalid argument, using default...");
            }
        }
        GameController game = new GameController(size);
        StudentInfo.display();
        game.start();
    }
        /**
        * Contains a method <code>void display()</code> that all the <code>main</code> methods
        * call to display the student information. Fill the box with your personal
        * information.
        * 
        * @author Anthony Abi Nader and Filip Slatinac, University of Ottawa
        */
     
     public static class StudentInfo {
            
            /**
            * Displays the student information: student name, id, section, etc for each
            * member of the team.
            */

    	    public static void display() {

    		System.out.println("************************************************************");
    		System.out.println("*    Names:  Filip Slatinac and Anthony A. Nader           *");
    		System.out.println("*                                                          *");
    		System.out.println("*                                                          *");
    		System.out.println("*                                                          *");
    		System.out.println("************************************************************");
    		System.out.println();

    	    }

    	}


}
