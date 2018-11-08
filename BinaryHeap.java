import java.lang.IllegalStateException;

public class BinaryHeap {
	private int size = 0;//Indexing from 0
	private int[] arr = new int[10];

	public void add(int num){
		if(size == arr.length){
			growArr();
		}
		arr[size] = num;
		size++;

		int item = size - 1;
		int parent = (item - 1)/2;

		while(item > 0 && arr[item] < arr[parent]){
			swap(arr,item,parent);
			item = parent;
			parent = (item - 1)/2;
		}
	}
	public int remove(){
		// if(size == 0){
		// 	throw new IllegalAccessException("Nothing there to remove");
		// }
		int priority = arr[0];
		arr[0] = arr[size -1];
		size--;
		shiftdown(0);

		return priority;
	}
	private void shiftdown(int parent){
		int child = (parent*2) + 1;//index 0 offset

		if(child >= size){
			return;
		}
		if(arr[child + 1] < arr[child]){
			child++;
		}
		if(arr[parent] < arr[child]){
			return;
		}
		swap(arr,child,parent);
		shiftdown(child);
	}
	private void growArr(){
		int longer_arr_len = arr.length * 2;
		int[] arr_longer = new int[longer_arr_len];
		
		for(int i = 0; i < arr.length; i++){
			arr_longer[i] = arr[i];
		}
		arr = arr_longer;
	}
	private void swap(int arr[], int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	


}