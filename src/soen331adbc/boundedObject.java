package soen331adbc;

public class boundedObject <T> {
	
	T t;
	int key;
	
	public boundedObject(T t, int key) {
		this.t = t;
		this.key = key;
	}
	
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
}
