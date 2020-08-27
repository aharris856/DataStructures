//weighted graph class
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Graph{
///////////////////////////////////////////////////////////
	//Edge Class
	class Edge{
		int src, dest, weight;
		//constructor
		Edge(int src, int dest, int weight)
		{
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

	//Node class
	class Node{
		int val, weight;
		//Node constructor
		Node(int val, int weight)
		{
			this.val = val;
			this.weight = weight;
		}
	}
//////////////////////////////////////////////////////////
	//adjecency list
	ArrayList<List<Node>> adjList = new ArrayList<>();
	//constructor
	public Graph(List<int[]> input)
	{
		//append inputs into edge list
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i = 0; i < input.size(); i++)
		{
			int[] arr = input.get(i);
			Edge e = new Edge(arr[0], arr[1], arr[2]);
			edges.add(e);
		}

		//initialize adjlist
		for(int i = 0; i < edges.size(); i++)
			adjList.add(i, new ArrayList<>());
		//load edges to graph from source to dest with weight
		for(Edge e: edges)
			adjList.get(e.src).add( (new Node(e.dest, e.weight)) );
	}
	public void printGraph()
	{
		int src = 0;//source incrementer
		int size = this.adjList.size();//size of graph adj list

		System.out.println("Graph Layout ( source -> destination [ weight ] ):\n");
		while(src < size)
		{
			for(Node edge: this.adjList.get(src))
				System.out.print(src+" -> "+edge.val+" ["+edge.weight+"]  ");
			System.out.println();//print line here rather than above in case it has more than one direction
			src++;//increment

		}
	}

}