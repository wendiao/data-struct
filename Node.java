package Trie.Tree;

import java.util.HashMap;
import java.util.Map;

public class Node
{
	private final String value;
	private Map children = new HashMap();
	private boolean isValidWord;
	
	public Node(String argValue)
	{
		// TODO Auto-generated constructor stub
		 value = argValue;
	}
	
	public boolean addChild(char c,Node argChild)
	{
		children.put(c,argChild);
		return true;
	}
	
	public boolean containsChildValue(char c)
	{
		return children.containsKey(c);
	}
	public String getValue()
	{
		return value.toString();
	}
	public Node getChild(char c)
	{
		return (Node) children.get(c);
	}
	
	public boolean isWord()
	{
		return isValidWord;
	}
	
	public void setIsWord(boolean argIsWord)
	{
		isValidWord = argIsWord;
	}
	public String toString()
	{
		return value;
	}	
}
