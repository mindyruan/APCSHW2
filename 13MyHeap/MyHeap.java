import java.util.*;

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

    //remove root
    public int remove(){
	if (heap[0] == 0){
	    System.out.println("stop that");
	    return -1;
	}else{
	    int temp = heap[1];
	    
	    //replace root with last added
	    heap[1] = heap[heap[0]];
	    //heap[heap[0]] = 0;
	    //heap[0]--;
	    System.out.println(heap[0]);

	    //swap down
	    int curr = 1;
	    //System.out.println(hasChildren(curr));
	    
	    System.out.println(this + "go!!");

	    if (heap[0] > 1){
		//while there are children
		while (hasChildren(curr)){
		    //if child > new root
		    if (heap[getLeft(curr)] > heap[curr]){
			swap(getLeft(curr),curr);
			curr = getLeft(curr);
		    }else if (heap[getRight(curr)] > heap[curr]){
			swap(getRight(curr),curr);
			curr = getRight(curr);
		    }else{
			break;
		    }
		    System.out.println(this);
		}
	    }
	    
	    heap[0]--;
	    return temp;
	}
    }

    public boolean hasChildren(int i){
	return (getLeft(i) <= heap[0] || getRight(i) <= heap[0]);
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

	h.add(70);
	h.add(88);
	h.add(98);
	h.add(5);
	h.add(900);
	h.add(4);
	h.add(0);
	h.add(-2);
	print(h);

	print("remove root!! (please)");
	h.remove();
	print(h);

    }

    public static void print(Object o){
	System.out.println(o);
    }

}
