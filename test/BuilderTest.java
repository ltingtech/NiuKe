package test;

import java.util.*;

public class BuilderTest  
{
	public static void main (String[] args) 
	{
		builder b = new builder();
		b.builderNameSender(5);
		for(int i=0;i<b.senderList.size();i++)
		{
			b.senderList.get(i).send();
		}
		
	}
}

interface sender{
    public void send();
}
class nameSender implements sender{
    public void send(){
        System.out.println("name...");
    }
}
class ageSender implements sender{
    public void send(){
        System.out.println("age...");
    }
}
class builder{
    List<sender> senderList = new ArrayList<sender>();
    public void builderNameSender(int count){
        for(int i=0;i<count;i++){
            senderList.add(new nameSender());
        }
        
    }
    public void  builderAgeSender(int count){
        for(int i=0;i<count;i++){
            senderList.add(new ageSender());
        }
    }
}
