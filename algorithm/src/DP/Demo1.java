package DP;

public class Demo1 {

	public static int  factory(int n){
		if(n<=1) return n;
		else{
			return n*factory(n-1);
		}
		
	}
	public static void main(String[] args) {
		System.out.println(factory(5));
	}

}
