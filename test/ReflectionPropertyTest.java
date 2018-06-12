package test;

import java.io.*;

import java.util.Properties;

public class ReflectionPropertyTest {

	public static void main(String[] args) {
		try {
			Properties pro=init.initProperty();
			fruit apple=FruitFactory.getInstance(pro.getProperty("Apple"));
			apple.eat();
			fruit orange=FruitFactory.getInstance(pro.getProperty("Orange"));
			orange.eat();
			
			
		} catch (Exception e) {
		}

	}

}
interface fruit{
	public abstract void eat();
}
class Apple implements fruit{
	public void eat(){
		System.out.println("I am a apple");
	}
}
class Orange implements fruit{
	public void eat(){
		System.out.println("I am a orange");
	}
}
class init{
	public static Properties initProperty() throws FileNotFoundException,IOException
	{
		Properties property=new Properties();
		File file=new File("reflection.properties");
		if(file.exists()){
			property.load(new FileInputStream(file));
		}
		else {
			property.setProperty("Orange", "test.Orange");
			property.setProperty("Apple", "test.Apple");
			property.store(new FileOutputStream(file),"Fruit class");
		}
		return property;
	}
}
//简单工厂
class FruitFactory{
	public static fruit getInstance(String name)
	{
		fruit fruit=null;
		try {
			fruit=(fruit)Class.forName(name).newInstance();
		} catch (Exception e) {
		}
		return fruit;
	}
}
