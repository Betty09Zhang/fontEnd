package DP;

public class FullPermutation {

	public static void printPermutation(String str){
		process(str.toCharArray(), 0);
		
		
	}
	/**
	 * @param str
	 * @param N
	 */
	public static void process(char[] str,int N){//N��ʾǰN+1����������0����N
		if(N==str.length){
			System.out.println(str);
			return;
		}
		
		//��ȡÿ�ν������ȫ���У�������л�ԭ
		for(int j=N;j<str.length;j++){
			swap(str,j,N);
			process(str, N+1); //�ݹ� �����������
			swap(str,j,N); //��ԭ
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
