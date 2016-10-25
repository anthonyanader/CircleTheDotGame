import java.util.LinkedList;

/**
 * The class <b>MQueu</b> is implemented using LinkedLists, to avoid confusion in the GameController Class
 *
 * @author Anthony Abi Nader and Filip Slatinac, University of Ottawa
 */ 

public class MQueu<E> {
	LinkedList<E> MList;
	
	/**
	* Constructor of the queue using LinkedList
	*
	*/	

	public MQueu(){
		MList = new LinkedList<E>();
		
	}
	/**
	* Method that enqueus the paramater to the back of the queue using addLast method from LinkedList
	*
	* @param add
	*				adds item to the back of the queue
	*/

	public void enqueu(E add){
		MList.addLast(add);
	}
	/**
	* Method that dequeus the front of the queue using mList method from LinkedList
	*
	* @return MList.poll
	* 
	*/

	public E dequeu(){
		return MList.poll();
	}
	/**
	* Method that checks if queue is empty
	*
	* @return MList.empty
	*/
	
	public boolean isEmpty(){
		return MList.isEmpty();
	}
}
