package submission;

import adt.Stack;

public class LinkedStack<T> implements Stack<T> {
	private Node top;
	private int stackSize = 0;
	
	@Override
	public void push(T newEntry) {
		top = new Node(newEntry,top);
		stackSize++;
	}

	@Override
	// TODO Should remove an item form the linked stack
	public T pop() {
		if (this.isEmpty() == false){
			T current = top.data;
			top = top.next;
			stackSize--;
			return current;
		} else {
			return null;
		}
	}

	@Override
	// Should return the data of 'this'?
	public T peek() {
		if(this.isEmpty() == false) return top.data;
		else return null;
	}

	@Override
	public boolean isEmpty() {
		if(stackSize == 0) return true;
		else return false;
	}

	@Override
	public void clear() {
		top = null;
		stackSize = 0;
	}
	
	public String toString() {
		String s = "";
		for (Node n = top; n != null; n = n.next)
			s += "| " + n.data + " |\n";
		s+= "+++++\n";
		return s;
	}
	
	private class Node 
	{
	  private T    data; // Entry in bag
	  private Node next; // Link to next node

		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
	} // end Node

}
