package soen331adbc;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		
		BoundedPriorityQueue <String> bp = new BoundedPriorityQueue(10);
		bp.insert("aaa", 50);
		bp.insert("bbb", 10);
		bp.insert("ccc", 7);
		bp.insert("ddd", 3);
		bp.insert("eee", 49);
		bp.insert("fff", 20);
		bp.insert("ggg", 1);
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
		bp.printQueue();
		bp.remove();
		bp.printQueue();
	}

}
