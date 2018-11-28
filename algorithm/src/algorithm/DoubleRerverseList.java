package algorithm;


/**
 * @author SAMSUNG
 * ˫������ת  �ֲ�������
 */
public class DoubleRerverseList {

	static class DoubleNode{
		public int value;
		public DoubleNode next;
		public DoubleNode last;
		DoubleNode(int value){
			this.value=value;
		}
	}
	
	/**
	 * @param head
	 * @return ��ת˫���б�    �����ƶ�ͷhead ָ��   headǰpre head ��Ϊnext �ڵ�  Χ�ƽڵ�headչ��   ��ת�� head.last= next; head.next=pre;
	 */
	public static DoubleNode rerverseListDouble(DoubleNode head){
		DoubleNode pre=null;
		DoubleNode next=null;
		while(head!=null){
			next=head.next;
			head.next=pre;
			
			head.last=next;
			pre=head;
			head=next;
			
			
		}
		return pre; //��� head Ϊnull ����while  ����head ��ǰһ��Ԫ�� pre;
	}
	
	public static  void printDoubleList(DoubleNode head){
		System.out.println("DoubleLinked list:   ");
		DoubleNode end=null;
		while(head!=null){
			System.out.println(head.value+"  ");
			end=head;
			head=head.next;
		}
		System.out.print("|");
		while(end!=null){
			System.out.println(end.value+" ");
			end=end.last;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		DoubleNode head1=new DoubleNode(3);
		head1.next=new DoubleNode(1);
		head1.next.last=head1;
		head1.next.next=new DoubleNode(2);
		head1.next.next.last=head1.next;
		printDoubleList(head1);
		
		DoubleNode DoubleNode=rerverseListDouble(head1);
		
		printDoubleList(DoubleNode);
	}

}
