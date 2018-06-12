package Offer;

public class PowerFunction {

	public static void main(String[] args) {
		PowerFunction function=new PowerFunction();
		try {
			double result=function.Power(2.0, 3);
			System.out.println(result);
		} catch (Exception e) {
		}
		

	}
	public double Power(double base, int exponent) throws Exception {
        if(equal(base,0.0)&& exponent<0){
            throw new Exception("divided by zero");
        }
        else{
            double result=0.0;
            if(exponent>0)
                {
                result=powerWithUnsignedExp(base,exponent);
            }
            else{
                result=1/powerWithUnsignedExp(base,-1*exponent);
            }
            return result;
        }
        
  }
    private double powerWithUnsignedExp(double base,int exponent){
        if(equal(base,0.0)){
            return 1;
        }
        else{
            if(exponent==0){
                return 1;
            }
            double halfExp=powerWithUnsignedExp(base,exponent>>1);
            double result=0.0;
            if((exponent&1)==0){
                result=halfExp*halfExp;
            }
            else{
                result=halfExp*halfExp*base;
            }
            return result;
        }
    }
    private boolean equal(double num1,double num2)
        {
        if((num1-num2)<0.00000001&&(num1-num2)>-0.00000001){
            return true;
        }
        else{
            return false;
        }
    }

}
