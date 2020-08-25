//trie class of chars
import java.util.*;
public class Trie{
///////////////////////////////////////////////
	//trie node class
	class Node{
		boolean isEnding;
		//hashmap children to prevent dupes
		HashMap<Character, Node> children;
		Node(){
			isEnding = false;
			children = new HashMap<>();
		}
	}
////////////////////////////////////////////
	//insert string into the trie
	Node root = new Node();
	public void insert(String str)
	{
		Node curr = root;
		for(char ch: str.toCharArray())
		{
			//if curr doesn't have child char ch put new node with key ch
			if(!curr.children.containsKey(ch))curr.children.put(ch, new Node());
			//increment
			curr = curr.children.get(ch);
		}
		curr.isEnding = true;
	}
	//check if trie contains given string
	public boolean contains(String str)
	{
		Node curr = root;
		for(char ch: str.toCharArray())
		{
			curr = curr.children.get(ch);
			if(curr == null)return false;
		}
		return (curr.isEnding);
	}
	//delete string from trie
	public void delete(String str)
	{
		if(!contains(str))return;
		deleteHelper(root, str, false);
	}
	private void deleteHelper(Node curr, String str, Boolean recurse)
	{
		if(str.isEmpty())return;
		Node parent = null;
		for(char ch: str.toCharArray())
		{
			parent = curr;
			curr = curr.children.get(ch);
		}
		if(curr.isEnding && !curr.children.isEmpty() && !recurse){//is ending, has not recursed, has children
			curr.isEnding = false;
			return;
		}else if( (curr.children.size() > 1 || curr.isEnding) && recurse){//has recursed, has children OR is an ending
			return;
		}
		//call delete helper again to recurse and set recurse boolean to true
		deleteHelper(root, str.substring(0, str.length()-1),true);
		//remove character at each index post recursion
		parent.children.remove(str.charAt(str.length()-1));
	}

}