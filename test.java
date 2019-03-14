package soen331adbc;
// the bp has been inserted with two elements with the same key
public class test {

	public static void main(String[] args) {
		System.out.println("Hello");
		
		BoundedPriorityQueue <String> bp = new BoundedPriorityQueue(10);
		bp.insert("aaa", 3);
		bp.insert("bbb", 6);
		bp.insert("ccc", 2);
		bp.insert("ddd", 1);
		bp.insert("eee", 1);
		bp.insert("fff", 4);
		bp.insert("ggg", 3);
		bp.printQueue();		
		System.out.println("minium is "+ bp.min());
		bp.remove();
		bp.printQueue();
		bp.remove();
		bp.printQueue();
		bp.remove();
		bp.printQueue();
		bp.remove();
		bp.printQueue();
		bp.remove();
		bp.printQueue();
		bp.remove();
		bp.printQueue();
		bp.remove();
	//	bp.printQueue();  comment out here since the pq is empty

	}

}
