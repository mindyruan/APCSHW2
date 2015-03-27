import java.util.*;

public class MyDeque<T>{

    private Object[]deque;
    private int head,tail,size;

    public MyDeque(){
	deque = new Object[10];
	head = 5;
	tail = 4;
	size = 0;
    }

    public void addFirst(T val){
	head--;
	if (head == -1){
	    //wrap to the end
	    head = deque.length-1;
	}
	//System.out.println(deque[head]);
	deque[head] = val;
	//System.out.println(deque[head]);
	size++;
    }

    public void addLast(T val){
	tail++;
	if (tail == deque.length){
	    //wrap to the beginning
	    tail = 0;
	}
	deque[tail] = val;
	size++;
    }

    public T removeFirst(){ //T
	T ans = (T)deque[head];
	head++;
	if (head == deque.length){
	    head = 0;
	}
	return ans;
    }

    public void removeLast(){ //T

    }

    public void getFirst(){ //T

    }

    public void getLast(){ //T

    }

    public String toString(){
	String ans = "[ ";
	for (int i = 0; i < deque.length; i++){
	    ans += deque[i] + ", ";
	}
	return ans.substring(0,ans.length()-2) + " ]";
    }

    public static void main(String[]args){
	MyDeque<String> d = new MyDeque<String>();

	d.addFirst("bruh");
	d.addFirst("bro");
	print(d);
	d.addLast("fishsticks");
	d.addLast("goldfish");
	d.addLast("space mermaids");
	d.addLast("souls");
	d.addLast("oprah");
	d.addLast("please wrap");
	print(d);
    }

    public static void print(Object o){
	System.out.println(o);
    }

}
