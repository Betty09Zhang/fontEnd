package DP;

public class HanoTower {

	
	/**
	 * @param N   表示汉诺塔的层数
	 * @param from  表示原始位置
	 * @param to    表示终点位置
	 * @param help  表示辅助杆
	 * 
	 * 思路：考虑上层N-1 层塔从from 移动到help ,N 放到to ,
	 * 最后：N-1 从help 移动 借助from 移动到 to
	 */
	public static void process(int N,String from,String to,String help){
		if(N==1){
			System.out.println("Move: 1"+"from"+from+"to   "+to);
		}
		else{
			process(N-1,from,help,to);
			System.out.println("Move:"+N+"from"+from+"to   "+to);
			
			process(N-1,help,to,from);
		}
		
	}
	public static void main(String[] args) {
		process(3,"1","3","2");
	}
}
