import java.util.*;

public class MyHeap{
    private int[] heap = new int[6];
    private boolean max;

    public MyHeap(){
	max = true;
    }

    public MyHeap(boolean isMax){
	max = isMax;
    }

    //get the left child of this index
    public int getLeft(int index){
	return index*2;
    }

    //get the right child of this index
    public int getRight(int index){
	return index*2 + 1;
    }

    public String toString(){
	return Arrays.toString(heap);
	/*
	String ans = "[ ";
	for (int i = 0; i < heap.length; i++){
	    ans += heap[i] + " ";
	}
	ans += "]";
	return ans;
	*/
    }

    public int remove(){
	// remove root
	int temp = heap[1];

	return -1;
    }

    public void add(int x){
	//resize if needed

	//heap[0] = number of elements in heap
	//next open spot in array = x
	heap[heap[0] + 1] = x;
	heap[0]++;

	/*
	if (size == 0){ //add at root
	    heap[1] = x;
	    size++;
	}else{
	}
	*/
    }

    public int peek(){
	//root at index 1
	return heap[1];
    }

    public static void main(String[]arg){
	MyHeap h = new MyHeap();
	print(h);

	h.add(88);
	print(h);

	h.add(2);
	print(h);
    }

    public static void print(Object o){
	System.out.println(o);
    }

}
