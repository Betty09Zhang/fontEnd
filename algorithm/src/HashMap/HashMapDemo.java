package HashMap;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author SAMSUNG
 *  hashMap ����
 */
public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		hm.put("��", 1);
		hm.put("˯��", 2);
		hm.put("�Ҿ�", 3);
		hm.put("����", 4);
		for(Entry<String,Integer> m:hm.entrySet()){
			System.out.println("key:"+m.getKey());
			System.out.println("value:"+m.getValue());
		}
		hm.remove("��");
		for(String key:hm.keySet()){
			System.out.println("ʣ�µģ�"+key);
		}
	}

}
