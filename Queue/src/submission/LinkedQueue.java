package submission;

import adt.Queue;

public class LinkedQueue<T> implements Queue<T> {
	private Node head, tail;
	private int numEntries = 0;
	
	@Override
	public void enqueue(T newEntry) {
		Node oldlast = tail;
		tail = new Node(newEntry,null);
        if (isEmpty()) head = tail;
        else oldlast.next = tail;
        numEntries++;
	}

	@Override
	public T dequeue() {
		if (isEmpty()) return null;
        T data = head.data;
        head = head.next;
        numEntries--;
        return data;
	}

	@Override
	public T peek() {
		if(isEmpty()) return null;
		else return head.data;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void clear() {
		head = null;
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
