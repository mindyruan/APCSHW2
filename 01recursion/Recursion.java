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
	
	/*SQRT TESTS
	System.out.println(r.sqrt(0));
	System.out.println(r.sqrt(1));
	System.out.println(r.sqrt(25));
	System.out.println(r.sqrt(100));
	System.out.println(r.sqrt(4000));
	System.out.println(r.sqrt(.04));
	System.out.println(r.sqrt(.00000001));
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

    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n == 0){
	    return 0.0;
	}
	return sqrtHelp(n,1);
    }

    public double sqrtHelp(double num, double guess){
	if(Math.abs((num - guess*guess)/num) < 0.00001){
	    return guess;
	}
	return sqrtHelp(num,((num/guess + guess)/2));
    }

}
