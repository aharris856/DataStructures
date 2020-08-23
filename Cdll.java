//Cricular Doubly Linked List
public class Cdll{
	///////////////////////////////////////////////
	//LL Node Constructor class
	class Node{
		Node next;
		Node prev;
		int data;
	}
	//////////////////////////////////////////////////////
	Node curr;

	//insert at the end of circular list
	public void insertAtEnd(int data)
	{
		//empty list, initialize as current data input
		if(curr == null)
		{
			Node newNode = new Node();
			newNode.data = data;
			newNode.next = newNode;
			newNode.prev = newNode;
			curr = newNode;
			return;
		}

		//get the value of final node to hold
		Node finalNode = curr.prev;
		//create node to be inserted
		Node newNode = new Node();
		newNode.data = data;

		//make current head prev point to new node
		//make new node prev poitn to final node
		//make final node point to new node
		curr.prev = newNode;
		newNode.prev = finalNode;
		finalNode.next = newNode;
	}

	//insert at the start of the list
	public void insertAtFront(int data)
	{
		Node finalNode = curr.prev;

		//new node to insert
		Node newNode = new Node();
		newNode.data = data;

		//make new node point to first node
		//make the new node prev point to final node
		//make last node point to the previous first node
		//make the old first node prev point to the new node
		newNode.next = curr;
		newNode.prev = finalNode;
		finalNode.next = newNode;
		curr.prev = newNode;

		curr = newNode;
	}

	//insert data in new node after node with val
	public void insertAfter(int data, int val)
	{
		//node to be inserted
		Node newNode = new Node();

		newNode.data = data;

		//find location of node with val
		Node hold = curr;

		if(!contains(val))return;

		while(hold.data!=val)
			hold = hold.next;
		Node nextNode = hold.next;

		//make node with val point to new node and new node point to next
		hold.next = newNode;
		newNode.prev = hold;
		newNode.next = nextNode;
		nextNode.prev = newNode;
	}
	//remove given node
	public void remove(int data)
	{
		//base cases
		if(curr == null)return;
		if(!contains(data))return;
		
		Node prevNode = curr.prev; 
		Node hold = curr;

		while(hold!=null)
		{
			//if data to remove is hold remove and return
			if(hold.data == data){
				//prev node point to hold.next
				//hold.next point prev to prev node
				prevNode.next = hold.next;
				hold.next.prev = prevNode;
				return;
			}
			prevNode = hold;
			hold = hold.next;
		}

	}
	//check if cdll contains data input
	public boolean contains(int data)
	{
		//check final case
		Node finalNode = curr.prev;
		if(finalNode.data == data)return true;

		Node hold = curr;
		while(hold!=finalNode)
		{
			if(hold.data == data)return true;
			hold = hold.next;
		}
		return false;
	}
	//return size
	public int size()
	{
		if(curr == null)return 0;

		int counter = 1;
		Node finalNode = curr.prev;
		while(curr!=finalNode)
		{
			curr = curr.next;
			counter++;
		}
		return counter;
	}
	//print list
	public void print()
	{
		Node hold = curr;
		System.out.println("List Traversed Forwards");
		while(hold.next != curr)
		{
			System.out.print(hold.data+" -> ");
			hold = hold.next;
		}
		System.out.println(hold.data);
		System.out.println("List Traversed Backwards");
		Node finalNode = curr.prev;
		hold = finalNode;
		while(hold.prev!=finalNode)
		{
			System.out.print(hold.data+" <- ");
			hold = hold.prev;
		}
		System.out.println(hold.data);

	}
}