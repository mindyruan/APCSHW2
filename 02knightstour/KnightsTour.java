import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;


    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		String val = ""+board[i][j];
	        if (val.length()==1){
		ans += "   ";
		}else if(val.length()==2){
		    ans += "  ";
		}
		ans += val;
	    }
	    ans += "\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public String name(){
	return "ruan.mindy";
    }

    public KnightsTour(int size){
	board = new int[size][size];
    }

    
    public boolean solve(){
        return solve(0,0);		
    }

    public boolean solve(int startx, int starty){
        return solve(startx, starty, 1);		
    }
		
    public boolean solve(int x,int y,int currentMoveNumber){
	
	System.out.println(this);
	wait(20);
	System.out.println(""+x+" "+y);

	if ( x < 0 || x >= board.length ||
	     y < 0 || y >= board.length ){
	    return false;
	}
	if (board[x][y] != 0){
	    return false; //spot already taken
	}
	board[x][y] = currentMoveNumber;

	if (currentMoveNumber == (board.length * board.length)){
	    return true; //board is filled
	}

	//board[x][y] = currentMoveNumber;

	//test 8 possibilities
	if ( solve( x-2, y-1, currentMoveNumber + 1 ) ||
	     solve( x-2, y+1, currentMoveNumber + 1 ) ||
	     solve( x-1, y+2, currentMoveNumber + 1 ) ||
	     solve( x+1, y+2, currentMoveNumber + 1 ) ||
	     solve( x+2, y+1, currentMoveNumber + 1 ) ||
	     solve( x+2, y-1, currentMoveNumber + 1 ) ||
	     solve( x+1, y-2, currentMoveNumber + 1 ) ||
	     solve( x-1, y-2, currentMoveNumber + 1 )){
	    return true;
	}

	board[x][y] = 0; //reset				
	return false;
    }

    
    public static void main(String[]args){
	KnightsTour k = new KnightsTour(Integer.parseInt(args[0]));
	k.solve();
	System.out.println(k);
	/*
	KnightsTour k = new KnightsTour(1);
	KnightsTour l = new KnightsTour(2);
	KnightsTour m = new KnightsTour(3);
	KnightsTour n = new KnightsTour(4);
	KnightsTour o = new KnightsTour(5);
	KnightsTour p = new KnightsTour(6);
	//KnightsTour q = new KnightsTour(7);
	//KnightsTour r = new KnightsTour(8);
	System.out.println(k.solve());
	System.out.println(k);

	System.out.println(l.solve());
	System.out.println(l);

	System.out.println(m.solve());
	System.out.println(m);

	System.out.println(n.solve());
	System.out.println(n);

	System.out.println(o.solve());
	System.out.println(o);

	System.out.println(p.solve());
	System.out.println(p);
    */
    }

}
