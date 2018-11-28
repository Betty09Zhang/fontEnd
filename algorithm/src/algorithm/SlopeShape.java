package algorithm;

/**
 * @author SAMSUNG “之”字形打印矩阵 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这 个矩阵，例如： 1 2 3 4 5 6
 *         7 8 9 10 11 12 “之”字形打印的结果为：1，2，5，9，6，3，4，7，10，11， 8，12 【要求】
 *         额外空间复杂度为O(1)。
 */
public class SlopeShape {
	/**
	 * @param matrix
	 * @param tr A点行 
	 * @param tc A点列
	 * @param dr B点行
	 * @param dc B点列
	 * @param f 斜线方向
	 * 打印“之” 字形 斜线AB上的点,A点从MATRIX[0][0]向右移动，若到末端，向下移动；
	 * B点从MATRIX[0][0]向下移动，若到底端，向右移动
	 */
	public static void printSlope(int[][]matrix,int tr,int tc,int dr,int dc,boolean f){
		
		if(f){ //为真，向下打印
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
	
	/**找准矩阵的斜线端点坐标即方向,直到tc==dc
	 * @param matrix
	 */
	public static void print(int[][] matrix){
		int endC=matrix[0].length-1; //列宽；
		int endR=matrix.length-1; //行宽；
		boolean flag=false;
		//
		int tc=0;int tr=0;int dr=0;int dc=0;
		
		
		while(tr!=endR+1){
			printSlope(matrix, tr, tc, dr, dc, flag);
			 tr=tc==endC?tr+1:tr;
			 tc=tc==endC?tc:tc+1; //先向右走完tc    在向下
			 
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
