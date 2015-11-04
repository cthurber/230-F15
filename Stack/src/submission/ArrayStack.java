package submission;

import adt.Stack;

public class ArrayStack<T> implements Stack<T> {
	private int MaxSize = 102;
	private T[] data = (T[]) new Object[MaxSize];
	private int top = -1;
	private int stackSize = data.length;
	
	
	@Override
	// One ontop of the other
	public void push(T newEntry) {
		top++;
		data[top] = newEntry;
	}

	@Override
	public T pop() {
		if(!this.isEmpty()) {
			T temp = data[top];
			top--;
			return temp;
		}
		else return null;
	}

	@Override
	public T peek() {
		return data[top];
	}

	@Override
	public boolean isEmpty() {
		if(top==-1) return true;
		else return false;
	}

	@Override
	public void clear() {
		data = (T[]) new Object[MaxSize];
		top = -1;
	}
	
	public String toString() {
		String s = "";
		for (int i = top; i >= 0; i--)
			s += "| " + data[i] + " |\n";
		s+= "+++++\n";
		return s;
	}

}
