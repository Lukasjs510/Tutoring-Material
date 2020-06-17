public class LinkedList {
	Link head;
	Link tail;
	int size;
	public LinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	
	public void addToHead(E value){
		Link newLink = new Link(value);
		if (size == 0){
			head = newLink;
			tail = newLink
			newLink.next = tail;
			newLink.prev = null;
		} else {
			head.prev = newLink;
			newLink.next = head;
			head = newLink;	
		}
		size++;
	}
	
	public void addToTail(E value){
		Link newLink = new Link(value);
		if (size == 0){
			tail = newLink;
			head = newLink
			newLink.prev = head;
			newLink.next = null;
		} else {
			tail.next = newLink;
			newLink.prev = tail;
			tail = newLink;
		}
		size++;
	}
	
	public E popHead(){
		E h = head;
		head = head.next;
		head.prev = null;
		size--;
		return h;
	}
	
	public E popTail(){
		E t = tail;
		tail = tail.prev;
		tail.next = null;
		size--;
		return t;
	}
	
	public boolean hasNext(Link l){
		if (l.next != null){
			return true;
		}
		return false;
	}
	
	public boolean hasPrev(Link l){
		if (l.prev != null){
			return true;
		}
		return false;
	}
	
	public int getSize(){
		return size;
	}
	
	public String toString(){
		Link l = head;
		String s = "[";
		while(hasNext(l)){
			s += l.getValue() + ", ";
		}
		s += l.next + "]";
		return s;
	}
	
}
private class Link{
	Link next;
	Link prev;
	E value;
	public Link(E value){
		this.next = null;
		this.prev = null;
		this.value = value;
	}
	
	public Link(E value, Link prev, Link next){
		this.next = next;
		this.prev = prev;
		this.value = value;
	}
	
	public E getValue(){
		return value;
	}
	
	public void setValue(E newValue){
		this.value = newValue;
	}
}