package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SAMSUNG
 *���룺 ����1����������p ����2����������profits ����3��
	����k ����4������m
	p[i]��ʾi����Ŀ�Ļ��� profits[i]��ʾi����Ŀ�ڿ۳���
	��֮����������Ǯ(����) k��ʾ�㲻�ܲ��С�ֻ�ܴ��е����
	��k����Ŀ m��ʾ���ʼ���ʽ�
	˵������ÿ����һ����Ŀ�����ϻ�õ����棬����֧����ȥ����
	һ�� ��Ŀ��
	����� ������õ����Ǯ����
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
	 * @param cost һ����Ŀ�Ļ���
	 * @param profits  һ����Ŀ������
	 * @param initMoney  һ����Ŀ�������ʽ�
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
		
		//��cost��initM�Ƚϣ� ��С��ǰ�������maxProfit,�������������Ŀ�� ѭ��K�� ����K����Ŀ
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
