package Offer;

public class FindNumInMatrix {

	public static void main(String[] args) {
		int[][] matrix=new int[][]{new int[]{1,2,8,9},new int[]{2,4,9,12},
				new int[]{4,7,10,13},new int[]{6,8,11,15}};
		boolean isFind=findNumInMatrix(matrix, 5);
		System.out.println(isFind);
		

	}
	public static boolean findNumInMatrix(int[][] dataMatrix,int data){
		boolean result=false;
		if(dataMatrix==null){  //在刚开始判断为null时不能去获得length，若为null则获取length时报异常
			result=false;
		}
		else {
			int columns=dataMatrix[0].length;
			int rows=dataMatrix.length;
			int column=columns-1;
			int row=0;
			while(column>=0 && row<=rows-1){
				if(data==dataMatrix[row][column])
				{
					result=true;
					break;
				}
				else {
					if(data>dataMatrix[row][column]){
						row++;
						continue;
					}
					else {
						column--;
						continue;
					}
				}
			}
			
		}
		return result;
	}

}
