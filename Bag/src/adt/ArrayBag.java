package adt;

import java.util.Arrays;


public class ArrayBag<T> implements BagInterface<T> {

	private T[] bag;
	private int numEntries = 0; // points to the index of the next entry to add
	private static final int DEFAULT_CAPACITY = 10;
	
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayBag(int capacity) {
		bag = (T[]) new Object[capacity];
	}
	
	@Override
	public int getCurrentSize() {
		return numEntries;
	}

	@Override
	public boolean isEmpty() {
		return numEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		if (!isArrayFull()) {
			bag[numEntries] = newEntry;
			numEntries++;
			return true;
		}
		return false;
	}
	
	public boolean insertAt(T anEntry, int index) {
		if(index>this.bag.length) return false;
		else {
			for(int i=numEntries-1; i>=index; i--) {
				bag[i+1] = bag[i];
			}
			bag[index] = anEntry;
			numEntries++;
		}
		return true;
	}

	private boolean isArrayFull() {
		return numEntries >= bag.length;
	}

	@Override
	public T remove() {
		numEntries--; // numEntries -= 1 OR numEntries = numEntries - 1
		T temp = bag[numEntries];
		bag[numEntries] = null;
		return temp;
	}

	@Override
	public boolean remove(T anEntry) {
		// loop through the bag
		for (int i = 0; i < numEntries; i++) {
			// compare item to anEntry
			if (bag[i].equals(anEntry)) {
				// remove it
				bag[i] = bag[numEntries-1];
				numEntries--;
				bag[numEntries] = null; //optional
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		this.bag = (T[]) new Object[DEFAULT_CAPACITY];
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int freq = 0;
		for(int i=0; i<numEntries; i++) {
			if(bag[i].equals(anEntry)) freq++;
		}
		return freq;
	}

	@Override
	public boolean contains(T anEntry) {
		for(int i=0; i<numEntries; i++) {
			if(bag[i].equals(anEntry)) return true;
		}
		return false;
	}

	@Override
	public T[] toArray() {
		return Arrays.copyOf(bag, numEntries);
	}
	
	public String toString() {
		String s = "";
		for (T item : this.toArray())
			s += item.toString() + " ";
		return s;
	}
	
	// Client to test our implementation
	public static void main(String[] args) {
		ArrayBag<String> b = new ArrayBag<String>();
		b.add("1 thing");
		b.add("2 thing");
		b.add("3 thing");
		b.add("4 thing");
		System.out.println("Before:");
		for ( Object entry : b.toArray() )
			System.out.println((String)entry);
		b.insertAt("5 thing",2);
		System.out.println();
		System.out.println("After:");
		for ( Object entry : b.toArray() )
			System.out.println((String)entry);
	}

}
