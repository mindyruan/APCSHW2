import java.util.*;

public class QuickSelect{

    public static int[] array;

    public static int select(int[]arr, int n){
	//return partition(arr,n,0,arr.length-1);
	array = arr;
	int start = 0;
	int end = arr.length-1;
	int i = partition(array,start,end);
	while (!(i == n)){
	    i = partition(array,start,end);
	    if (i > n){
		end = i-1;
	    }else if (i < n){
		start = i+1;
	    }
	}
	return array[i];
	//this used to be one line and now im sad dangit quicksort
    }
    /*
    public static int partition(int[]arr, int n, int si, int ei){
	int[]d = new int[arr.length];
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
*/

    public static int partition(int[]arr, int si, int ei){
	int start = si;
	int end = ei;
	int ri = si +(int)(Math.random()*(ei-si+1));
	int pivot = arr[ri];
	int pain = 0;

	arr[ri] = arr[start];
	arr[start] = pivot;
	//System.out.println("pivot: "+pivot);

	while (start+pain <= end){ //make sure index is okay!!!
	    if (arr[start+pain] < pivot){
		//pain++;
		int hold = arr[start+pain];
		arr[start+pain] = arr[start];
		arr[start] = hold;
		start++;
	    }else if (arr[start+pain] > pivot){
		//pain++;
		int hold = arr[end];
		arr[end] = arr[start+pain];
		arr[start+pain] = hold;
		end--;
	    }else if (arr[start+pain] == pivot){
		pain++;
	    }
	}

	array = arr;
	//System.out.println(Arrays.toString(arr);
	return end;
    }

    public static int[] quickSort(int[]arr){ //dreadful
	array = arr;
	helper(0,array.length-1,partition(arr,0,array.length-1));
	return array;
    }

    public static void helper(int si, int ei, int i){
	if (si>=ei || i+1 >= array.length){
	    return; //don't do anything bro
	}else{
	    helper(si,i-1,partition(array,si,i-1));
	    helper(i+1,ei,partition(array,i+1,ei));
	}
    }

    public static String name(){
	return "ruan.mindy";
    }

    public static void main(String[]arg){

	int[]bro = rand(-10000,10000,100);
	System.out.println(Arrays.toString(quickSort(bro)));
	/*
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
	partition(a,0,a.length-1);
	System.out.println(Arrays.toString(a));
	System.out.println(select(a,11));
	*/
	
    }

    public static int[] rand(int min, int max, int size){
	int[] arr = new int[size];
	Random r = new Random();
	for (int i = 0; i < size; i++){
	    arr[i] = r.nextInt(max-min+1) + min;
	}
	return arr;
    }


    //thank you beyonce for helping me maintain my sanity

}
