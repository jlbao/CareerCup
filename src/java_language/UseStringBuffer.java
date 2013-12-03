package java_language;

public class UseStringBuffer {

	/**
	 * StringBuffer is great because it has internally created a buffer
	 * for each append, we do not need to concatenate the string together until necessary
	 * But for String, it will reallocate new memory, create new array, copy it, too much waste
	 * StringBuffer is thread-safe, but StringBuilder is non-thread-safe
	 */
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		// or StringBuilder
		for(int i = 0; i < 1000; i++){
			sb.append(i);
		}
		System.out.println(sb);
	}
}
