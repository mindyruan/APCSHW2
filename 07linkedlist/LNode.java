public class LNode<T>{

    private T value;
    private LNode<T> next;

    public LNode(){
    
    }

    public LNode(T val){
	value = val;
    }

    public void setValue(T val){
	value = val;
    }

    public T getValue(){
	return value;
    }

    public void setNext(LNode<T> n){
	next = n;
    }

    public LNode<T> getNext(){
	return next;
    }

}
