package algorithm;

/**
 * @author SAMSUNG
 * 反转单向链表    局部到整体
 */
public class ReverseList {

	static class Node{
		public int value;
		public Node next;
		Node(int value){
			this.value=value;
		}
	}
	
	/**
	 * @param head
	 * @return 反转列表    不断移动头head 指针   head前pre head 后为next 节点
	 */
	public static Node reverseList(Node head){
		Node pre=null;
		Node next=null;
		while(head!=null){
			next=head.next;
			head.next=pre;
			
			pre=head;
			head=next;	
		}
		System.out.println();
		return pre;
	}
	public static  void printList(Node head){
		System.out.println("Linked list:   ");
		while(head!=null){
			System.out.println(head.value+"  ");
			head=head.next;
		}
	}
	public static void main(String[] args) {
		Node node1=new Node(3);
		Node node2=new Node(1);
		Node node3=new Node(2);
		node1.next=node2;
		node2.next=node3;
		printList(node1);
		
		Node node=reverseList(node1);
		
		printList(node);
	}

}
