//Reference:http://www.algolist.net/Data_structures/Binary_heap/Remove_minimum
package soen331adbc;

import java.util.ArrayList;


public class BoundedPriorityQueue <T> implements PriorityQueue<T> {
	
	//1) Shape Property: A binary heap is a complete binary tree, this means all of the levels of the tree are completely filled except possibly the last level. The nodes are filled from left to right.
	//2) Heap Property: The value stored in each node is either (greater than or equal to) OR (less than or equal to ) it¡¯s children depending if it is a max heap or a min heap.
	//3) Using Williams Method of building a heap
	
	public ArrayList<boundedObject>collection;
	int capacity;
	int top;
	
	public BoundedPriorityQueue (int capacity) {
		this.capacity = capacity;
		this.collection = new ArrayList<boundedObject>(capacity);
		this.top = -1;
		}
	
	
	
	/*	
	   if heap is empty, 
			place item at root; 
		
		else, 
			place item at bottom of heap; 
			while (child > parent) 
			swap(parent, child); 
	 */
	@Override
	public void insert(T t, int key) {
		if(top ==-1) {
			collection.add(new boundedObject(t,key));
			top++;
		}
		else{
			collection.add(new boundedObject(t,key));
			top++;
			swapInsert(top);							
		}
	}

	
	
	//Removes and returns the element with the smallest key.
	@Override
	public T remove() {
		if(collection.isEmpty()) {
			System.out.println("Heap is empty");
			return null;
		}
		else 
		{
		T tempT = (T) collection.get(0).getT();
		System.out.println("before move size: "+collection.size());
		collection.set(0,collection.get(collection.size()-1));
		collection.remove(collection.size()-1);
		System.out.println("after move size: "+collection.size());
		top--;
		// siftDown
		if(collection.size()>1) {
		siftDown(0);
		}
		return tempT;
		}
	}
	
	//Help method to Heapify the heap
	private void siftDown(int index) {
		
		int leftChildIndex = index*2+1;
		int rightChildIndex = index*2+2;
		int minIndex;
		if(rightChildIndex >= collection.size()) {
			if(leftChildIndex >= collection.size()) {
				return;
			}
			else {
				minIndex = leftChildIndex;
			}
		}

		else {
			if(collection.get(leftChildIndex).getKey()<=collection.get(rightChildIndex).getKey()) {
				minIndex = leftChildIndex;
			}
			 else
			 {
                 minIndex = rightChildIndex;
			 }
		
			if(collection.get(index).getKey()>collection.get(minIndex).getKey()) {
				boundedObject tempBoundedObject = collection.get(index);
				collection.set(index , collection.get(minIndex));
				collection.set(minIndex, tempBoundedObject);
				System.out.println(index + " is swap with it parent " + (minIndex));
				siftDown(minIndex);				
			}
			
		}				
	}



	// Returns but does not remove the element with the smallest key.
	@Override
	public T min() {
		return (T) collection.get(0).getT();
	}
	
	
	//Help function to swap the bounded object when you insert
	private boolean swapInsert(int index) {
		int tempIndex = index + 1;
		boolean isSwap = false; 
		while(tempIndex/2 > 0) {
			if(collection.get(tempIndex -1).getKey() < collection.get((tempIndex/2 -1)).getKey()) 
			{
				boundedObject tempBoundedObject = collection.get(tempIndex -1);
				collection.set(tempIndex -1 , collection.get((tempIndex/2)-1));
				collection.set((tempIndex/2)-1, tempBoundedObject);
				isSwap = true;
				System.out.println(tempIndex-1 + " is swap with it parent " + ((tempIndex / 2)-1));
			}
			
			tempIndex = tempIndex / 2;			
		}
		return isSwap;	
	}
	
	public void printQueue() {		
		
		for(boundedObject bo : collection) {
			
			System.out.println(bo.getKey() + " "+ bo.getT().toString());
		}
		
	}

	private ArrayList<boundedObject> getCollection() {
		return collection;
	}

	private void setCollection(ArrayList<boundedObject> collection) {
		this.collection = collection;
	}

	private int getCapacity() {
		return capacity;
	}

	private void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	private int getTop() {
		return top;
	}

	private void setTop(int top) {
		this.top = top;
	}

}
