import java.io.*;
import java.util.*;

public class TreeNode<E>{

    private E data;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(){
	//constructor
    }

    public TreeNode(E val){
	data = val;
    }

    public E getData(){
	return data;
    }

    public TreeNode<E> getLeft(){
	return left;
    }

    public TreeNode<E> getRight(){
	return right;
    }

    public void setData(E val){
	data = val;
    }

    public void setLeft(TreeNode<E> l){
	left = l;
    }

    public void setRight(TreeNode<E> r){
	right = r;
    }

}