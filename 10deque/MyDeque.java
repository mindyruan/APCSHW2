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

    }

    public void addLast(T val){

    }

    public void removeFirst(){ //T

    }

    public void removeLast(){ //T

    }

    public void getFirst(){ //T

    }

    public void getLast(){ //T

    }

    public String toString(){
	String ans = "[ ";
	return ans;
    }

    public static void main(String[]args){
	MyDeque<String> d = new MyDeque<String>();
    }

}
