package lab3;

/**
 * @author Victoria Scalfari
 * Class: Data Structures, Section 82
 * Date: 4/13/16
 * 
 * The Node class is used to represent each
 * element (Node) of the Huffman Coding Tree.
 * 
 * It has methods such as leftNode and rightNode
 * which get the left or right child of the current
 * node. It also has a printNodeValue method and
 * a preorder method which 
 */

public class Node 
{

	private Node right;
	private Node left;
	private String nodeValue;
	private String code;
	private int frequency;
	
	public Node (  )
	{
	// a Java constructor
		this.right = null;
		this.left = null;
		this.setNodeValue("");
		this.setCode("");
		this.frequency = 0;
	}
	
	public Node(String val, int freq)
	{
		this.right = null;
		this.left = null;
		this.nodeValue = val;
		this.frequency = freq;
		this.setCode("");
	}
	
	public Node leftNode() 
	{
		return left;
	}
	
	public Node rightNode() 
	{
		return right;
	}
	
	public String getNodeValue() 
	{
		return nodeValue;
	}
	
	public void setNodeValue(String val) 
	{
		this.nodeValue = val;
	}
	
	public String getCode() 
	{
		return code;
	}

	public void setCode(String code) 
	{
		this.code = code;
	}
	
	public void printNodeValue()
	{
		System.out.println(getNodeValue());
	}
	


	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}



}
