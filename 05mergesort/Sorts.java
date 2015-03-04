import java.util.*;

public class Sorts{

    public static void mergesort(int[]arr){
	/*
        int[] group1 = Arrays.copyOfRange(arr,0,arr.length/2); //copy half
	int[] group2 = Arrays.copyOfRange(arr,arr.length/2,arr.length); //other half
	*/
	//System.out.println(merge(group1, group2));

	int[]done = new int[arr.length];
	done = sort(arr);
	for (int i = 0; i < arr.length; i++){
	    arr[i] = done[i]; //replace the old array
	}

    }

    public static int[] merge(int[]alpha, int[]beta){
	/*
	  System.out.println("ALPHA:");
	  for (int i = 0; i < alpha.length; i++){
	  System.out.println(alpha[i]);
	  }
	  System.out.println("\nBETA:");
	  for (int i = 0; i < beta.length; i++){
	  System.out.println(beta[i]);
	  }
	*/
	int a=0,b=0,c=0;

	int[]combined = new int[alpha.length+beta.length];

	while (a < alpha.length && b < beta.length){
	    if (alpha[a] > beta[b]){
		combined[c] = beta[b]; //take the smaller one
		b++;
	    }else{
		combined[c] = alpha[a];
		a++;
	    }
	    c++;
	}
	while (a < alpha.length){
	    combined[c] = alpha[a];
	    a++;
	    c++;
	}
	while (b < beta.length){
	    combined[c] = beta[b];
	    b++;
	    c++;
	}
        return combined;
    }

    public static int[] sort(int[]arr){
        if (arr.length < 2){
	    return arr;
	}
	int[] group1 = Arrays.copyOfRange(arr,0,arr.length/2); //copy half
	int[] group2 = Arrays.copyOfRange(arr,arr.length/2,arr.length); //other half

	group1 = sort(group1);
	group2 = sort(group2);

	return merge(group1,group2);
        
    }

    public static void main(String[]args){
	int[] a = new int[100];
	Random r = new Random();
	for (int i = 0; i < a.length; i++){
	    a[i] = r.nextInt(100000);
	}
	int[] b = {9000000, 129783, 213,1,-1341,-1321,-9000,10939,12};
	mergesort(a);
	for (int i = 0; i < a.length; i++){
	    System.out.print(a[i] + " ");
	}
    }

}
