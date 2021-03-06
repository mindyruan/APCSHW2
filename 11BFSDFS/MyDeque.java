import java.util.*;

public class MyDeque<T>{

    private Object[]deque;
    private int[]priority;
    private int head,tail,size;
    private boolean debug = false;
    //private boolean debug = true;

    public MyDeque(){
	deque = new Object[10];
	priority = new int[10];
	head = 5;
	tail = 4;
	size = 0;
    }

    public void addFirst(T val){
	//resize if full
	if (size == deque.length){
	    resize();
	}

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
	//resize if full
	if (size == deque.length){
	    resize();
	    //System.out.println("head: "+head+"  tail: "+tail);
	}

	tail++;
	if (tail == deque.length){
	    //wrap to the beginning
	    tail = 0;
	}
	deque[tail] = val;
	size++;
    }

    public void add(T val, int p){
	//resize if full
	if (size == deque.length){
	    resize();
	    //System.out.println("head: "+head+"  tail: "+tail);
	}

	tail++;
	if (tail == deque.length){
	    //wrap to the beginning
	    tail = 0;
	}
	deque[tail] = val;
	priority[tail] = p;
	size++;
    }

    public T removeFirst(){ //T
	if (size == 0){
	    throw new NoSuchElementException();
	}

	T ans = (T)deque[head];
	deque[head] = null;
	head++;
	size--;
	if (head == deque.length){
	    //wrap to the beginning
	    head = 0;
	}
	return ans;
    }

    public T removeLast(){ //T
	if (size == 0){
	    throw new NoSuchElementException();
	}

	T ans = (T)deque[tail];
	deque[tail] = null;
	tail--;
	size--;
	if(tail == -1){
	    //wrap to the end
	    tail = deque.length - 1;
	}       
	return ans;
    }

    public T removeSmallest(){
	int min = priority[head];
	int index = head;
	if (head <= tail){
	    for (int i = head; i < tail; i++){
		if (min > priority[i]){
		    min = priority[i];
		    index = i;
		}
	    }
	}else{
	    for (int i = head; i < deque.length; i++){
		if (min > priority[i]){
		    min = priority[i];
		    index = i;
		}
	    }
	    for (int i = 0; i <= tail; i++){
		if (min > priority[i]){
		    min = priority[i];
		    index = i;
		}
	    }
	}
	//System.out.println(index+" "+deque[index]+" "+priority[index]);
	T rem = (T)deque[index];
	//System.out.println(rem);
	if (index < tail){
	    for (int i = index; i < tail; i++){
		deque[i] = deque[i+1];
		priority[i] = priority[i+1];
	    }
	}else{
	    for (int i = index; i < deque.length-1; i++){
		deque[i] = deque[i+1];
		priority[i] = priority[i+1];
	    }
	    deque[deque.length-1] = deque[0];
	    priority[priority.length-1] = priority[0];
	    for (int i = 0; i <= tail; i++){
		deque[i] = deque[i+1];
		priority[i] = priority[i+1];
	    }
	}
	tail--;
	//head++;
	return rem;
    }

    public T removeLargest(){
	int max = priority[head];
	int index = head;
	if (head <= tail){
	    for (int i = head; i < tail; i++){
		if (max < priority[i]){
		    max = priority[i];
		    index = i;
		}
	    }
	}else{
	    for (int i = head; i < deque.length; i++){
		if (max < priority[i]){
		    max = priority[i];
		    index = i;
		}
	    }
	    for (int i = 0; i <= tail; i++){
		if (max < priority[i]){
		    max = priority[i];
		    index = i;
		}
	    }
	}
	System.out.println(index+" "+deque[index]+" "+priority[index]);
	T rem = (T)deque[index];
	//System.out.println(rem);
	if (index < tail){
	    for (int i = index; i < tail; i++){
		deque[i] = deque[i+1];
		priority[i] = priority[i+1];
	    }
	}else{
	    for (int i = index; i < deque.length-1; i++){
		deque[i] = deque[i+1];
		priority[i] = priority[i+1];
	    }
	    deque[deque.length-1] = deque[0];
	    priority[priority.length-1] = priority[0];
	    for (int i = 0; i <= tail; i++){
		deque[i] = deque[i+1];
		priority[i] = priority[i+1];
	    }
	}
	tail--;
	//head++;
	return rem;
    }

    public T getFirst(){ //T
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return (T)deque[head];
    }

    public T getLast(){ //T
	if (size == 0){
	    throw new NoSuchElementException();
	}
	return (T)deque[tail];
    }
    
    public void resize(){
	Object[] ans = new Object[deque.length*2];
	//System.out.println("head: "+head+"  tail: "+tail);
	int newTail = 0;
	if (head <= tail){
	    //copy over
	    for (int i = 0; i <= tail; i++){
		ans[i] = deque[i];
	    }
	}else{
	    for (int i = head; i < deque.length; i++){
		//System.out.println(deque[i]);
		ans[i] = deque[i];
	    }
	    for (int i = 0; i <= tail; i++){
		ans[deque.length+i] = deque[i];
		newTail = deque.length+i;
	    }
	}
	//replace
	deque = ans;
	tail = newTail;
	//System.out.println(deque.length);
    }
    
    public String toString(){
	String ans = "[ ";
	if (debug){
	    for (int i = 0; i < deque.length; i++){
		ans += deque[i] + ", ";
	    }
	}else{
	    if (head <= tail){
		for (int i = head; i <= tail; i++){
		    ans += deque[i] + ", ";
		}
	    }else{
		for (int i = head; i < deque.length; i++){
		    ans += deque[i] + ", ";
		}
		for (int i = 0; i <= tail; i++){
		    ans += deque[i] + ", ";
		}
	    }
	}
	return ans.substring(0,ans.length()-2) + " ]";
    }

    public String toStringP(){
	String ans = "[ ";
	if (debug){
	    for (int i = 0; i < deque.length; i++){
		ans += priority[i] + ", ";
	    }
	}else{
	    if (head <= tail){
		for (int i = head; i <= tail; i++){
		    ans += priority[i] + ", ";
		}
	    }else{
		for (int i = head; i < deque.length; i++){
		    ans += priority[i] + ", ";
		}
		for (int i = 0; i <= tail; i++){
		    ans += priority[i] + ", ";
		}
	    }
	}
	return ans.substring(0,ans.length()-2) + " ]";
    }

    public static void main(String[]args){
	MyDeque<String> d = new MyDeque<String>();

	d.add("oprah",5);
	d.add("turn up for dogs",10);
	d.add("space mermaids",8);
	d.add("my life",1);
	d.add("shaq",3);
	d.add("shakira shakira",6);
	print(d);
	print(d.toStringP());

	d.removeSmallest();
	print(d);
	print(d.toStringP());

	d.removeLargest();
	print(d);
	print(d.toStringP());

	/*
	d.addFirst("bruh");
	d.addFirst("bro");
	//print(d);
	d.addLast("fishsticks");
	d.addLast("goldfish");
	d.addLast("space mermaids");
	d.addLast("souls");
	d.addLast("oprah");
	d.addLast("please wrap");
	d.removeFirst();
	//print(d);
	//d.removeLast();
	//d.removeLast();
	d.addLast("hhhh");
	d.addFirst("shaquille o'neal");
	d.addFirst("shakira shakira");
	print(d);
	d.addLast("pitbull: dale");
	print(d);
	print(d.getFirst());
	print(d.getLast());
	*/
    }

    public static void print(Object o){
	System.out.println(o);
    }

}
