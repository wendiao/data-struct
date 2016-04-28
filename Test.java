package Trie.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class Test {

	private static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String words[] = {"a","apple","argument","aptitude", "ball", "bat"};
        Trie trie = new Trie(Arrays.asList(words));
        
        try
        {
        	while(true)
        	{
        		System.out.println("Word to lookup");
        		String word = br.readLine().trim();
        		if( word.isEmpty())
        			break;
        		if( trie.containsWord(word))
        			System.out.println(word + " found");
        		else if( trie.containsPrefix(word))
        		{	
        			if( confirm(word + "is a prifix add as a word?"))
        				trie.addWord(word);
        		}else
        		{
        		    if( confirm("Add " + word + "?" ))
        		    	trie.addWord(word);
        		}
        	}
        }catch(IOException e)
        {
        	e.printStackTrace();
        }
	}
	
	public static boolean confirm(String question) throws IOException
	{
		while(true)
		{
			System.out.println(question + " ");
			String ans = br.readLine().trim();
			if(ans.equalsIgnoreCase("N") || ans.equalsIgnoreCase("NO"))
				return false;
			else if(ans.equalsIgnoreCase("Y") || ans.equalsIgnoreCase("YES"))
				return true;
			System.out.println("Please answer Y,YES,or N,NO");
		}
	}
	

}
