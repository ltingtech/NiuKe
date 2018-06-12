package onlinetest;


public class WeightCompare {

	public static void main(String[] args) {
		WeightCompare instance=new WeightCompare();
		int g1=1,g2=3;
		int[][] records=new int[][]{{1,2},{2,4},{3,4},{4,5}};
		int n=4;
		int result=instance.cmp(g1, g2, records, n);
		System.out.println(result);

	}
	 public int cmp(int g1, int g2, int[][] records, int n) {
	       if(records==null||records.length<=0||records.length!=n){
	            return 0;
	        }
	        boolean isG1Biger=isABigerThanB(g1, g2, records, n);
	        boolean isG2Biger=isABigerThanB(g2, g1, records, n);
	        if(isG1Biger){
	        	return 1;
	        }
	        if(isG2Biger){
	        	return -1;
	        }
	        return 0;
	        
	    }
		public boolean isABigerThanB(int A,int B,int[][] records,int n){
	        if(records==null||records.length<=0){
	            return false;
	        }
			boolean result=false;
			for(int i=0;i<n;i++){
				if(!result)
				{
					if(records[i][0]==A){
						if(records[i][1]==B){
							result=true;
							break;
						}
						else {
							result=isABigerThanB(records[i][1], B, records, n);
						}
					}
				}
				else{
					break;
				}
			}
			return result;
		}

}
