import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{

    private LNode<T> head,tail,current;
    private int size;

    // ITERATOR CLASS
    private class MLLIterator<T> implements Iterator<T>{

	private LNode<T> current;

	public MLLIterator(LNode<T> head){
	    current = head;
	}

	public boolean hasNext(){
	    return (current != null);
	}

	public void remove(){ //lol
	    throw new UnsupportedOperationException();
	}

	public T next(){
	    if (hasNext()){
		T ans = current.getValue();
		current = current.getNext();
		return ans;
	    }else{
		throw new NoSuchElementException();
	    }
	}

    } // end of iterator class

    //constructor
    public MyLinkedList(){
	head = new LNode<T>();
        tail = new LNode<T>();
	current = new LNode<T>();
	size = 0;
    }

    public Iterator<T> iterator(){
	return new MLLIterator<T>(head);
    }

    public String toString(){
	String ans = "[ ";
        current = head;
	for (int i = 0; i < size; i++){
	    ans += current.getValue() + ", ";
	    current = current.getNext();
	}
	//ans += "]";
	return (ans.substring(0,ans.length()-2) + " ]") ;
    }

    public boolean add(T val){
	LNode<T> temp = new LNode<T>(val);
	if (size == 0){
	    head = temp;
	    tail = head;
	    current = head;
	}else{
	    tail.setNext(temp);
	    tail = temp;
	    /*
	    current = head;
	    for (int i = 0; i < size-1; i++){
		current = current.getNext();
	    }
	    current.setNext(temp);
	    */
	}
	size++;
	return true; //always returns true unless index sucks
    }

    public boolean add(int index, T val){
	if (index < 0 || index >= size){
	    //index sucks
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> temp = new LNode<T>(val);

	if (index == 0){
	    temp.setNext(head);
	    head = temp;
	}else if (index == size()){
	    add(val);
	}else{
	    current = head;
	    for (int i = 0; i < index-1; i++){
		current = current.getNext();
	    }
	    LNode<T> temp2 = current.getNext();
	    current.setNext(temp);
	    temp.setNext(temp2);
	}

	/*
	current = head;
	for (int i = 0; i < index-1; i++){
	    current = current.getNext();
	}
	LNode temp2 = current.getNext();
	current.setNext(temp);
	temp.setNext(temp2);
	*/
	size++;
	return true;
    }

    public void set(int index, T val){
	if (index < 0 || index >= size){
	    //index sucks
	    throw new IndexOutOfBoundsException();
	}
	current = head;
	//keep goin til ya get there
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	current.setValue(val);
    }

    public T get(int index){
	if (index < 0 || index >= size){
	    //index sucks
	    throw new IndexOutOfBoundsException();
	}
	current = head;
	//keep goin til ya get there
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	return current.getValue();
    }

    public int indexOf(T val){
	current = head;
	for (int i = 0; i < size; i++){
	    if (current.getValue().equals(val)){
		return i;
	    }else{
		current = current.getNext();
	    }
	}
	//nope
	return -1;
    }

    public T remove(int index){
	if (index < 0 || index >= size){
	    //index sucks
	    throw new IndexOutOfBoundsException();
	}

	LNode<T> dead;
	if (index == 0){
	    dead = head;
	    head = dead.getNext();
	}else if (index == size()-1){
	    current = head;
	    for (int i = 0; i < size()-2; i++){
		current = current.getNext();
	    }
	    dead = tail;
	    tail = current;
	}else{
	    current = head;
	    for (int i = 0; i < index-1; i++){
		current = current.getNext();
	    }
	    dead = current.getNext();
	    current.setNext(dead.getNext()); //skip over dead
	}
	size--;
	return dead.getValue();

	/*
	current = head;
	for (int i = 0; i < index-1; i++){
	    current = current.getNext();
	}
	//System.out.println(current.getValue());
	LNode dead = current.getNext();

	//System.out.println(dead.getValue());

	current.setNext(dead.getNext());
	size--;
	return dead.getValue();
	*/
    }

    public int size(){
	return size;
    }

    public void clear(){
	size = 0;
    }

    public String name(){
	return "ruan.mindy";
    }


    public static void main(String[]arg){
	
	MyLinkedList<Integer> l = new MyLinkedList<Integer>();

	l.add(3);
	System.out.println(l);

	l.add(4);
	l.add(7);
	l.add(89);
	l.add(-1);
	l.add(0);
	System.out.println(l);

	System.out.println("index 0: " + l.get(0));
	System.out.println("index 1: " + l.get(1));
	System.out.println("index 3: " + l.get(3));

	l.set(4,666);
	System.out.println(l);
	System.out.println("found 666: " + l.indexOf(666));

	System.out.println("destroyed index 5: " + l.remove(5));
	System.out.println(l);

	System.out.println("added 6 at index 2: " + l.add(2,6));
	System.out.println(l);
	

    }

}
