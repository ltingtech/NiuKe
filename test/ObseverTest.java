package test;

public class ObseverTest {

	public static void main(String[] args) {

	}

}

interface Observer{
	public void update();
}

class Observer1 implements Observer{
	public void update(){
		System.out.println("Observer1 have accepted");
	}
}
class Observer2 implements Observer{
	public void update(){
		System.out.println("Observer2 have accepted");
	}
}
