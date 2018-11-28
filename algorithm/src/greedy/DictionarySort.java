package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author SAMSUNG
 * 	����һ���ַ������͵�����strs���ҵ�һ��ƴ�ӷ�ʽ��ʹ�ð���
	���� ����ƴ����֮���γɵ��ַ���������͵��ֵ���
	eg: String[] str={"ab","c"}; ===��"cab"    "abc"
	����"abc";
 */


/**
 * @author SAMSUNG
 *˼·�������е����򿴳��� a-z 26���Ƶ������
 */
public class DictionarySort {
	
	//�Ƚ����Ƚ�a+b ��b+a a,b Ϊ�ַ��� ��a+b,b+a Ϊ��ɵ��ֵ���
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
