package DP;

public class HanoTower {

	
	/**
	 * @param N   ��ʾ��ŵ���Ĳ���
	 * @param from  ��ʾԭʼλ��
	 * @param to    ��ʾ�յ�λ��
	 * @param help  ��ʾ������
	 * 
	 * ˼·�������ϲ�N-1 ������from �ƶ���help ,N �ŵ�to ,
	 * ���N-1 ��help �ƶ� ����from �ƶ��� to
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
