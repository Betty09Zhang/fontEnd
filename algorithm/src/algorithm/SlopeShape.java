package algorithm;

/**
 * @author SAMSUNG ��֮�����δ�ӡ���� ����Ŀ�� ����һ������matrix�����ա�֮�����εķ�ʽ��ӡ�� ���������磺 1 2 3 4 5 6
 *         7 8 9 10 11 12 ��֮�����δ�ӡ�Ľ��Ϊ��1��2��5��9��6��3��4��7��10��11�� 8��12 ��Ҫ��
 *         ����ռ临�Ӷ�ΪO(1)��
 */
public class SlopeShape {
	/**
	 * @param matrix
	 * @param tr A���� 
	 * @param tc A����
	 * @param dr B����
	 * @param dc B����
	 * @param f б�߷���
	 * ��ӡ��֮�� ���� б��AB�ϵĵ�,A���MATRIX[0][0]�����ƶ�������ĩ�ˣ������ƶ���
	 * B���MATRIX[0][0]�����ƶ��������׶ˣ������ƶ�
	 */
	public static void printSlope(int[][]matrix,int tr,int tc,int dr,int dc,boolean f){
		
		if(f){ //Ϊ�棬���´�ӡ
			while(tr!=dr+1){
				System.out.println(matrix[tr++][tc--]+" ");
			}
		}
		else{
			while(dr!=tr-1){
				System.out.println(matrix[dr--][dc++]+" ");
			}
			
		}
	}
	
	/**��׼�����б�߶˵����꼴����,ֱ��tc==dc
	 * @param matrix
	 */
	public static void print(int[][] matrix){
		int endC=matrix[0].length-1; //�п�
		int endR=matrix.length-1; //�п�
		boolean flag=false;
		//
		int tc=0;int tr=0;int dr=0;int dc=0;
		
		
		while(tr!=endR+1){
			printSlope(matrix, tr, tc, dr, dc, flag);
			 tr=tc==endC?tr+1:tr;
			 tc=tc==endC?tc:tc+1; //����������tc    ������
			 
			 dc=dr==endR?dc+1:dc;
			 dr=dr==endR?dr:dr+1;
			
			flag=!flag;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		print(matrix);
	}
	
}
