package submission;

import adt.Stack;

public class Palindrome {
	public static boolean isPalindrome(String s) {
		Stack<String> compare = new LinkedStack<String>();
		String reverse = "";
		char[] q = s.toCharArray();
		for(int i=0; i<s.toCharArray().length; i++) {
			String c = String.valueOf(q[i]);
			compare.push(c);
		}
		while(!compare.isEmpty()) {
			reverse += compare.pop();
		}
		if(s.toLowerCase().equals(reverse.toLowerCase())) return true;
		else return false;
	}
}