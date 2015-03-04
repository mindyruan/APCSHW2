import java.util.*;

public class MakeLake{

    private int pasX, pasY;
    private int[][]pasture = {{28, 25, 20, 32, 34, 36},
			      {27, 25, 20, 20, 30, 34},
			      {24, 20, 20, 20, 20, 30},
			      {20, 20, 14, 14, 20, 20}};

    public MakeLake(int x, int y){
	pasX = x;
	pasY = y;
    }

    public void stomp(int x, int y, int stomps){
	int high = 0;
	x--;
	y--;
	//find biggest value
	for (int i = x; i < x+3; i++){
	    for (int j = y; j < y+3; j++){
		if (pasture[i][j] > high){
		    high = pasture[i][j];
		}
	    }
	}

	for (int i = x; i < x+3; i++){
	    for (int j = y; j < y+3; j++){
		int done = high - pasture[i][j];
		if (done < stomps){
		    pasture[i][j] -= stomps - done;
		}
	    }
	}

    }

    public int depth(int elev){
	return 0;
    }

    public int volume(){
	return 72*72*depth(22);
    }

    public String toString(){
	String ans = "";
	for (int i = 0; i < pasX; i++){
	    for (int j = 0; j < pasY; j++){
		ans += pasture[i][j] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[]args){
	MakeLake m = new MakeLake(4,6);
	m.stomp(1,4,4);
	m.stomp(1,1,10);
	System.out.println(m);
	System.out.println("depth= " + m.depth(22));
	System.out.println("volume= " + m.volume());
    }


}
