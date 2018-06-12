package huawei;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
	private final String  createHead="starttimer:";
	private final String elapseHead="elapse:";
	private final String stopHeadString="stoptimer:";
	private final String endHead="end";
	public static void main(String[] args) {
		Main instance=new Main();
		instance.process();
		

	}
	public void process(){
		Scanner in=new Scanner(System.in);
		String command="";
		HashMap<Integer, Integer> timeerMap=new HashMap<Integer, Integer>();
		while(in.hasNextLine()){
			command=in.nextLine();
			if(command.startsWith(createHead)){
				int index=command.indexOf(',');
				Integer k=Integer.valueOf(Integer.parseInt(command.substring(createHead.length(), index)));
				Integer v=Integer.valueOf(Integer.parseInt(command.substring(index+1)));
				if(timeerMap.containsKey(k))
				{
					Integer lstCount=timeerMap.get(k);
					timeerMap.remove(k);
					v+=lstCount;
					timeerMap.put(k, v);
				}
				else {
					timeerMap.put(k, v);
				}
				continue;
			}
			if(command.startsWith(elapseHead)){
				int elapsedTime=Integer.parseInt(command.substring(elapseHead.length()));
				Integer count=Integer.valueOf(0);
				Iterator iter=timeerMap.entrySet().iterator();
				while(iter.hasNext())
				{
					Entry entry=(Entry)iter.next();
					count=(Integer)entry.getValue();
					Integer key=(Integer)entry.getKey();
					if(count.intValue()<=elapsedTime)
					{
						count=Integer.valueOf(0);
						timeerMap.put(key,count);
					}
					else {
						count-=Integer.valueOf(elapsedTime);
						timeerMap.put(key, count);
					}
				}
				continue;
			}
			if(command.startsWith(stopHeadString))
			{
				Integer key=Integer.valueOf(Integer.parseInt(command.substring(stopHeadString.length())));
				if(timeerMap.containsKey(key))
				{
					timeerMap.remove(key);
				}
				continue;
			}
			if(command.startsWith(endHead)){
				boolean flag=true;
				if(timeerMap.isEmpty())
				{
					System.out.println("none");
				}
				else {
						Iterator iterator=timeerMap.entrySet().iterator();
						while(iterator.hasNext()){
							Entry entry=(Entry)iterator.next();
							Integer key=(Integer)entry.getKey();
							Integer count=(Integer)entry.getValue();
							if(count.intValue()<=0)
							{
								continue;
							}
							else {
								System.out.println("timer:"+key.intValue()+","+count.intValue());
								flag=false;
							}
						}
						if(flag)
						{
							System.out.println("none");
						}
				}
				
				break;
			}
				
			}

	}


}
