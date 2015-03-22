import java.util.*;

public class MyStack<T>{

    private MyLinkedList<T> stack;

    public MyStack(){
	stack = new MyLinkedList<T>();
    }

    public String name(){
	return "ruan.mindy";
    }

    public void push(T val){ //add to end
        stack.add(val);
    }

    public T pop(){ //remove last element
	if (empty()){
	    throw new EmptyStackException();
	}
	return stack.remove(stack.size()-1);
    }

    public T peek(){ //get last
	if (empty()){
	    throw new EmptyStackException();
	}
	return stack.get(stack.size()-1);
    }

    public boolean empty(){
	return stack.size() == 0;
    }

    public String toString(){
	return stack.toString();
    }

    public static void main(String[]arg){
	MyStack<String> s = new MyStack<String>();

	s.push("a");
	s.push("fish");
	s.push("bruh");
	s.push("ech");
	System.out.println(s);

	System.out.println(s.peek());
	s.pop();
	System.out.println(s);
	System.out.println(s.peek());
	s.pop();
	System.out.println(s);
	System.out.println(s.peek());


    }

}
