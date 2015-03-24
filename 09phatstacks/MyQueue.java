import java.util.*;

public class MyQueue<T>{

    private MyLinkedList<T> queue;

    public MyQueue(){
	queue = new MyLinkedList<T>();
    }

    //add to queue
    public boolean enqueue(T val){
	if (val == null){
	    //System.out.println("idiot");
	    throw new NullPointerException();
	}
	queue.add(val);
	return true;
    }

    //remove from queue
    public T dequeue(){
	if (empty()){
	    throw new NoSuchElementException();
	}
	return queue.remove(0);
    }

    public String toString(){
	return queue.toString();
    }

    public boolean empty(){
	return queue.size() == 0;
    }

    public static void main(String[]arg){

	MyQueue<String> q = new MyQueue<String>();

	//q.enqueue(null);
	q.enqueue("brosky");
	q.enqueue("bruh");
	System.out.println(q);
	q.dequeue();
	System.out.println(q);

    }


}
