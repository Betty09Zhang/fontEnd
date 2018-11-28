package algorithm;

/**
 * @author SAMSUNG
 *תȦ��ӡ����
����Ŀ�� ����һ�����;���matrix���밴��תȦ�ķ�ʽ��ӡ����
���磺 1 2 3 4 5 6 7 8 9 10 11 12 13 14
15 16 ��ӡ���Ϊ��1��2��3��4��8��12��16��15��14��13��9��
5��6��7��11�� 10
��Ҫ�� ����ռ临�Ӷ�ΪO(1)��
 */
public class PrintCircleMatrix {

	
	public static void printNum(int[][] matrix,int tr,int tc,int dr,int dc){
		
		//�����ӡ���ǰ�״һ������tr  dr
		if(tr==dr){
			for(int i=tc;i<=dc;i++){
				System.out.print(matrix[tr][i]);
			}
		}
		else if(tc==dc){
			for(int j=tr;j<=dr;j++){
				System.out.print(matrix[j][tc]); //��ӡһ��
			}
		}
		else{
			int curtc=tc;
			int curtr=tr;
			while(curtc!=dc){
				System.out.print(matrix[tr][curtc++]+" ");
			}
			while(curtr!=dr){
				System.out.println(matrix[curtr++][dc]+ " ");
			}
			while(curtc!=tc){
				System.out.println(matrix[dr][curtc--]+ " ");
			}
			while(curtr!=tr){
				System.out.println(matrix[curtr--][tc] + " ");
			}
		}
	}
	
	/**
	 * @param matrix ���ϽǺ����½Ƿֱ������º�����б���ƶ� 1px;
	 */
	public static void circlePrint(int[][] matrix){
		int m=matrix.length-1;
		int n=matrix[0].length-1;
		int i=0,j=0;
		while(i<=m && j<=n){  //���д�����ʱ
			printNum(matrix, i++, j++, m--, n--);
		}
		
	}
	public static void main(String[] args) {
		int[][] matrix={{1,2,3,4},{5,0,7,8},{9,10,11,12}};
		circlePrint(matrix);
	}
	

}
