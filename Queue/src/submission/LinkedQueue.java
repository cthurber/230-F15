package submission;

import adt.Queue;

public class LinkedQueue<T> implements Queue<T> {
	private Node head, tail;
	private int numEntries = 0;
	
	@Override
	public void enqueue(T newEntry) {
		// TODO Write method to "push" item into the "line"
		// Q: Should I write it so that every "enqueue" adds to the end to retain the front?
		//    or should I write it just like Stack but keep track of the "first" item
		//    - If latter: How can I get "head.prev"? (because head.next would be null)
		if(numEntries==0) head = new Node(newEntry);
		while(head.next!=null){
			head = head.next;
		} head.next = new Node(newEntry);
		tail = head.next; // Necessary?
		numEntries++;
	}

	@Override
	public T dequeue() {
		T current = head.data;
		head = head.next;
		numEntries--;
		return current;
	}

	@Override
	public T peek() {
		// Should this return the beginning of the line or the end?
		// I think beginning...
		return head.data;
	}

	@Override
	public boolean isEmpty() {
		if(numEntries==0) return true;
		else return false;
	}

	@Override
	public void clear() {
		head = new Node(null);
		numEntries = 0 ;
	}
	
	public String toString() {
		String s = head.data.toString();
		for (Node i = head.next; i != null; i = i.next)
			s += " -> " + i.data;
		s+= "\n";
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
