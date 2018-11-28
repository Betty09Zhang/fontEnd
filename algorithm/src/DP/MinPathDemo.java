package DP;

public class MinPathDemo {

	public static int[][] processDPValue(int[][] matrix){
		int height=matrix.length-1;
		System.out.println("height:"+height);
		int width=matrix[0].length-1;
		System.out.println("width: "+width);
		int[][] dp=new int[width+1][height+1];
		dp[width][height]=matrix[width][height];
		if(matrix==null || matrix.length==0 ){
			return null;
		}
		//确定最后一行和最后一列的数据；
		for(int j=width;j>0;j--){
			dp[height][j-1]=matrix[height][j-1]+dp[height][j];
		}
		for(int i=height;i>0;i--){
			dp[i-1][width]=matrix[i-1][width]+dp[i][width];
		}
		for(int k=width-1;k>=0;k--){
			for(int m=height-1;m>=0;m--){
				dp[k][m]=matrix[k][m]+Math.min(dp[k][m+1], dp[k+1][m]);
				System.out.println("dp[k][m]:"+dp[k][m]+" k "+k +" m "+m);
			}
		}
		return dp;
	}
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		int[][] dp=processDPValue(m);
		for(int i=0;i<dp[0].length;i++){
			for(int j=0;j<dp.length;j++){
				System.out.print(dp[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
