public class LNode{

    private int value;
    private LNode next;

    public LNode(int val){
	value = val;
    }

    public void setValue(int val){
	value = val;
    }

    public int getValue(){
	return value;
    }

    public void setNext(LNode n){
	next = n;
    }

    public LNode getNext(){
	return next;
    }

}
