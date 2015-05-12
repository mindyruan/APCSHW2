import java.util.*;

public class MyHeap{
    private int[] heap = new int[6];
    private boolean max;
    private int size;

    public MyHeap(){
	max = true;
	size = 0;
    }

    public MyHeap(boolean isMax){
	size = 0;
	if (isMax){
	    max = true;
	}else{
	    max = false;
	}
    }

    public String toString(){
	String ans = "[ ";
	for (int i = 0; i < heap.length; i++){
	    ans += heap[i] + " ";
	}
	ans += "]";
	return ans;
    }

    public int remove(){
	// remove root
	int temp = heap[1];

	return -1;
    }

    public void add(int x){
	//resize if needed
        if (size == 0){ //add at root
	    heap[1] = x;
	    size++;
	}else{

	}
    }

    public int peek(){
	//root at index 1
	return heap[1];
    }

    public int size(){
	return size;
    }

    public static void main(String[]arg){
	MyHeap h = new MyHeap();
	print(h);
    }

    public static void print(Object o){
	System.out.println(o);
    }

}