package test;

public class FactoryModeTest {

	public static void main(String[] args) {
//		Car myBaomaCar=new BaomaFacotry().createCar();
//		myBaomaCar.drive();
//		Car myBenci=new BenciFactory().createCar();
//		myBenci.drive();
		Car baomaSport=new SportCarFactory().createBaoma();
		baomaSport.printDetailInfo();
		Car benciSport=new SportCarFactory().createBenci();
		benciSport.printDetailInfo();
		Car baomaBussiness=new BussinessCarFactory().createBaoma();
		baomaBussiness.printDetailInfo();
		Car benciBussiness=new BussinessCarFactory().createBenci();
		benciBussiness.printDetailInfo();
	}

}

/*********工厂设计模式*******************/
//interface CarFactory{
//	public Car createCar();
//}
//abstract class Car{
//	public abstract void drive();
//}
//class BaomaCar extends Car{
//	public void drive(){
//		System.out.println("this is a baoma");
//	}
//}
//class BenciCar extends Car{
//	public void drive(){
//		System.out.println("this is a benci");
//	}
//}
//class BaomaFacotry implements CarFactory{
//	public Car createCar(){
//		return new BaomaCar();
//	}
//}
//class BenciFactory implements CarFactory{
//	public Car createCar(){
//		return new BenciCar();
//	}
//}

/*****************抽象工厂模式*************************/
abstract class Car{
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public abstract void printDetailInfo();
}

class BaomaSportCar extends Car{
	public void printDetailInfo(){
		System.out.println("this is a Baoma Sport car");
	} 
}
class BaomaBussinessCar extends Car{
	public void printDetailInfo(){
		System.out.println("this is a Baoma bussiness car");
	}
}

class BenciSportCar extends Car{
	public void printDetailInfo(){
		System.out.println("this is a Benzi sport car");
	}
}

class BenciBussinessCar extends Car{
	public void printDetailInfo(){
		System.out.println("this is a benci Bussiness car");
	}
}

abstract class CarFactory{
	public abstract Car createBaoma();
	public abstract Car createBenci();
}
class SportCarFactory extends CarFactory{
	public Car createBaoma(){
		return new BaomaSportCar();
	}
	public Car createBenci(){
		return new BenciSportCar();
	}
}
class BussinessCarFactory extends CarFactory{
	public  Car createBaoma(){
		return new BaomaBussinessCar();
	}
	public  Car createBenci(){
		return new BenciBussinessCar();
	}
}


