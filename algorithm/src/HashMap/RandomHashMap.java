package HashMap;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author SAMSUNG
 *设计RandomPool结构
【题目】 设计一种结构，在该结构中有如下三个功能：
insert(key)：将某个key加入到该结构，做到不重复加入。
delete(key)：将原本在结构中的某个key移除。 getRandom()：
等概率随机返回结构中的任何一个key。
【要求】 Insert、delete和getRandom方法的时间复杂度都是
O(1)
 */
public class RandomHashMap<K> {

	public HashMap<K, Integer> map1;
	public HashMap<Integer,K> map2;
	public int size;
	
	public RandomHashMap() {
		this.size=0;
		this.map1=new HashMap<K,Integer>();
		this.map2=new HashMap<Integer,K>();
		// TODO Auto-generated constructor stub
	}

	public void insert(K key){
		//判断是否包含 key
		if(!map1.containsKey(key)){
			this.map1.put(key, size);
			this.map2.put(size++, key); //Test demo 弄明白size++ 先赋值，后++；
		}
		System.out.println("size: 大小"+size);
		
	}
	public void delete(K key){
		int lastValue=0;
		if(map1.containsKey(key)){
			
			lastValue=map1.get(key);
			map1.remove(key);
			map2.remove(lastValue);
			size--;
		}	
		//删除后  用最后一个数填补空位(即删除为与最后一位交换) 否则获得随机KEY 会有问题
		K lastKey=map2.get(size);
		map1.put(lastKey, lastValue);
		map2.put(lastValue,lastKey);
		
	}
	public K getRandom(){
		//判空
		if(this.size==0){
			return null;
		}
		int index=(int) Math.floor(Math.random()*(this.size));
		return this.map2.get(index);
	}
	public static void main(String[] args) {
		RandomHashMap<String> pool=new RandomHashMap<String>();
		pool.insert("zuo");
		pool.insert("cheng");
		pool.insert("yun");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		
	}

}
