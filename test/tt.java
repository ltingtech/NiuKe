package test;

public class tt {

}

abstract class Component{}
class Engine extends Component{}
class UnderPan extends Component{}
class Wheel extends Component{}

abstract class Factory{
	public abstract Component produce();
}
class EngineFactory extends Factory{
	public Component produce(){
		return new Engine();
	}
}
class UnderPanFactory extends Factory{
	public Component produce(){
		return new UnderPan();
	}
}
class WheelFactory extends Factory{
	public Component produce(){
		return new Wheel();
	}
}
