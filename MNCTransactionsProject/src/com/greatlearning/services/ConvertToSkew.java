package com.greatlearning.services;

import com.greatlearning.model.Node;

public class ConvertToSkew 
{
	public Node node;
    Node prevNode = null;
    Node headNode = null;
   
    
    public void bstToSkewed(Node root)
    {
       
        // Base Case
        if(root == null)
        {
            return;
        }
       
               
             bstToSkewed(root.left);
             Node rightNode = root.right;
       
        // Condition to check if the root Node
        // of the skewed tree is not defined
        if(headNode == null)
        {
            headNode = root;
            prevNode=root;
            headNode.right=prevNode;
          
        }
        else
        {     	
        	
            prevNode.right = root;
            prevNode = root;
                      
            
        }
       
        bstToSkewed(rightNode);

    }
   
    // Function to traverse the right skewed tree 
    private void traverse(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data+"-->(right)");
        traverse(root.right);       
     }
    
    // Function to display the right skewed tree
    public void displaySkewTree()
    {
    	traverse(headNode);
    }
   
}
