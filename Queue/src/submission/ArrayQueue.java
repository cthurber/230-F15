package submission;

import adt.Queue;

public class ArrayQueue<T> implements Queue<T> {
	private T[] data;
	private int head, tail = 0;
	private static int DEFAULT_CAPACITY = 100;
	
	/*
    public ArrayQueue() {
       tail = 0;
       data = (T[])(new Object[DEFAULT_CAPACITY]);
    }
	
    public ArrayQueue (int initialCapacity) {
       tail = 0;
       data = (T[])(new Object[initialCapacity]);
    }
    */
	
	@Override
	public void enqueue (T element) {
//       if (size() == data.length) 
//          expandCapacity();
       data[tail] = element;
       tail++;
    }

	@Override
    public T dequeue() {
       if (isEmpty())
          return null;
 
       T result = data[0];
 
       tail--;
 
       /** shift the elements  */
       for (int scan=0; scan < tail; scan++)
          data[scan] = data[scan+1];
       
       data[tail] = null;
 
       return result;
    }

	@Override
	public T peek() {
       if (isEmpty())
          return null;  
       return data[0];
    }

	@Override
	public boolean isEmpty() {
		return tail==0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		data = (T[]) new Object[DEFAULT_CAPACITY];
		head = 0;
		tail = 0;
	}
	
	public String toString() {
		String s = data[head].toString();
		for (int i = (head+1) % data.length; i <= (tail + data.length) % data.length; i++)
			s += " -> " + data[i];
		s+= "\n";
		return s;
	}

}
