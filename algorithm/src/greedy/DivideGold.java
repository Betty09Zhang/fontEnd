package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SAMSUNG
 *一块金条切成两半，是需要花费和长度数值一样的铜板的。比如
	长度为20的 金条，不管切成长度多大的两半，都要花费20个铜
	板。一群人想整分整块金 条，怎么分最省铜板？
	例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为
	10+20+30=60. 金条要分成10,20,30三个部分。 如果， 先把长
	度60的金条分成10和50，花费60 再把长度50的金条分成20和30，
	花费50 一共花费110铜板。
	但是如果， 先把长度60的金条分成30和30，花费60 再把长度30
	金条分成10和20，花费30 一共花费90铜板。
	输入一个数组，返回分割的最小代价。
 */
public class DivideGold {

	public PriorityQueue<Integer> gold=new PriorityQueue<Integer>(new MinHeapComparator());;
	
	public class MinHeapComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1-o2;  //小根堆 从小到大的顺序排列。
		}
		
	}
	//将数组的数值存入 堆 
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
