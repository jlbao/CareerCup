package stack;

public class ArrayStackOperation {

	public static Integer i = 3;

	public static void main(String[] args) {
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
