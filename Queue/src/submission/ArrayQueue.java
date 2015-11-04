package submission;

import adt.Queue;

public class ArrayQueue<T> implements Queue<T> {
	private T[] data;
	private int head, tail = 0;
	private int size = data.length;
	
	@Override
	public void enqueue(T newEntry) {
		if(size==0) {
			data[head] = newEntry;
		} else {
			int index = 0;
			while(data[index]!=null){
				index++;
			}
			tail = index;
			data[index] = newEntry;
		}
		
	}

	@Override
	public T dequeue() {
		T current = data[tail];
		tail--;
		return current;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		String s = data[head].toString();
		for (int i = head+1 % data.length; i >= 0; i--)
			s += " -> " + data[i];
		s+= "\n";
		return s;
	}

}
