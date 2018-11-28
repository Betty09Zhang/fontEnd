package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author SAMSUNG
 * 	给定一个字符串类型的数组strs，找到一种拼接方式，使得把所
	有字 符串拼起来之后形成的字符串具有最低的字典序。
	eg: String[] str={"ab","c"}; ===》"cab"    "abc"
	返回"abc";
 */


/**
 * @author SAMSUNG
 *思路：把所有的排序看成是 a-z 26进制的数相加
 */
public class DictionarySort {
	
	//比较器比较a+b 与b+a a,b 为字符串 ，a+b,b+a 为组成的字典序。
	public static class DicComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return (o1+o2).compareTo(o2+o1);
		}
		
	}
	public static String combine(String[] str){
		Arrays.sort(str, new DicComparator());
		String result="";
		for(String s:str){
			result+=s;
		}
		return result;
	}
	public static void main(String[] args) {
		String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
		System.out.println(combine(strs1));

		String[] strs2 = { "ba", "b" };
		System.out.println(combine(strs2));

	}
	

}
