package HashMap;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author SAMSUNG
 *���RandomPool�ṹ
����Ŀ�� ���һ�ֽṹ���ڸýṹ���������������ܣ�
insert(key)����ĳ��key���뵽�ýṹ���������ظ����롣
delete(key)����ԭ���ڽṹ�е�ĳ��key�Ƴ��� getRandom()��
�ȸ���������ؽṹ�е��κ�һ��key��
��Ҫ�� Insert��delete��getRandom������ʱ�临�Ӷȶ���
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
		//�ж��Ƿ���� key
		if(!map1.containsKey(key)){
			this.map1.put(key, size);
			this.map2.put(size++, key); //Test demo Ū����size++ �ȸ�ֵ����++��
		}
		System.out.println("size: ��С"+size);
		
	}
	public void delete(K key){
		int lastValue=0;
		if(map1.containsKey(key)){
			
			lastValue=map1.get(key);
			map1.remove(key);
			map2.remove(lastValue);
			size--;
		}	
		//ɾ����  �����һ�������λ(��ɾ��Ϊ�����һλ����) ���������KEY ��������
		K lastKey=map2.get(size);
		map1.put(lastKey, lastValue);
		map2.put(lastValue,lastKey);
		
	}
	public K getRandom(){
		//�п�
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
