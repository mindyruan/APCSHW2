import java.util.*;
import java.io.*;


public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private char[][]board;


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

	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board.length; j++){
		ans += "  " + board[i][j];
	    }
	    ans += "\n";
	}

	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public String name(){
	return "ruan.mindy";
    }

    public NQueens(int size){
	board = new char[size][size];
	for (int i = 0; i < size; i++){
	    for (int j = 0; j < size; j++){
		board[i][j] = '_';
	    }
	}
    }

    public boolean solve(){
        return solve(0,0);
    }

    public boolean solve(int x){
	return solve(x,0);
    }

    public boolean solve(int x,int y){

	System.out.println(this);
	wait(20);
	System.out.println(""+x+" "+y);	

	if (y >= board.length){
	    //System.out.print(this);
	    return true;
	}

	for (int i = 0; i < board.length; i++){
	    if (check(i,y)){
		board[i][y] = 'Q';
		if (solve(x,y+1)){
		    return true;
		}
		board[i][y] = '_';
	    }
	}
	return false;

    }

    public boolean check(int x, int y){
	int i,j;
        //across
	for (i = 0; i < y; i++){
	    if (board[x][i] == 'Q'){
		return false;
	    }
	}
	//up-left
	for (i = x, j = y; (i >= 0) && (j >= 0); i--, j--){
	    if (board[i][j] == 'Q'){
		return false;
	    }
	}
	//down-left
	for (i = x, j = y; (i < board.length) && (j >= 0); i++, j--){
	    if (board[i][j] == 'Q'){
		return false;
	    }
	}
	return true;
    }
    
    public static void main(String[]args){
	NQueens q = new NQueens(Integer.parseInt(args[0]));
	System.out.println(q.solve());
	System.out.println(q);
    }
    
}
