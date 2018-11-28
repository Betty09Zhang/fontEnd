package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SAMSUNG
 *猫狗队列 【题目】 宠物、狗和猫的类如下：
public class Pet { private String type;
public Pet(String type) { this.type = type; }
public String getPetType() { return this.type; }
}
public class Dog extends Pet { public Dog() { super("dog"); } }
public class Cat extends Pet { public Cat() { super("cat"); } }
实现一种狗猫队列的结构，要求如下： 用户可以调用add方法将cat类或dog类的
实例放入队列中； 用户可以调用pollAll方法，将队列中所有的实例按照进队列
的先后顺序依次弹出； 用户可以调用pollDog方法，将队列中dog类的实例按照
进队列的先后顺序依次弹出； 用户可以调用pollCat方法，将队列中cat类的实
例按照进队列的先后顺序依次弹出； 用户可以调用isEmpty方法，检查队列中是
否还有dog或cat的实例； 用户可以调用isDogEmpty方法，检查队列中是否有dog
类的实例； 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。
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
		
		//判空处理
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
	 * 重新定义 类  这个类包含动物的类型  及排序；
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
