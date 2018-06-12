package Offer;


public class ReplaceCharInStr {

	public static void main(String[] args) {
		StringBuffer strBuff=new StringBuffer("We Are Happy.");
		String result=replaceChar(null);
//		System.out.println(result);

	}
	public static String replaceChar(StringBuffer strBuff){
		if(strBuff==null){
			return null;
		}
		else {
			String repStr="%20";
			int index=-1;
			do {
				index=strBuff.indexOf(" ");
				if(index>=0){
					strBuff.replace(index, index+1, repStr);  //注意endIndx一定要比firstIndx大
				}
			} while (index>=0);
			return strBuff.toString();
		}
	}

}
