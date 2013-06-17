package stack;

public class ArrayStack {
	public int top1 = -1;
	public int top2 = -1;
	public int top3 = -1;
	public int capacity;
	public Node[] s;
	
	public ArrayStack(int capacity){
		this.capacity = capacity;
		this.s = new Node[3*capacity];
	}
	
	public boolean push(Node n, int i){
		int top = getTop(i);
		if(top < (i+1) * capacity - 1){ //not full
			s[++top] = n;
			setTop(i,top);
			return true;
		}
		return false;
	}
	
	public Node pop(int i){
		int top = getTop(i);
		if(top >= i * capacity){ //not empty
			Node node = s[top--];
			setTop(i,top);
			return node;
		}
		setTop(i,-1);
		return null;
	}
	
	
	public boolean isEmpty(int i){
		int top = getTop(i);
		if (top == -1)
			return true;
		return false;
	}
	
	
	private void setTop(int i, int top){
		if(top < i * capacity) //check if it is empty
			top = -1;
		switch(i){
			case 0 : top1 = top;
			case 1 : top2 = top;
			case 2 : top3 = top;
		}
	}
	
	
	private int getTop(int i){
		switch(i){
			case 0 : return top1;
			case 1 : return top2;
			case 2 : return top3;
		}
		return 0;
	}
	
	
	public static void main(String args[]){
		ArrayStack s = new ArrayStack(3);
		s.push(new Node(1), 0);
		s.push(new Node(2), 0);
		s.push(new Node(3), 0);
		s.push(new Node(9), 0);
		
		while(!s.isEmpty(0)){
			System.out.println(s.pop(0).data);
		}
	}
	
}
