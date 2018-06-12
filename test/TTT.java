package test;
import java.util.*;

public class TTT{
  public static void main(String[] args){
	int result=processs(3);
	System.out.println(result);
    }
  
  public static int processs(int n){
	  if(n<=0){
		  return 0;
	  }
	  else{
		  if(n==1){
			  return 3;
		  }
		  if(n==2){
			  return 9;
		  }
		  if(n>2){
			  int[][] arr=new int[2][n+1];
			  arr[0][2]=3;
			  arr[1][2]=6;
			  for(int i=3;i<=n;i++){	
				  arr[0][i]=arr[0][i-1]+arr[1][i-1];
				  arr[1][i]=arr[0][i-1]+arr[1][i-1]+3;
			  }
			  return arr[0][n]+arr[1][n];
			  
		  }
		  else{
			  return 0;
		  }
	  }
  }
  
}