import java.util.*;

public class QuickSelect{

    public static int select(int[]arr, int n){
	return partition(arr,n,0,arr.length-1);
    }

    public static int partition(int[]arr, int n, int si, int ei){
	int[]d = new int[arr.length];
	/*
	for (int i = 0; i < arr.length; i++){
	    if (i < si || i > ei){
		d[i] = arr[i];
	    }
	}
	*/
	int start = si;
	int end = ei;
	int ri = si +(int)(Math.random()*(ei-si+1));
	int pivot = arr[ri];

	//System.out.println("pivot= " + pivot);

	for (int i = si; i <= ei; i++){
	    if (arr[i] < pivot){
		d[start] = arr[i];
		start++;
	    }else if (arr[i] > pivot){
		d[end] = arr[i];
		end--;
	    }
	}

	d[start] = pivot;

	for (int i = si-1; i >= 0; i--){
	    d[i] = arr[i];
	}
	for (int i = ei+1; i < arr.length; i++){
	    d[i] = arr[i];
	}

	//System.out.println(Arrays.toString(d));

	if (start == n-1){
	    return d[start];
	}else if (start < n-1){
	    return partition(d,n,start,ei);
	}else{
	    return partition(d,n,si,start);
	}

    }

    public static void main(String[]arg){
	int[]a = new int[30];
	Random r = new Random();
	for (int i = 0; i < a.length; i++){
	    a[i] = i;
	}
	for (int i = 0; i < a.length; i++){
	    int n = a[i];
	    int ind = r.nextInt(a.length-1);
	    a[i] = a[ind];
	    a[ind] = n;
	}
	System.out.println(Arrays.toString(a));
	System.out.println();
	//partition(a,0,a.length-1);
	System.out.println(select(a,11));
    }


    //thank you beyonce for helping me maintain my sanity

}
