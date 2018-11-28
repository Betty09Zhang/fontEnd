package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SAMSUNG
 *输入： 参数1，正数数组p 参数2，正数数组profits 参数3，
	正数k 参数4，正数m
	p[i]表示i号项目的花费 profits[i]表示i号项目在扣除花
	费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多
	做k个项目 m表示你初始的资金
	说明：你每做完一个项目，马上获得的收益，可以支持你去做下
	一个 项目。
	输出： 你最后获得的最大钱数。
 */
public class IPO {
	
	
	
	public static class Node{
		public int cost;
		public int profits;
		
		public Node(int cost,int profits){
			this.cost=cost;
			this.profits=profits;
		}
	}
	
	/**
	 * @param cost 一个项目的花费
	 * @param profits  一个项目的收益
	 * @param initMoney  一个项目的启动资金
	 */
	
	
	public static class minHeapCompare implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			return o1.cost-o2.cost;
			// TODO Auto-generated method stub
		
		}
	 }
		
	public static class maxHeapCompare implements Comparator<Node>{

			@Override
			public int compare(Node o1, Node o2) {
				return o1.profits-o2.profits;
				// TODO Auto-generated method stub
			
			}
		
	}
	public static int findMaxProfits(int k,int[] profits,int[] costs,PriorityQueue<Node> minCost,PriorityQueue<Node> maxProfit,int initM){
		 minCost=new PriorityQueue<Node>(new minHeapCompare());
	maxProfit=new PriorityQueue<Node>(new maxHeapCompare());
		
		
		if(profits!=null && costs!=null){
			for(int i=0;i<profits.length;i++){       
				Node e=new Node(costs[i],profits[i]);
				minCost.add(e);
				//maxProfit.add(e);
			}
		}
		
		//将cost与initM比较， 较小的前几项放入maxProfit,做最大的收益的项目。 循环K次 做完K个项目
		for(int i=0;i<profits.length;i++){
			while(!minCost.isEmpty()&& minCost.peek().cost<=initM){
				maxProfit.add(minCost.poll());
			}
			if(maxProfit.isEmpty()) {
				return initM;
			}
			initM+=maxProfit.poll().profits;
			
		}
		return initM;
		
	}
	public static void main(String[] args) {
		int[] profits={3,5,3,1};
		int[] costs={8,10,4,7};
		int initM=15;
		PriorityQueue<Node> minCost=null;
		PriorityQueue<Node> maxProfit=null;
		int w=findMaxProfits(3,profits, costs, minCost, maxProfit, 6);
		System.out.println(w);
		
	}
	
}
