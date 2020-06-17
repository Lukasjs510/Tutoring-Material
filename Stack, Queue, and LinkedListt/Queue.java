public class Queue {
	LinkedList q;
	public Queue(){
		q = new LinkedList();
	}
	
	public void push(int value){
		q.addToTail(value);
	}
	
	public int pop(){
		return q.popHead();
	}
	
	public boolean peek(){
		return q.hasNextHead();
	}
	
	public String toString(){
		return q.toString();
	}
}