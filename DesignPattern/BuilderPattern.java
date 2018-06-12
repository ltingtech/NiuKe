package DesignPattern;

public class BuilderPattern {

	public static void main(String[] args) {
		BusBuilder busBuilder=new BusBuilder();
		Director director=new Director();
		Product product=director.buildAndGet(busBuilder);
		System.out.println(product.toString());
		CarBuilder carBuilder=new CarBuilder();
		product=director.buildAndGet(carBuilder);
		System.out.println(product.toString());
	}
}

//产品类
class Product{
	private int wheelNum;
	private int capacity;
	private String type;
	public int  getWheelNum(){
		return wheelNum;
	}
	public void setWheelNum(int num){
		this.wheelNum=num;
	}
	public int getCapacity(){
		return capacity;
	}
	public void setCapacity(int c){
		this.capacity=c;
	}
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type=type;
	}
	
	public String toString(){
		return "WheelNum: "+wheelNum+" Capacity: "+capacity+" Type: "+type; 
	}
}
//汽车建造者抽象类
abstract class AbstractBuilder{
	public abstract void setWheelNum();
	public abstract void setCapacity();
	public abstract void setType();
	public abstract Product getProduct();
}
//具体建造者类1
class BusBuilder extends AbstractBuilder{
	private Product product=new Product();
	public void setWheelNum()
	{
		product.setWheelNum(8);
	}
	public void setCapacity(){
		product.setCapacity(20);
	}
	public void setType(){
		product.setType("Bus");
	}
	//需要一个返回产品的实例方法
	public Product getProduct(){
		return product;
	}
}
class CarBuilder extends AbstractBuilder{
	private Product product=new Product();
	public void setWheelNum()
	{
		product.setWheelNum(4);
	}
	public void setCapacity(){
		product.setCapacity(4);
	}
	public void setType(){
		product.setType("Car");
	}
	//需要一个返回产品的实例方法
	public Product getProduct(){
		return product;
	}
}

//指导者类
class Director{
	public Product buildAndGet(AbstractBuilder build){
		build.setWheelNum();
		build.setCapacity();
		build.setType();
		return build.getProduct();
	}
}
