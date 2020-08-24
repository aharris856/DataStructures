//binary search tree of data type int, initialized with array of ints
//can be reworked for data type String or any data type using a node class of type T
//i.e. BSTNode<T>
import java.util.*;
////////////////////////////////////////////////
//BST Tree node class
class Node{
	Node left;
	Node right;
	int data;
	public Node(int d, Node l, Node r)
	{
		data = d;
		left = l;
		right = r;
	}
}
///////////////////////////////////////////////////
public class BSTree{

	//variable initializations
	private Node root;//root node of data type T
	private int count;
	private boolean dupe = false;
	//tree constructor
	public BSTree( int[] arr )
	{
		root = null;
		count = 0;
		for(int i = 0; i < arr.length; i++)
			add(arr[i]);
	}
	public int size()
	{
		return count;
	}

	//add int data to tree
	public boolean add(int data)
	{
		dupe = false;
		//if root = null, add input as first node
		if( this.root == null ){
			root = new Node(data, null, null);
			count++;
			return true;
		}
		//root =/= null, call addhelper to add input 
		addHelper( this.root, data );
		if(dupe)return false;
		count++;
		return true;
	}
	//add helper easier with recursion (imo)
	private void addHelper( Node root, int data)
	{
		//if data < root go left
		if(data < root.data){
			//if left is null append to left, else keep going till at a leaf
			if(root.left==null) root.left = new Node(data, null, null);
			else addHelper( root.left, data );

		}
		//data > root go right
		if(data > root.data){
			//if right is null append to right, else keep going till at a leaf
			if(root.right == null) root.right = new Node(data, null, null);
			else addHelper(root.right, data);

		}
		if(data == root.data) dupe = true;
	}
	//contains
	public boolean contains(int data)
	{
		Node curr = root;
		while(curr!=null)
		{
			if(data == curr.data) return true;
			else if(data < curr.data) curr = curr.left;
			else if(data > curr.data) curr = curr.right;
		}
		return false;
	}
/////////print traversals //////////////////////////////////////////////////////
	//print IN ORDER Traversal
	public void printInOrder()
	{
		inOrderHelper(this.root);
		System.out.println();
	}
	private void inOrderHelper( Node root )
	{
		if(root == null )return;
		inOrderHelper(root.left);
		System.out.print(root.data+" -> ");
		inOrderHelper(root.right);
	}

	//print in PRE ORDER Traversal
	public void printPreOrder()
	{
		preHelper(this.root);
		System.out.println();
	}
	public void preHelper(Node root)
	{
		if(root == null)return;
		System.out.print(root.data+" -> ");
		preHelper(root.left);
		preHelper(root.right);
	}
	//print in POST ORDER Travesal
	public void printPostOrder()
	{
		postHelper(this.root);
		System.out.println();
	}
	public void postHelper(Node root)
	{
		if(root == null)return;
		postHelper(root.left);
		postHelper(root.right);
		System.out.print(root.data+" -> ");
	}
	//print level order
	public void printLevelOrder()
	{
		int h = countLevels();
		for(int i = 1; i <= h; i++)
		{
			levelHelper(root,i);
			System.out.println();
		}
	}
	public void levelHelper(Node root, int level)
	{
		if(root == null)return;
		if(level == 1)System.out.print(root.data+" , ");
		else if(level > 1){
			levelHelper(root.left, level-1);
			levelHelper(root.right,level-1);
		}
	}

	//level counter
	public int countLevels()
	{
		return countHelper(root);
	}
	private int countHelper(Node root)
	{
		if(root==null)return 0;
		return 1+Math.max(countHelper(root.left),countHelper(root.right));
	}

}