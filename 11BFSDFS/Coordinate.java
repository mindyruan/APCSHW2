public class Coordinate{

    private int x,y;
    private Coordinate previous;

    public Coordinate(int n, int m){
	x = n;
	y = m;
    }

    public Coordinate(int n, int m, Coordinate p){
	x = n;
	y = m;
	previous = p;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public void setX(int n){
	x = n;
    }

    public void setY(int m){
	y = m;
    }

    public boolean hasPrev(){
	if (previous != null){
	    return true;
	}
	return false;
    }

    public Coordinate getPrev(){
	if (hasPrev()){
	    return previous;
	}
	return null;
    }

    public void setPrev(Coordinate s){
	previous = s;
    }

    public String toString(){
	return "(" + x + "," + y + ")";
    }

}
