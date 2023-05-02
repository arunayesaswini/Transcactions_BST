package com.greatlearning.main;

import java.util.Scanner;

import com.greatlearning.services.CompleteBinarySearchTree;

public class MncTransactionDriver {

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		CompleteBinarySearchTree cbst=new CompleteBinarySearchTree();
		System.out.println("No. of Transactions to Enter ");
		int n=sc.nextInt();
		System.out.println("Enter Transactions");
		for(int i=1;i<=n;i++)
		{
			double transaction=sc.nextDouble();
			cbst.insert(transaction);
		}
		
		try {
		cbst.convertTree();
		}
		catch(Exception e)
		{
			System.out.println("program is going beyond the limit: "+e);
		}
		sc.close();
		

	}

}
