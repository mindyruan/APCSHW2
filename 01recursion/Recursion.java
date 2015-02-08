public class Recursion{

    public static void main(String[]args){
	Recursion r = new Recursion();
	
	/*
	System.out.println(r.fact(0));
	System.out.println(r.fact(1));
	System.out.println(r.fact(4));
	System.out.println(r.fact(5));
	System.out.println(r.fact(11));
	*/
	
    }

    public String name(){
	return "Ruan,Mindy";
    }

    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if ((n == 1) || (n == 0)){
	    return n;
	}
	return n * fact(n-1);
    }

}
