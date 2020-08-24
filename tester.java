public class tester{
	public static void main(String[]args)
	{
		//LINKED LIST TESTER ///////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("________________________LINKED LIST TESTER________________________");
		LinkedList list = new LinkedList();

		//insert 0 - 15
		for(int i = 0; i < 15; i++)
			list.insert(i);
		//print list
		System.out.println("List after Insertion 0 - 15");
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
		//CIRCLY DOUBLY LINKED LIST TESTER //////////////////////////////////////////////////////////////////////////////
		System.out.println("_____________________CDLL TESTER _________________________________");

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
		//QUEUE TESTER LIST////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
		//empty the queue
		for(int i = 0; i < 9; i++)
			queue.dequeue();

		if(queue.isEmpty())System.out.println("Queue is Empty");
		else System.out.println("Queue is NOT Empty");
		System.out.println("________________________________________________________END QUEUE\n");
		//END QUEUE//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}

}
