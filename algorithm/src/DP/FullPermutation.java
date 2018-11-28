package DP;

public class FullPermutation {

	public static void printPermutation(String str){
		process(str.toCharArray(), 0);
		
		
	}
	/**
	 * @param str
	 * @param N
	 */
	public static void process(char[] str,int N){//N表示前N+1个数的索引0——N
		if(N==str.length){
			System.out.println(str);
			return;
		}
		
		//求取每次交换后的全排列，最后数列还原
		for(int j=N;j<str.length;j++){
			swap(str,j,N);
			process(str, N+1); //递归 后面的子序列
			swap(str,j,N); //还原
		}
		
		
	}
	public static void swap(char[] str,int j,int i){
		char temp=str[j];
		str[j]=str[i];
		str[i]=temp;
	}
	public static void main(String[] args) {
		String str="abc";
		printPermutation(str);
	}

}
