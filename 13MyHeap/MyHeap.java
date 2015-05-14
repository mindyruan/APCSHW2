What's your D&D Alignment?import java.util.*;

public class MyHeap{

    private int[] heap = new int[10];
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
    }

    public int remove(){
	// remove root
	int temp = heap[1];

	return -1;
    }

    public void swap(int i, int j){
	int temp = heap[i];
	heap[i] = heap[j];
	heap[j] = temp;
    }

    public void add(int x){
	//resize if needed

	//heap[0] = number of elements in heap
	//next open spot in array = x
	heap[heap[0] + 1] = x;
	heap[0]++;
	int size = heap[0];

	//compare and swap
	while (heap[0]/2 > 0){

	    //if child > parent
	    if (heap[heap[0]] > heap[heap[0]/2]){
		swap(heap[0], heap[0]/2);
	    }
	    //System.out.println(heap[0]);
	    
	    heap[0] = heap[0]/2;
	}
	heap[0] = size;

    }

    public int peek(){
	//root at index 1
	return heap[1];
    }

    public static void main(String[]arg){
	MyHeap h = new MyHeap();
	print(h);

	h.add(70);
	print(h);
	h.add(88);
	h.add(98);
	h.add(5);
	print(h);
	h.add(900);
	h.add(4);
	h.add(0);
	h.add(-2);
	print(h);

    }

    public static void print(Object o){
	System.out.println(o);
    }

}
