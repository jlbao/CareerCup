package stack;

public class Stack {
	protected Node top;
	
	public void push(Node n){
		n.next = top;
		top = n;
	}
	
	public Node pop(){
		if(isEmpty())
			return null;
		Node n = top;
		top = top.next;
		return n;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public Node peek(){
		return top;
	}
	
	
}
