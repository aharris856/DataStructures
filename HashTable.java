//hash table class arraylist implementation
import java.util.ArrayList;
public class HashTable<K, V>{
////////////////////////////////////////////////////
	//hash table node class
	class Node<K, V>
	{
		K key;//hash key
		V val;//hash val
		//next node
		Node<K, V> next;
		//node constructor
		Node(K key, V val)
		{
			this.key = key;
			this.val = val;
		}
	}
//////////////////////////////////////////////////////
	//store input
	private ArrayList<Node<K, V>> container;
	private int containerSize;
	//size of arraylist
	private int size = 0;
	//constructor
	public HashTable(){
		container = new ArrayList<Node<K,V>>();
		containerSize = 10;
		//initialize empty chains
		for(int i = 0; i < containerSize; i++)
			container.add(null);
	}

	//get size of table
	public int size(){ return size; }

	//check if table is empty
	public boolean isEmpty(){ return (size() == 0); }

	//hashing index
	private int getHash(K key)
	{
		int hash = key.hashCode();//hash the key
		int index = Math.abs(hash%containerSize);//get positive val of the has mod container size
		return index;
	}

	//remove key
	public void remove(K key)
	{
		int index = getHash(key);
		//get head of the Node chain to increment
		Node<K, V> head = container.get( index );
		//increment
		Node<K, V> prev = null;
		while(head!=null)
		{
			//found key, leave loop
			if(head.key.equals(key))break;

			prev = head;
			head = head.next;
		}
		//key not found
		if(head == null)return;

		if(prev != null)prev.next = head.next;//if prev exists, have prev point to next of found val
		else container.set(index, head.next);//prev DNE >>> set container to point at next of head

		size--; //decrement size

		return;
	}

	//get key val
	public V get(K key)
	{
		//find start of Node chain to increment
		Node<K, V> head = container.get( getHash(key) );
		//increment
		while(head!=null)
		{
			if(head.key.equals(key))return head.val;
			head = head.next;
		}
		//key not found, return null
		return null;
	}
	//add key and val
	public void insert(K key, V val)
	{
		int index = getHash(key);
		//find start of Node chain to increment
		Node<K, V> head = container.get( index );
		//check if key exists already
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				head.val = val;
				return;
			}
			head = head.next;
		}

		
		head = container.get( index );
		//create new node to point at start of container at index
		Node<K, V> newNode = new Node<K,V>(key,val);
		newNode.next=head;
		container.set(index,newNode);
		//increment size 
		size++;
		//if input gets to 70% of the container max
		//double size of table
		if((1.0*size)/containerSize >= 0.7)doubleSize();
	}
	//double size of array
	private void doubleSize()
	{
		//temporary list to hold container
		ArrayList<Node<K,V>> tmp = container;
		container = new ArrayList<Node<K,V>>();
		//double size
		containerSize = 2*containerSize;
		size = 0; 
		//initialize arraylist as null
		for(int i = 0; i < containerSize; i++)
			container.add(null);
		//add temporary list back to container
		for(Node<K,V> head: tmp)
		{
			while(head!=null)
			{
				insert(head.key, head.val);
				head = head.next;	
			}
		}
	}
	
	//print table
	public void printTable()
	{
		for(Node<K,V> head: container)
			while(head!=null)
			{
				System.out.println("Key = "+head.key+" , Val = "+head.val);
				head = head.next;
			}
	}
}
