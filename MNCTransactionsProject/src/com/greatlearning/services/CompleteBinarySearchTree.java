package com.greatlearning.services;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import com.greatlearning.model.BinarySearchTree;
import com.greatlearning.model.Node;
public class CompleteBinarySearchTree 
{
	Vector<Node> nodes=new Vector<Node>();
	Node tree_root=null;
	BinarySearchTree bst=new BinarySearchTree();
	
	public void insert(double value)
	{
		bst.insert(value);
	}
	
	public void convertTree()
	{
		nodes=bst.getNodes();
		
		System.out.println("Transactions into Complete Binary search tree:");
		for(Node node:nodes)
		{
			System.out.print(node.data+" ");
		}
		System.out.println();
		
		
		completeTree(nodes);
		
		ConvertToSkew cts=new ConvertToSkew();
		
		cts.bstToSkewed(tree_root);
		System.out.println("conversion from Complete Binary Search Tree to Right Skew Tree:");
		cts.displaySkewTree();
			
	}
	
	
	
	// creating complete tree
	
	public void completeTree(Vector<Node> treenodes)
	{
		int size=treenodes.size();
		int mid=(size)/2;
		tree_root=treenodes.get(mid);
		tree_root.left=insertNodes(treenodes,0,mid-1);
		tree_root.right=insertNodes(treenodes,mid+1,size-1);	
		displayTree(tree_root);
	}
	
	//inserting nodes into complete tree
	private Node insertNodes(Vector<Node> nodes,int start,int end)
	{
		Node node=tree_root;
		if(start>end)
		 return null;
		else
		{
			int middle=(start+end)/2;
			node=nodes.get(middle);
			node.left=insertNodes(nodes,start,middle-1);
			node.right=insertNodes(nodes,middle+1,end);
			return node;
		}
	}
	
	// display complete binary search tree
		private void displayTree(Node tree_root) 
		{
			Queue<Node> queue=new LinkedList<Node>();
			
			if(tree_root==null)
				System.out.println("Tree is Empty");
			else
			{
				queue.add(tree_root);
				while(!queue.isEmpty())
				{
					Node temp=queue.poll();
					
					System.out.println();
					//printing the parent node
					if(temp.left!=null && temp.right!=null)
						System.out.println(temp.data+" is parent");
					//printing the leaf node
					else if(temp.left!=null && temp.right==null)
						System.out.println(temp.data+" is parent");
					else if(temp.left==null && temp.right!=null)
						System.out.println(temp.data+" is parent");
					else if(temp.left==null && temp.right==null)
						System.out.println(temp.data+" is leaf Node");
						
					
					if(temp.left!=null)
					{
						System.out.print(temp.left.data+" (left) ,");
						queue.add(temp.left);
					}
					if(temp.right!=null)
					{
						System.out.print(temp.right.data+" (right) ");
						queue.add(temp.right);
					}
					System.out.println();
				}
				
				
			}
		}
		

}
