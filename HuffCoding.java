package lab3;

import java.util.PriorityQueue;


/**
 * @author Victoria Scalfari
 * Class: Data Structures, Section 82
 * Date: 4/13/16
 * 
 * The HuffCoding class has encode and decode methods
 * that will either encode or decode a string
 * according to the string contents. It also has
 * a buildTree method which builds the huffman coding
 * tree based on the frequency table given in the project
 * description:
 * 
 *	A -  19
	B -  16
	C -  17
	D -  11
	E -  42
	F -  12
	G -  14
	H -  17
	I -  16
	J -  5
	K -  10
	L -  20
	M -  19
	N -  24
	O -  18
	P -  13
	Q -  1
	R -  25
	S -  35
	T -  25
	U -  15
	V -  5
	W -  21
	X -  2
	Y -  8
	Z -  3
 */
public class HuffCoding 
{

	
	/*buildTree builds the Huffman coding tree
	 * based on the frequency table given
	*/
	public void buildTree()
	{
		
	}
	
	/*
	 * createFreqTable creates the frequency table
	 * for the huffman coding tree based on the
	 * information given in the Lab3 handout
	 * and referenced in the HuffCoding class
	 * description.
	 */
	public int[] createFreqTable()
	{
		int[] frequencies = {19, 16, 17, 11, 42, 12, 14, 17, 16, 5, 10, 
				20, 19, 24, 18, 13, 1, 25, 35, 25, 15, 5, 21, 2, 8, 3};
		int[] freqTable = new int[124];
		int counter = 0;
		
		//create an array where each index 97-123 represents
		//the integer value for chars a-z and the value is
		//the frequency of that letter a-z
		for(int i=97; i<123; i++)
		{
			freqTable[i] = frequencies[counter];
			counter++;
		}
		
		return freqTable;
	}
	
    /**
     * Makes a queue of the characters from the input file.
     * @param none
     * @return PriorityQueue of all the single node binary search trees made from each character in the file
     */
	private static PriorityQueue<BinaryTree> makeQueue(String line)
	{
		for(int i=0; i<line.length(); i++)
		{
			// create new (1 node) bst with each character from the line to store into the priority queue
	        BinaryTree bst = new BinaryTree(line.charAt(i));
	        //add the bst to the queue
	        pq.add(bst);
		}
	
		b = new BinarySearchTree<Character>((Character)'^', (Integer) map.get('^'));
		
		pq.add(b);
		
		return pq;
	}
	
	/*
	 * getCodes returns a string array with the code
	 * for each element of the frequency table in it
	 */
	public String[] getCodes(Node root)
	{
	    if(root == null)
	    {
	    	//make sure to check for this later
	    	return null;    
	    }
	    //UPDATE STRING ARRAY SIZE
	    String[] codes = new String[2 * 128];
	    assignCode(root, codes);
	    return codes;
	}
	  
	  /* Recursively get codes for each node
	   * in the Huffman tree
	   */
	  public void assignCode(Node root, String[] codes) 
	  {
	    if (root.leftNode() != null) 
	    {
	      root.leftNode().setCode(root.getCode() + "0");
	      assignCode(root.leftNode(), codes);
	      
	      root.rightNode().setCode(root.getCode() + "1");
	      assignCode(root.rightNode(), codes);
	    }
	    else 
	    {
	      codes[(int)root.element] = root.getCode();
	    }
	  }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
