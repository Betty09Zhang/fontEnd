package DP;

/**
 * @author SAMSUNG
 *  求一个字符串的所有子序列
 */
public class SubSequence {

	
	/**
	 * @param ss  
	 * @param length
	 * @param str
	 */
	public static void printSubSequence(char[] ss,int i,String str){
		if(ss.length==i){
			System.out.println(str);
			return;
		}
		// 枚举出所有可能
		//下一个子串可以打印，也可以不打印    
		printSubSequence(ss, i+1, str);
		printSubSequence(ss, i+1, str+ss[i]);
	}
	public static void main(String[] args) {
		printSubSequence("abc".toCharArray(), 0, "");
	}
}
