import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private String clear =  "\033[2J";
    private String hide =  "\033[?25l";
    private String show =  "\033[?25h";

    private MyDeque<Coordinate> frontier = new MyDeque<Coordinate>();
    //private ArrayList<Coordinate> track;

    public Maze(String filename){
	startx = -1;
	starty = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    //calculate width of the maze
		    maxx = line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	//copy from the single string to a 2D array
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
		//System.out.println("start: ("+startx+","+starty+")");
	    }
	}
    }

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    

    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(clear);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	for(int i = 0; i < maxx * maxy; i++){
	    if(i % maxx == 0 && i != 0){
		ans += "\n";
	    }

	    ans += maze[i % maxx][i /maxx];
	    /*
	    char c =  maze[i % maxx][i / maxx];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(32,40)+c;
	    }
	    */
	}
	return hide + go(0,0) + ans + "\n" + show + color(37,40);
    }
    
    public boolean solveDFS(){ //the original solve
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    maze[startx][starty] = ' ';
	    return solveDFS(startx,starty);
	}
    }

    public boolean solveDFS(int x,int y){
	System.out.println(this);
	wait(20);
	if(maze[x][y] == 'E'){
	    return true;
	}
	if(maze[x][y] == ' '){
	    //mark the floor with @
	    maze[x][y] = '@';
	    //recursion ho!!
	    if( solveDFS(x + 1, y) || solveDFS( x, y + 1) ||
		solveDFS(x - 1, y) || solveDFS(x, y - 1)){
		return true;
	    }
	    //replace the @ with a .
	    maze[x][y] = '.';
	}
	return false;//by default the maze didn't get solved
    }

    public boolean solveBFS(){
	if(startx < 0){
	    System.out.println("No starting point 'S' found in maze.");
	    return false;
	}else{
	    //maze[startx][starty] = ' ';
	    System.out.println("start: "+startx+","+starty);
	    return solveBFS(startx,starty);
	}
    }

    /*
    public boolean solveBFS(int x,int y){
	System.out.println(this);
	wait(20);

	char now = maze[x][y];
	System.out.println(now);
	if (now == 'E'){
	    return true;
	}else if (now == 'x' || now == '#'){
	    return false; //invalid move
	}
	maze[x][y] = 'x'; //been here
	if (y < maxy-1){
	    frontier.addFirst(new Coordinate(x,y+1));
	}
	if (x > 0){
	    frontier.addFirst(new Coordinate(x-1,y));
	}
	if (x < maxx-1){
	    frontier.addFirst(new Coordinate(x+1,y));
	}
	if (y > 0){
	    frontier.addFirst(new Coordinate(x,y-1));
	}
	Coordinate c = frontier.removeLast();
	return solveBFS(c.getX(),c.getY());
    }
    */

    
    public boolean solveBFS(int x,int y){
	System.out.println(this);
	wait(20);

	frontier.addLast(new Coordinate(x,y,null));
	Coordinate now = frontier.getFirst();
	//System.out.println(now);

	while (maze[now.getX()][now.getY()]!='E'){
	System.out.println(this);
	wait(50);
	    now = frontier.removeFirst();
	    //System.out.println(now);
	
	    //System.out.println(now);
	    if (maze[now.getX()][now.getY()]!='E'){
		int n = now.getX();
		int m = now.getY();
		maze[n][m] = '*';
		if (maze[n+1][m] == ' ' || maze[n+1][m] == 'E'){
		    frontier.addLast(new Coordinate(n+1,m,now));
		}
		if (maze[n-1][m] == ' ' || maze[n-1][m] == 'E'){
		    frontier.addLast(new Coordinate(n-1,m,now));
		}
		if (maze[n][m+1] == ' ' || maze[n][m+1] == 'E'){
		    frontier.addLast(new Coordinate(n,m+1,now));
		}
		if (maze[n][m-1] == ' ' || maze[n][m-1] == 'E'){
		    frontier.addLast(new Coordinate(n,m-1,now));
		}
	    }
	}
	if (maze[now.getX()][now.getY()] == 'E'){
	    return true;
	}
	return false;
    }
    
}
