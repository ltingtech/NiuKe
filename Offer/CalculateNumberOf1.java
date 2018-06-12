package Offer;

public class CalculateNumberOf1 {

	public static void main(String[] args) {
//		CalculateNumberOf1 instance=new CalculateNumberOf1();
//		int n=instance.NumberOf1Between1AndN_Solution(99);
//		System.out.println(n);
//		String st=Integer.toString(23);
//		System.out.println(st);
//		String st2=Integer.toString(34);
//		String s=st+st2;
//		String s2=st2+st;
//		System.out.println(s);
//		System.out.println(s2);
//		StringBuffer buffer=new StringBuffer();
//		buffer.append("ddf");
//		buffer.append(4);
//		String string=buffer.toString();
//		System.out.println(string);
		char a='a';
		char b='b';
		boolean c=a>b;
		System.out.println(c);
		

	}
	public int NumberOf1Between1AndN_Solution(int n) {
        int totalNum=0;
        if(n>0 && n<=9){
            totalNum=1;
        }
        if(n>9){
            //计算这个数有多少位
            int unitCount=1;
            int maxUnitNum=n;
            while((maxUnitNum/10)!=0){
                unitCount++;
                maxUnitNum/=10;
            }
            int restNum=n%(int)(Math.pow(10,unitCount-1));
            if(maxUnitNum>1){
                totalNum+=(int)Math.pow(10,unitCount-1); //最高位1的个数
                
            }
            else{
                totalNum+=restNum+1;  //最高位为1的情况；
            }                 
            int num=0;
            int restUnitNum=((unitCount-1)>0?(unitCount-1):0);
            if(restUnitNum>=1){
            	num=restUnitNum*(int)Math.pow(10,restUnitNum-1);
                }        
            totalNum+=(maxUnitNum*num);
            totalNum+=NumberOf1Between1AndN_Solution(restNum);
        }   
        return totalNum;
    
    }

}
