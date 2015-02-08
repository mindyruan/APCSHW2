public class Recursion{

    public static void main(String[]args){
	Recursion r = new Recursion();
	
	/*FACTORIAL TESTS
	System.out.println(r.fact(0));
	System.out.println(r.fact(1));
	System.out.println(r.fact(4));
	System.out.println(r.fact(11));
	*/

	/*FIBONACCI TESTS
	System.out.println(r.fib(0));
	System.out.println(r.fib(1));
	System.out.println(r.fib(2));
	System.out.println(r.fib(4));
	System.out.println(r.fib(11));
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

    public int fib(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if ((n == 1) || (n == 0)){
	    return n;
	}
	return fib(n-1) + fib(n-2);
    }

}
