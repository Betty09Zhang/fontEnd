package BinaryTree;

import BinaryTree.PostNode.Node;

public class PrintBinaryTree {

	public static class Node { 
		public int value;
		public Node left;
		public Node right;
		public Node(int data){ 
			this.value = data;
			}
		}
	/**
	 * @param head
	 * œ»–Ú –Ú¡–ªØ
	 */
	public void serialNodePrint(Node head){
		if(head==null){
			System.out.println("#_");
			
		}
//		String res=head.value+ "!";
		System.out.print(head.value+"!");
		serialNodePrint(head.left);
		serialNodePrint(head.right);
	}

}
