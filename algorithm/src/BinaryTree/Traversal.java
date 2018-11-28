package BinaryTree;

public class Traversal {
	static class Node{
		Node left;
		Node right;
		int val;
		Node(int val){
			this.val=val;
		}
		
	}
	public static void preOrder(Node head){
		if(head!=null){
			System.out.println("œ»–Ú±È¿˙£∫"+head.val);
			preOrder(head.left);
			preOrder(head.right);
		}
	}
	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.right = new Node(8);
		head.left.left = new Node(2);
		head.left.right = new Node(4);
		head.left.left.left = new Node(1);
		head.right.left = new Node(7);
		head.right.left.left = new Node(6);
		head.right.right = new Node(10);
		head.right.right.left = new Node(9);
		head.right.right.right = new Node(11);
		preOrder(head);
		
		
	}
}
