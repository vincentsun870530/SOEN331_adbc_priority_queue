package soen331adbc;
//comment out these bp objects to simulating errors
public class simulatingError {

	public static void main(String[] arg) {
//	     BoundedPriorityQueue <String> bp = new BoundedPriorityQueue(0);
	    //capacity 0

//	     BoundedPriorityQueue <String> bp = new BoundedPriorityQueue(10);
//	     bp.remove();
	//trying to remove when there’s no element (empty)

//         BoundedPriorityQueue <String> bp = new BoundedPriorityQueue(10);
//	     bp.min();
	    //trying to retrieve an element when there’s no element (empty)

//	    BoundedPriorityQueue <String> bp = new BoundedPriorityQueue(1);
//	    bp.insert("aaa", 5);
//	    bp.insert("aaa", 7);
	    //adding an extra element when the list is full

//	    BoundedPriorityQueue <String> bp = new BoundedPriorityQueue(1);
//	    bp.insert("aaa", -5);
	    //key value not > 0

//	    BoundedPriorityQueue <String> bp = new BoundedPriorityQueue(1);
//	    bp.insert(null, 5);
	    //value of t is null
		
//		BoundedPriorityQueue <String> bp = new BoundedPriorityQueue(2);
//	    bp.getSize();
	    //size not > 0 since its empty
		
//		BoundedPrioritsyQueue <String> bp = new BoundedPriorityQueue(0);
//	    bp.getCapacity();
	    //will stop at the precondition that says capacity cant be 0 so no need for a contract on getcapacity?

		
//		BoundedPriorityQueue <String> bp = new BoundedPriorityQueue(1);
//	    bp.getTop();  
//	    // result should be > -1
		
		
		
		
		
		//this is a good condition which indicates that $result should be > -1
//	    BoundedPriorityQueue <String> bp = new BoundedPriorityQueue(1);
//	    bp.insert("A", 1);
//	    System.out.println(bp.getTop());
	    
		

	    

	}
}
