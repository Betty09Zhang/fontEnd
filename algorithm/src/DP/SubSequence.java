package DP;

/**
 * @author SAMSUNG
 *  ��һ���ַ���������������
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
		// ö�ٳ����п���
		//��һ���Ӵ����Դ�ӡ��Ҳ���Բ���ӡ    
		printSubSequence(ss, i+1, str);
		printSubSequence(ss, i+1, str+ss[i]);
	}
	public static void main(String[] args) {
		printSubSequence("abc".toCharArray(), 0, "");
	}
}
