
public class Car implements Measurable {

	double gasMileage;
	
	public Car(double a) {
		gasMileage = a;
	}
	

	@Override
	public double getMeasure() {
		
		return gasMileage;
	}
}
