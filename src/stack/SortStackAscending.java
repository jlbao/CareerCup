package stack;

public class SortStackAscending {

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(new Node(3));
		s.push(new Node(5));
		s.push(new Node(19));
		s.push(new Node(2));
		
		s = sortStackAscending(s);
		
		while(!s.isEmpty()){
			System.out.println(s.pop().data);
		}
	}
	
	public static Stack sortStackAscending(Stack s){
		Stack temp = new Stack();
		while(!s.isEmpty()){
			Node n = s.pop();
			while(!temp.isEmpty() && n.data > temp.peek().data){
				s.push(temp.pop());
			}
			temp.push(n);
		}
		return temp;
	}
}
