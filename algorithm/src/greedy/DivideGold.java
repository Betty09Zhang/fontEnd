package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SAMSUNG
 *һ������г����룬����Ҫ���Ѻͳ�����ֵһ����ͭ��ġ�����
	����Ϊ20�� �����������гɳ��ȶ������룬��Ҫ����20��ͭ
	�塣һȺ������������� ������ô����ʡͭ�壿
	����,��������{10,20,30}������һ�������ˣ������������Ϊ
	10+20+30=60. ����Ҫ�ֳ�10,20,30�������֡� ����� �Ȱѳ�
	��60�Ľ����ֳ�10��50������60 �ٰѳ���50�Ľ����ֳ�20��30��
	����50 һ������110ͭ�塣
	��������� �Ȱѳ���60�Ľ����ֳ�30��30������60 �ٰѳ���30
	�����ֳ�10��20������30 һ������90ͭ�塣
	����һ�����飬���طָ����С���ۡ�
 */
public class DivideGold {

	public PriorityQueue<Integer> gold=new PriorityQueue<Integer>(new MinHeapComparator());;
	
	public class MinHeapComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1-o2;  //С���� ��С�����˳�����С�
		}
		
	}
	//���������ֵ���� �� 
	public  void insert(int[] arr){
		if(arr!=null){
			for(int i: arr){
				gold.add(new Integer(i));
			}
		}
	}
	public  int cost(PriorityQueue<Integer> gold){
		int w=0;
		while(gold.size()>1){
			w=gold.poll()+gold.poll();
			gold.add(new Integer(w));
			
		}
		return w;
		
	}
	public static void main(String[] args) {
		int[] arr={10,20,30};
		DivideGold d=new DivideGold();
		d.insert(arr);
		int result=d.cost(d.gold);
		System.out.println(result);
	}

}
