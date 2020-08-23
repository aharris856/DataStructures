//LL Class
public class LinkedList
{
	///////////////////////////////////////////////
	//LL Node Constructor class
	class Node{
		Node next;
		int data;

		Node(int input)
		{
			data = input;
			next = null;
		}
	}
	//////////////////////////////////////////////////////
	
	Node head;
	//insert data to ll
	public void insert(int data)
	{
		//initialize new node to be inserted
		Node newNode = new Node(data);
		newNode.next = null;

		//if list empty new node = first node
		if(this.head == null)this.head = newNode; 
		else{
			//go to the end of the list
			Node curr = this.head;
			while(curr.next!=null)
				curr = curr.next;
			//curr.next = null so append newNode
			curr.next = newNode;
		}
	}

	//check if list contains given data
	public boolean contains(int data)
	{
		Node curr = this.head;
		
		while(curr!=null){
			if(curr.data==data)return true;
			curr = curr.next;
		}
		return false;
	}

	//remove node with given data
	public void remove(int data)
	{
		Node curr = this.head;

		//base case
		if(curr.data == data)this.head = curr.next;
		//search through list and remove if node is = data
		while(curr.next!=null)
		{
			if(curr.next.data==data){
				curr.next = curr.next.next;
				return;
			}
			curr = curr.next;
		}
	}

	//size of list
	public int size()
	{
		int counter = 0;
		Node curr = this.head;
		while(curr!=null)
		{
			curr = curr.next;
			counter++;
		}
		return counter;
	}

	//print linkedlist
	public void print()
	{
		Node curr = this.head;

		//go through list and print as we go
		while(curr!=null)
		{
			System.out.print(curr.data+" -> ");
			curr = curr.next;
		}
		System.out.println("| end of list |");
	}

}