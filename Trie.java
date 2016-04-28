package Trie.Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Trie {
   private Node root = new Node("");
   public Trie()
   {}
   public Trie(List<String> argInitialWords)
   {
	   for(String word:argInitialWords)
	   {
		   addWord(word);
	   } 
   }
   public void addWord(String argWord)
   {
	   char argChars[] = argWord.toCharArray();
	   Node currentNode = root;
	   
	   for(int i = 0; i < argChars.length; i++)
	   {
		   if(!currentNode.containsChildValue(argChars[i]))
		   {
			  currentNode.addChild(argChars[i], new Node(currentNode.getValue() + argChars[i]));   
		   }
		   currentNode = currentNode.getChild(argChars[i]);
	   }
	   currentNode.setIsWord(true);
   }
   
   public boolean containsPrefix(String argPrefix)
   {
	   return contains(argPrefix,false);
   }
   public boolean containsWord(String argWord)
   {
	   return contains(argWord,true);
   }
   public Node getWord(String argString)
   {
	   Node node = getNode(argString);
	   return node != null && node.isWord() ? node:null;
   }
   
   public Node getPrefix(String argString)
   {
	   return getNode(argString);
   }
   
   private boolean contains(String argString,boolean argIsWord)
   {
	   Node node = getNode(argString);
	   return (node != null && node.isWord() && argIsWord) ||
			   (!argIsWord && node != null);
   }
   private Node getNode(String argString)
   {
	   Node currentNode = root;
	   char argChars[] = argString.toCharArray();
	   for(int i = 0;i < argChars.length && currentNode != null;i++)
	   {
		   currentNode = currentNode.getChild(argChars[i]);
		   if(currentNode == null)
		   {
			   return null;
		   }
	   }
	   return currentNode;
   }
}
