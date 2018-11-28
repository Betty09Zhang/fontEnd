package algorithm;

/**
 * @author SAMSUNG
 *转圈打印矩阵
【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
例如： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
15 16 打印结果为：1，2，3，4，8，12，16，15，14，13，9，
5，6，7，11， 10
【要求】 额外空间复杂度为O(1)。
 */
public class PrintCircleMatrix {

	
	public static void printNum(int[][] matrix,int tr,int tc,int dr,int dc){
		
		//如果打印的是棒状一行数据tr  dr
		if(tr==dr){
			for(int i=tc;i<=dc;i++){
				System.out.print(matrix[tr][i]);
			}
		}
		else if(tc==dc){
			for(int j=tr;j<=dr;j++){
				System.out.print(matrix[j][tc]); //打印一列
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
	 * @param matrix 左上角和右下角分别向左下和右上斜角移动 1px;
	 */
	public static void circlePrint(int[][] matrix){
		int m=matrix.length-1;
		int n=matrix[0].length-1;
		int i=0,j=0;
		while(i<=m && j<=n){  //当行大于列时
			printNum(matrix, i++, j++, m--, n--);
		}
		
	}
	public static void main(String[] args) {
		int[][] matrix={{1,2,3,4},{5,0,7,8},{9,10,11,12}};
		circlePrint(matrix);
	}
	

}
