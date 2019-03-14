//adbc reference: https://users.encs.concordia.ca/~cc/soen331/material/lectures/adbc.pdf
 
//PQ reference:http://www.algolist.net/Data_structures/Binary_heap/Remove_minimum

package soen331adbc;


import java.util.ArrayList;


import be.ac.ua.ansymo.adbc.annotations.ensures;

import be.ac.ua.ansymo.adbc.annotations.invariant;

import be.ac.ua.ansymo.adbc.annotations.requires;




@invariant ({ "$this.top >= -1",

	"$this.capacity > 0",

	"$this.top <= $this.capacity"

	})

public class BoundedPriorityQueue <T> implements PriorityQueue<T> {

	

	//1) Shape Property: A binary heap is a complete binary tree, this means all of the levels of the tree are completely filled except possibly the last level. The nodes are filled from left to right.

	//2) Heap Property: The value stored in each node is either (greater than or equal to) OR (less than or equal to ) it¡¯s children depending if it is a max heap or a min heap.

	//3) Using Williams Method of building a heap

	

	public ArrayList<boundedObject>collection;

	public int capacity;

	public int top = -1;

	

	@requires ({"capacity > 0"})

	@ensures ({"$this.collection != null" })

	public BoundedPriorityQueue (int capacity) {

		this.capacity = capacity;

		this.collection = new ArrayList<boundedObject>(capacity);

		}

	
    //@requires ({"true"})
	public boolean isEmpty() {
		return this.collection.isEmpty();
	}

	

	/*	

	   if heap is empty, 

			place item at root; 

		

		else, 

			place item at bottom of heap; 

			while (child > parent) 

			swap(parent, child); 

	 */

	@requires	({   //this one is for insert

		"t != null",

		"key > 0 ",

		"$this.isFull() == false"

			})

	@Override
	public void insert(T t, int key) {

			boundedObject bd = new boundedObject(t,key);

			inserthelp(bd);

		}

	

	@ensures({         //this on is for insert help

		"$this.collection.contains(bd)",

		"$this.isMin() ==true", 

		"$this.getSize() == $old($this.getSize()) + 1"		

	})

	//helper function for adbc test 
	public void inserthelp(boundedObject bd) {

		if(top ==-1) {

			collection.add(++top,bd);

		}

		else{

			collection.add(++top,bd);

			swapInsert(top);							

		}

		

	};

	//@requires({"true"})
	public boolean isFull() {		

		return this.getSize() == this.getCapacity();		

	}

	
	//@requires({"true"})
	public boolean isMin() {

		boolean temp = false;

		for(boundedObject bd : collection) {

			if(collection.get(0).getKey()<=bd.getKey()) {

				temp = true;

			}

		}

		return temp;

	}

	

	@requires({"true"})

	@ensures({"$result > 0"})

	public int getSize() {

		return top + 1;

	}

	

	//Removes and returns the element with the smallest key.

	@Override
	@requires ({"$this.isEmpty() == false"})
	@ensures ({
	"$this != null",
	//"$this.isMin()==true",
	"$this.getSize() == $old($this.getSize()) - 1",
	"$this.getSize() >= 0"    // I change it from >=1
	})
	public T remove() {
		//Todo maybe need remove if condition catch by contractor
		/*
		 * if(collection.isEmpty()) {
		 * 
		 * System.out.println("Heap is empty");
		 * 
		 * return null;
		 * 
		 * }
		 * 
		 * else
		 */

		{

		T tempT = (T) collection.get(0).getT();

		System.out.println("before move size: "+collection.size());

		collection.set(0,collection.get(collection.size()-1));

		collection.remove(collection.size()-1);

		System.out.println("after move size: "+collection.size());

		top--;

		// siftDown
		// need to remove condition      an update, done!
//		if(collection.size()>1) {

		siftDown(0);

//		}

		return tempT;

		}

	}

	

	//Helper method to Heapify the heap

	public void siftDown(int index) {

		

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

	@requires ({"$this.isEmpty() == false"})
	public T min() {

		return (T) collection.get(0).getT();

	}

	

	

	//Help function to swap the bounded object when you insert

	public boolean swapInsert(int index) {

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

	


	@requires ({"$this.getTop()>-1" })  // can the size be -1?
	public void printQueue() {		

		for(boundedObject bo : collection) {

			System.out.println(bo.getKey() + " "+ bo.getT().toString());
		}
	}



//	public ArrayList<boundedObject> getCollection() {
//
//		return collection;
//
//	}



//	public void setCollection(ArrayList<boundedObject> collection) {
//
//		this.collection = collection;
//
//	}



	@requires({"true"})

	@ensures({"$result > 0"})

	public int getCapacity() {

		return capacity;

	}


//
//	public void setCapacity(int capacity) {
//
//		this.capacity = capacity;
//
//	}



	@requires({"true"})

	@ensures({"$result > -1"})

	public int getTop() {

		return top;

	}



//	public void setTop(int top) {
//
//		this.top = top;
//
//	}



}