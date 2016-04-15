package lab3;


public class BinaryTree 
{
	Node root;
	//class variable allows recursion later
	private String preorder = "";
	private int frequency;
	
    public BinaryTree()
    {
        this.root = null;
        this.frequency = 0;
    }
    
    public BinaryTree(BinaryTree left, BinaryTree right, int frequency)
    {
    	root = new Node (null, frequency);
    	root.left = left.root;
    	root.right = right.root;
    	this.frequency = frequency;
    }
    
    public BinaryTree(String value, int freq)
    {
    	root = new Node(value, freq);
    	frequency = freq;
    }
    
	public String addValToPreorder(Node root)
	{
		//add the value to the preorder string
		preorder = preorder + root.getNodeValue() + " ";
		return preorder;
	}
	
	public String getPreorder(Node root)
	{
		//conduct recursive preorder method
		preOrder(root);
		//return the string
		return preorder;
	}
	
	//uses recursion to go through tree in preorder
	//efficiency is O(n) because only "visits" each node once
	public void preOrder (Node root)
	{
	 
	  if(root == null)
	  {
		  return;
	  }
	  
	  addValToPreorder(root);
	  
	  //get all of the left nodes
	  preOrder(root.leftNode());
	  //get all of the right nodes
	  preOrder(root.rightNode()); 
	  
	}
	


	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
