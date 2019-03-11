package soen331adbc;

public interface PriorityQueue<T> {


	//Inserts the pair (el ; key) into the priority queue.
	public void insert(T e, int key);
	
	//Removes and returns the element with the smallest key.
	public T remove();
	
	// Returns but does not remove the element with the smallest key.
	public T min();


}
