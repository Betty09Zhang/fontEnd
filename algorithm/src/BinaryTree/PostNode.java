package BinaryTree;

/**
 * @author SAMSUNG
 * 找出先序。后序节点（都是针对中序遍历而言）
 */
public class PostNode {

	public static class Node { 
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		public Node(int data){ 
			this.value = data;
			}
		}
	
		public static Node findPostNode(Node node){
			if(node==null) return null;
			//1.该节点有右子树,则寻找其右子孩子  最左部分的子树
			if(node!=null && node.right!=null){
				return getLeftMost(node.right);
			}
			else{
				while(node.parent!=null && node.parent.left!=node){
					node=node.parent;
				}
			}
			
			return node.parent;
			
		}
		public static Node getLeftMost(Node node){
			if(node==null){
				return null;
			}
			while(node.left!=null){
				node=node.left;
			}
			return node;
			
		}
		public static void main(String[] args) {
			Node head = new Node(6);
			head.parent = null;
			head.left = new Node(3);
			head.left.parent = head;
			head.left.left = new Node(1);
			head.left.left.parent = head.left;
			head.left.left.right = new Node(2);
			head.left.left.right.parent = head.left.left;
			head.left.right = new Node(4);
			head.left.right.parent = head.left;
			head.left.right.right = new Node(5);
			head.left.right.right.parent = head.left.right;
			head.right = new Node(9);
			head.right.parent = head;
			head.right.left = new Node(8);
			head.right.left.parent = head.right;
			head.right.left.left = new Node(7);
			head.right.left.left.parent = head.right.left;
			head.right.right = new Node(10);
			head.right.right.parent = head.right;

			Node test = head.left.left;
			System.out.println(test.value + " next: " + findPostNode(test).value);
		}
}
