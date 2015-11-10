package adt;


public class LinkedBag<T> implements BagInterface<T>{
	private Node head = null;       // Reference to first node
	private int numEntries = 0;
	
	public String toString() {
		String s = "";
		// iterate over all the items in people chain
		Node n = head;
		while (n != null) {
			// do something to s with n's name
			s += n.data + " -> ";
			n = n.next;
		}
		s += "null";
		return s;
	}

	@Override
	public int getCurrentSize() {
		return numEntries;
	}
	
	public int getNumNodes(Node n, int count) {
		if(n!=null) return getNumNodes(n.next,count+1);
		else return count;
	}

	@Override
	public boolean isEmpty() {
		return numEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		head = new Node(newEntry, head);
		numEntries++;
		return true;
	}

	@Override
	public T remove() {
		T temp = head.data;
		head = head.next;
		return temp;
	}

	@Override
	public boolean remove(T anEntry) {
		Node n = head;
		Node prev = null;
		while (n != null) {
			if (n.data.equals(anEntry)) {
				// remove the node
				if (prev == null) // only for the first case
					head = head.next;
				else
					prev.next = n.next; // all other cases
				numEntries--;
				return true;
			}
			prev = n;
			n = n.next;
		}
		return false;
	}

	@Override
	public void clear() {
		head = null;
		numEntries = 0;
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		Node n = head;
		int freq = 0;
		while(n!=null) {
			if(n.data.equals(anEntry)) freq++;
			n=n.next;
		}
		return freq;
	}

	@Override
	public boolean contains(T anEntry) {
		Node n = head;
		while(n!=null) {
			if(n.data.equals(anEntry)) return true;
			n=n.next;
		}
		return false;
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[numEntries];
		Node n = head;
		int i = 0;
		while (n != null) { 
			array[i] = n.data;
			i++;
			n = n.next;
		}
		return array;
	}
	
	public boolean insertAt(T anEntry, int spot) {
		if(spot>numEntries) return false;
		else {
			int count = 0;
			Node n = head;
			Node prev = head;
			while(count<spot){
				prev = n;
				n = n.next;
				count++;
			}
			prev.next = new Node(anEntry,n);
			numEntries++;
			return true;
		}
	}
	
	public LinkedBag intersection(LinkedBag b) {
		LinkedBag<T> union = new LinkedBag<T>();
		Node leadNode;
		Node lendNode;
		
		if(this.getCurrentSize() > b.getCurrentSize()) {
			leadNode = b.head;
			lendNode = this.head;
		} else {
			leadNode = this.head;
			lendNode = b.head;
		}
		
		while(leadNode!=null){
			Node iterNode = lendNode;
			while(iterNode!=null){
				System.out.println(leadNode.data+" == "+iterNode.data);
				if(iterNode.data.equals(leadNode.data)) union.add(iterNode.data);
				iterNode = lendNode.next;
			}
			iterNode = lendNode;
			leadNode = leadNode.next;
		}
		
		return union;
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
	
	public static void main(String[] args) {
		LinkedBag<String> baga = new LinkedBag<String>();
		baga.add("awesome!");
		baga.add("is");
		baga.add("230");
		baga.add("CSCI");
		System.out.println("Before: "+baga.toString());
		
		System.out.println("CurrentSize: "+baga.getCurrentSize());
		//System.out.println(baga.head);
		System.out.println("CurrentSize: "+baga.getNumNodes(baga.head,0));
	}

}
