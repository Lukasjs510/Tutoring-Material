public class Stack {
	LinkedList s;
	public Stack{
		s = new LinkedList();
	}
	
	public void push(int value){
		s.addToHead(value);
	}
	
	public int pop(){
		return s.popHead();
	}
	
	public boolean peek(){
		return s.hasNextHead();
	}
	
	public String toString(){
		return s.toString();
	}
}