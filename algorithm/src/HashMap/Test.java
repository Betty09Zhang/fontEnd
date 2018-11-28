package HashMap;

public class Test {
    
	
	public static int getRandom(int size){
		int index=(int) Math.floor(Math.random()*(size));
		return index;
	}
	public static void main(String[] args) {
		int i=0;
		System.out.println(i++);//========>0
		System.out.println(i);//=========>1
		System.out.println(getRandom(9));
	}

}
