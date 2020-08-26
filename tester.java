//structure tester class
public class tester{
	
	public static void main(String[]args)
	{
		//test linked list method
		testLinkedList();

		//test circly doubly linked list
		testCDLL();

		//test queue
		testQueue();

		//BSTree tester + Order traversals
		binarySearchTreeTester();	

		//trie tester
		trieTester();

		//hash tester
		hashTester();
		

	}
	//LINKED LIST TESTER ///////////////////////////////////////////////////////////////////////////////////////////////
	static void testLinkedList()
	{
		System.out.println("________________________LINKED LIST TESTER________________________\n");
		LinkedList list = new LinkedList();

		//insert 0 - 15
		for(int i = 0; i < 15; i++)
			list.insert(i);
		//print list
		System.out.println("List after Insertion 0 - 14");
		list.print();

		System.out.println("Size of List = "+list.size());

		//remove evens less than 15
		for(int i = 0; i < 15; i++)
			if(i%2==0)list.remove(i);
		System.out.println("List after removal of Evens");
		list.print();
		System.out.println("Size of list after removal = "+list.size());

		System.out.println("Does list contain 34? "+list.contains(34));
		System.out.println("Does list contain 8? "+list.contains(8));
		System.out.println("Does list contain 3? "+list.contains(3));
		System.out.println("Does list contain 1? "+list.contains(1));
		System.out.println("__________________________________________________________End LinkedList\n");
		//END LINKED LIST TESTER ////////////////////////////////////////////////////////////////////////////////////////
	}
	//CIRCLY DOUBLY LINKED LIST TESTER //////////////////////////////////////////////////////////////////////////////
	static void testCDLL()
	{
		System.out.println("_____________________CDLL TESTER _________________________________\n");

	    Cdll cdll = new Cdll();
	    //insert random nodes
	    cdll.insertAtEnd(13);
	    cdll.insertAtFront(6);
	    cdll.insertAtEnd(3819);
	    cdll.insertAtEnd(31);
	    cdll.insertAtFront(1);
	    cdll.insertAfter(21, 31);
	    cdll.insertAfter(2,6);
	    System.out.println("cdll size = "+cdll.size());
	    //print circly doubly list
	    cdll.print();
	    System.out.println();
	    //cdll after removing node given data
	    cdll.remove(3819);
	    System.out.println("Cdll after removing 3819, new size = "+cdll.size());
	    cdll.print();
	    System.out.println("\n does cdll contain (3, 1, 31)? : "+cdll.contains(3)+" , "+cdll.contains(1)+" , "+cdll.contains(31));
		System.out.println("__________________________________________________________END CDLL\n");
		//END CDLL////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}

	//QUEUE TESTER LIST////////////////////////////////////////////////////////////////////////////////////////////////////////////
	static void testQueue()
	{
		System.out.println("__________________________QUEUE TESTER_______________________________________\n");

		Queue queue = new Queue(10);
		//fill queue with 1 - 10
		for(int i = 1; i < 11; i++)
			queue.enqueue(i);

		if(queue.isFull())System.out.println("Queue is Full");
		else System.out.println("Queue is NOT Full");

		System.out.println("Current front of queue: "+queue.peek()+"  >>> Queue size = "+queue.size());
		queue.dequeue();
		System.out.println("Current front after dequeue: "+queue.peek()+" >>> Queue size = "+queue.size());
		System.out.println("Emptying Queue... ");
		//empty the queue
		for(int i = 0; i < 9; i++)
			queue.dequeue();

		if(queue.isEmpty())System.out.println("Queue is Empty");
		else System.out.println("Queue is NOT Empty");
		System.out.println("________________________________________________________END QUEUE\n");
		//END QUEUE//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	//BST TESTER ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	static void binarySearchTreeTester()
	{
		System.out.println("___________BSTree TESTER _____________________________________________________\n");
		int[] arr = {6, 4, 6, 2, 1, 9};

		//intilize tree and check a few contained calls
		BSTree arrTree = new BSTree( arr );
		System.out.println("tree contains (7, 4, 6, 3)? "+arrTree.contains(7)+" , "+arrTree.contains(4)+" , "+arrTree.contains(6)+" , "+arrTree.contains(3)+"\n");
		//print tree preorder traversal
		System.out.println("Tree printed PRE-ORDER traversal: ");
		arrTree.printPreOrder();
		//print tree inorder traversal
		System.out.println("Tree printed IN-ORDER traversal: ");
		arrTree.printInOrder();
		//print tree level order traversal
		System.out.println("Tree Printed LEVEL-ORDER traversal: ");
		arrTree.printLevelOrder();
		//print tree post order traversal
		System.out.println("Tree Printed POST-ORDER traversal: ");
		arrTree.printPostOrder();


		System.out.println("____________________________________________________________________________END BSTree\n");

		//END BST TESTER///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	}
	//TRIE TESTER ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	static void trieTester()
	{
		System.out.println("________________________________TRIE TESTER_____________________________\n");
		Trie tr = new Trie();
		//vals to input to trie
		String[] input = {"hi", "i","whats", "the","forgive","swag","lmao","there"};
        //insert input
        for(int i = 0; i < input.length; i++)
        	tr.insert(input[i]);
        //print trie after input
        System.out.println("Trie after input: \n");
        tr.printLevels();
       	       // check if trie contains given strings
       System.out.println("Trie contains 'the' ? >>> "+tr.contains("the"));
       System.out.println("Trie contains 'xD' ? >>> "+tr.contains("xD"));
       System.out.println("Trie contains 'The' (caps 't') ? >>> "+tr.contains("The"));
       System.out.println("Trie contains 'sw' ? >>> "+tr.contains("sw"));
       System.out.println("Trie contains 'i' ? >>> "+tr.contains("i"));
       System.out.println("Trie contains 'swag' ? >>> "+tr.contains("swag")+"\n");

       System.out.println("Deleting 'there' from trie .... ");
       tr.delete("there"); //delete 'there'
       System.out.println("Trie contains 'the' ? >>> "+tr.contains("the"));//make sure it didn't delete children
       System.out.println("Trie contains 'there' ? >>> "+tr.contains("there"));

       //print trie fater removal of items
       System.out.println("Trie after removal: \n");
       tr.printLevels();
       
       System.out.println("_________________________________________________________________END TRIE TESTER\n");
	   //END TRIE TESTER////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	static void hashTester()
	{
		System.out.println("__________________________HASH TABLE TESTER_______________________________________________");
		HashTable<String, Integer> table = new HashTable <String, Integer>();
		//insert 6 values into the table
		table.insert("swag",0);
		table.insert("whatevs",2);
		table.insert("LOL bro wut",1);
		table.insert("xD",3);
		table.insert("test test",6);
		table.insert("xD",4);//one dupe so 5 values really
		//print table and size of table
		System.out.println("Table:   >>>> size = "+table.size());
		table.printTable();
		System.out.println();
		//print table after removing key 'xD'
		System.out.println("Table after removing 'xD':    >>>> size =  "+table.size());
		table.remove("xD");
		table.printTable();
		//push table passed initial max capacity
		System.out.println();
		System.out.println("Going to table max size of table... ");
		table.insert("what it do",1);
		table.insert("test number swag",19);
		table.insert("lol", 3);
		table.insert("idk wut to add lol ",9);
		table.insert("horse",2);
		table.insert("hehe",9);
		table.insert("i got da kewl",21);
		//print table after capacity maxed out
		System.out.println("Table after hitting max size:     >>>> size = "+table.size());
		table.printTable();
		System.out.println();
		System.out.println("Searching table for whatevs: whatevs.val = "+table.get("whatevs")+"\nSearching table for value not in table: 'yolo'.val = "+table.get("yolo"));
		System.out.println("________________________________________________________________________________END HASH TESTER\n");
	}

}
