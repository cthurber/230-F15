package submission;

public class RecursiveInsertionSorter {
	
	private static int first = 0;
	
	public static int[] sort(int[] unsorted) {
		int[] sorted = sorter(unsorted,unsorted.length-1);
		return sort(sorted); // Don't touch
	}
	
	public static int[] sorter(int[]unsorted, int last){
		if(first<last) {
			sorter(unsorted, last-1);
			swap(unsorted[last],unsorted,last-1);
		}
		return unsorted;
	}
	
	public static int[] swap(int num, int[]unsorted, int end){
		if(num>=unsorted[end]){
			unsorted[end+1]=num;
		}
		else if(first<end){
			unsorted[end+1]=unsorted[end];
			swap(num,unsorted,end-1);
		}
		else{
			unsorted[end+1]=unsorted[end];
			unsorted[end]=num;
		}
		return unsorted;
	}
}