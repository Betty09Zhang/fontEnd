package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SAMSUNG
 *è������ ����Ŀ�� �������è�������£�
public class Pet { private String type;
public Pet(String type) { this.type = type; }
public String getPetType() { return this.type; }
}
public class Dog extends Pet { public Dog() { super("dog"); } }
public class Cat extends Pet { public Cat() { super("cat"); } }
ʵ��һ�ֹ�è���еĽṹ��Ҫ�����£� �û����Ե���add������cat���dog���
ʵ����������У� �û����Ե���pollAll�����������������е�ʵ�����ս�����
���Ⱥ�˳�����ε����� �û����Ե���pollDog��������������dog���ʵ������
�����е��Ⱥ�˳�����ε����� �û����Ե���pollCat��������������cat���ʵ
�����ս����е��Ⱥ�˳�����ε����� �û����Ե���isEmpty����������������
����dog��cat��ʵ���� �û����Ե���isDogEmpty���������������Ƿ���dog
���ʵ���� �û����Ե���isCatEmpty���������������Ƿ���cat���ʵ����
 */
public class CatAndDogQueue {
	public Queue<PetEnterQueue> dogQueue;
	public Queue<PetEnterQueue> catQueue;
	public int num=0;
	public CatAndDogQueue(){
		this.dogQueue=new LinkedList<PetEnterQueue>();
		this.catQueue=new LinkedList<PetEnterQueue>();
	}
	public void add(Pet pet){
		if(pet.getPetType()=="dog"){
			dogQueue.add(new PetEnterQueue(new Dog(), num+1));
		}
		else{
			catQueue.add(new PetEnterQueue(new Cat(), num+1));
		}
	}
	public Pet pollAll(){
		
		//�пմ���
		if(!dogQueue.isEmpty() && !catQueue.isEmpty()){
			if(dogQueue.peek().getCount()>catQueue.peek().getCount()){
				return catQueue.poll().getPet();
			}
			else{
				return dogQueue.poll().getPet();
			}
		}
		else if(!dogQueue.isEmpty()) return dogQueue.poll().getPet();
		else if(!catQueue.isEmpty()){
			return catQueue.poll().getPet();
		}
		else{
			throw new RuntimeException("no pet");
		}
			
		
	}
	
}
class PetEnterQueue{
	/**
	 * ���¶��� ��  �����������������  ������
	 */
	public Pet pet;
	public int count;
	PetEnterQueue(Pet pet,int count){
		this.pet=pet;
		this.count=count;
	}
	public String getType(){
		return this.pet.getPetType();
		
	}
	public int getCount() {
		return count;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	
}
class Pet { 
	private String type;
	public Pet(String type) { 
		this.type = type;
		}
	public String getPetType() { 
		return this.type; 
		}
}
class Dog extends Pet { 
	public int num;
	public Dog() { 
		super("dog");
		}
	}
class Cat extends Pet { 
	public Cat() { 
		super("cat"); 
		} 
	}
