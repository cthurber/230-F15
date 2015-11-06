package submission;

import adt.Queue;

public class ArrayQueue<T> implements Queue<T> {
	private T[] data;
	private int head, tail;
	private static int DEFAULT_CAPACITY = 100;
	
    public ArrayQueue() {
       tail = 0;
       data = (T[])(new Object[DEFAULT_CAPACITY]);
    }
	
    public ArrayQueue (int initialCapacity) {
       tail = 0;
       data = (T[])(new Object[initialCapacity]);
    }
    
	@Override
	public void enqueue (T element) {
       data[tail] = element;
       tail++;
    }

	@Override
    public T dequeue() {
       if (isEmpty())
          return null;
 
       T result = data[0];
       tail--;
       for (int look=0; look < tail; look++)
          data[look] = data[look+1];
       //data[tail] = null;
       return result;
    }

	@Override
	public T peek() {
       if (isEmpty())
          return null;  
       return data[head];
    }

	@Override
	public boolean isEmpty() {
		return tail==0;
	}

	@Override
	public void clear() {
		// Less efficient: while(!isEmpty()) this.dequeue();
		data = (T[])(new Object[DEFAULT_CAPACITY]);
		tail = 0;
	}
	
	public String toString() {
		String s = "";
		if (!isEmpty())
			s = data[head].toString();
		for (int i = (head+1) % data.length; i <= (tail + data.length-1) % data.length; i++)
			s += " -> " + data[i];
		s+= "\n";
		return s;
	}

}
