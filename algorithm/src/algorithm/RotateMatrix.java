package algorithm;

/**
 * @author SAMSUNG
 *旋转正方形矩阵
【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成
顺时针旋转90度的样子。0
 */
public class RotateMatrix {

	
	/** 局部到整体 先输出边缘
	 * @param matrix
	 */
	public static  void rotate(int[][] matrix){
		int dr=matrix.length-1;
		int dc=matrix[0].length-1;
		int i=0;
		int j=0;
		while(i<dr){
			rotateEdge(matrix, i++, j++, dr--, dc--);
			
		}
	}
	
	/**
	 * @param matrix
	 * @param tr 左上角横 纵坐标
	 * @param tc
	 * @param dr 右下角横纵坐标
	 * @param dc
	 */
	public static void rotateEdge(int[][] matrix,int tr,int tc,int dr,int dc){
		int times=dr-tr;
		for(int i=0;i!=times;i++){
			
			int temp=matrix[tr+i][dc];
			matrix[tr+i][dc]=matrix[tr][tc+i];
			
			matrix[tr][tc+i]=matrix[dr-i][tc];
			matrix[dr-i][tc]=matrix[dr][dc-i];
			matrix[dr][dc-i]=temp;
			
		}
	}
	public static void printMatrix(int[][] matrix){
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("=========");
		printMatrix(matrix);

	}
}
