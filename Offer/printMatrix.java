package Offer;

import java.util.ArrayList;

public class printMatrix {

	public static void main(String[] args) {
		double[][] matrix=new double[][]{{1,2,3,4,30},
				{5,6,7,8,31},{9,10,11,12,32},{13,14,15,16,33},{20,21,22,23,34}};
		matrixPrint(matrix, 4, 4, 0);
	}
	public static void matrixPrint(double[][] matrixData,int rows,int colums,int start)
	{
		if(matrixData==null || rows<=0 || colums<=0){
			return ;
		}
		else {
			if(rows>2*start && colums>2*start){
				print(matrixData, rows, colums, start);
				matrixPrint(matrixData, rows, colums, start+1);
			}
			else {
				return;
			}
		}
	}
	private static void print(double[][] matrixData,int rows,int colums,int start){
		if(matrixData==null || rows<=0 || colums<=0||start>rows/2)
		{
			return;
		}
		else {
			int endX=rows-start-1;
			int endY=colums-start-1;
			for(int i=start;i<=endY;i++)
			{
				System.out.println(matrixData[start][i]);
			}
			if(start<endX ){
				for(int i=start+1;i<=endX;i++)
				{
					System.out.println(matrixData[i][endY]);
				}
			}
			if(start<endX && start<endY){
				for(int j=endY-1;j>=start;j--)
				{
					System.out.println(matrixData[endX][j]);
				}
			}
			if(start<endY && start<endX-1)
			{
				for(int j=endX-1;j>start;j--)
				{
					System.out.println(matrixData[j][start]);
				}
			}
		}
	}

	public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result=new ArrayList<Integer>();
       if(matrix==null){
           result=null;
       }
        else{
            int colums=matrix[0].length;
            int rows=matrix.length;
            int row_first=0,row_end=rows-1;
            int col_first=0,col_end=colums-1;
            while(row_end>=row_first && col_end>=col_first){
                result.add(new Integer(matrix[row_first][col_first]));
                if(col_end>col_first){
                    for(int i=col_first+1;i<=col_end;i++){
                        result.add(new Integer(matrix[row_first][i]));
                    }
                }
                if(row_end>row_first){
                    for(int i=row_first+1;i<=row_end;i++){
                        result.add(new Integer(matrix[i][col_end]));
                    }
                }
                if(row_end>row_first && col_end>col_first){
                    for(int i=col_end-1;i>=col_first;i--){
                        result.add(new Integer(matrix[row_end][i]));
                    }
                }
                if((row_end-row_first)>=2 && col_end>col_first ){
                    for(int i=row_end-1;i>row_first;i--){
                        result.add(new Integer(matrix[i][col_first]));
                    }
                }
                //更新行列起始坐标
                row_first++;
                row_end--;
                col_first++;
                col_end--;
            }
        }
        return result;
    }
}
