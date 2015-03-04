/*

public class CTravel{

    private char[][]pasture = {{'.' ,'.' ,'.' ,'*' ,'.'},
			     {'.' ,'.' ,'.' ,'*' ,'.'},
			     {'.' ,'.' ,'.' ,'.' ,'.'},
			     {'.' ,'.' ,'.' ,'.' ,'.'}};
    private int time,r1,c1,r2,c2,numWays;

    public CTravel(){
        r1 = 1;
	c1 = 3;
	r2 = 1;
	c2 = 5;
	numWays = 0;
	time = 6;
    }

    public int solve(){
	return(solve(r1,c1,0));
    }

    public int solve(int row, int col, int sec){
	//bad things
	if (row<0 || col<0 || row>= pasture.length || col>=pasture[0].length){
	    return 0; //out of bounds
	}
	if (sec==0 && row==r2 && col==c2){
	    numWays++; 
	    return 1;
	}
	if (pasture[row][col] == '*' || sec == 0){
	    return 0; //ran out of time or hit a tree!!!
	}
return solve(row+1,col,sec-1) + solve(row-1,col,sec-1) + solve(row,col+1,sec-1) + solve(row,col-1,sec-1);
    }

    public String toString(){
	String ans = "";
	for (int i = 0; i < pasture.length; i++){
	    for (int j = 0; j < pasture[0].length; j++){
		ans += pasture[i][j] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String[]args){
	CTravel c = new CTravel();
	System.out.println(c);
	System.out.println(c.solve());
    }

}

*/
