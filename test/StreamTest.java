package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class StreamTest {
	public static void main(String[] args)
	{
		int x=5;
		int y=3;
		int z=2;
		x=y+(++z+x++)+(++x)+x;
		System.out.println(x);
//		try
//		{
//			OutputStream os=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\11.txt");
//			BufferedOutputStream buffout=new BufferedOutputStream(os);
//			int j=0;
//			while(j<100){
//				buffout.write("jkdfjak我们".getBytes());
//				j++;
//			}
//			buffout.close();
//			os.close();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		try{
//			InputStream is=new FileInputStream("C:\\Users\\Administrator\\Desktop\\11.txt");
//			BufferedInputStream buffstr=new BufferedInputStream(is);
//			byte[] data=new byte[2];
//			int i=0;
//			while(i<100)
//			{
//				buffstr.read(data);
//				String contentString=new String(data,"GBK");
//				System.out.println(contentString);
//				i+=1;
//			}
//			buffstr.close();
//			is.close();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
		/*******************************************/
//		try{
//			FileWriter fw=new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\12.txt"));
//			BufferedWriter buffw=new BufferedWriter(fw);
//			int count=0;
//			while(count<10)
//			{
////				fw.write("dkdjgi");
//				buffw.write("china is a 我是一个兵\n");
//				count++;
//			}
//			
//			buffw.close();
//			fw.close();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		try {
//			FileReader fr=new FileReader(new File("C:\\Users\\Administrator\\Desktop\\12.txt"));
//			BufferedReader buffr=new BufferedReader(fr);
//			int num=0;
//			char[] data=new char[5];
//			while(num<10){
//				num++;
//				System.out.println(buffr.readLine());
////				fr.read(data);
////				System.out.println(new String(data));
//			}
//			
//			buffr.close();
//			fr.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		/******************************************/
//		try {
//			FileOutputStream fou=new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\12.txt"));
//			BufferedWriter buffw=new BufferedWriter(new OutputStreamWriter(fou));
//			int count=0;
//			while(count<10)
//			{
//				buffw.write("jdikd我擦类\n");
//				count++;
//			}
//			buffw.close();
//			fou.close();
//			
//		} catch (Exception e) {
//			
//		}
//		try{
//			FileInputStream fin=new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\12.txt"));
//			BufferedReader buffr=new BufferedReader(new InputStreamReader(fin));
//			int count=0;
//			while(count<10){
//				count++;
//				System.out.println(buffr.readLine());
//			}
//			buffr.close();
//			fin.close();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		
	}

}
