package HashMap;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author SAMSUNG
 *  hashMap º¯Êı
 */
public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		hm.put("³Ô", 1);
		hm.put("Ë¯¾õ", 2);
		hm.put("ìÒ¾ç", 3);
		hm.put("ÂÃÓÎ", 4);
		for(Entry<String,Integer> m:hm.entrySet()){
			System.out.println("key:"+m.getKey());
			System.out.println("value:"+m.getValue());
		}
		hm.remove("³Ô");
		for(String key:hm.keySet()){
			System.out.println("Ê£ÏÂµÄ£º"+key);
		}
	}

}
