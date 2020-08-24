public class Queue{
	private int[] arr;
	private int max;
	private int front;
	private int back;
	private int count;

	//queue initialization
	Queue(int size)
	{
		max = size;
		arr = new int[max];
		front = 0;
		back = -1;
		count = 0;
	}
	//add item to queue
	public void enqueue(int input)
	{
		if(isFull()){
			System.out.println("ERROR > enqueue_full");
			System.exit(0);
		}
		back = (back+1)%max;
		arr[back] = input;
		count++;
	}
	//remove front from queue
	public void dequeue()
	{
		if(isEmpty()){
			System.out.println("ERROR > dequeue_empty");
			System.exit(0);
		}
		front = (front+1)%max;
		count = count - 1;
	}
	//show front of queue
	public int peek()
	{
		if(isEmpty()){
			System.out.println("ERROR > peak_empty");
			System.exit(0);
		}
		return arr[front];
	}
	//get size of queue
	public boolean isEmpty(){ return (size()==0);}
	public boolean isFull(){ return (size()==max); }
	public int size(){ return count; }
	

}