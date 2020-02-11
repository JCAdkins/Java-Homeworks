import java.lang.reflect.Array;
import java.util.ArrayList;

public class GenericTester {

	public static void main(String[] args) {
		Car Honda = new Car(26.0);
		Car Ford = new Car(17.0);
		Car Chevy = new Car(24.0);
		Car Cadillac = new Car(19.0);
		Car Toyota = new Car(29.0);
		
		Car[] carComparison = new Car[5];
		
		carComparison[0]= Honda;
		carComparison[1]= Ford;
		carComparison[2]= Chevy;
		carComparison[3]= Cadillac;
		carComparison[4]= Toyota;
		
		Pair display = minMax(carComparison);
		System.out.println(display.getFirst());
		System.out.println(display.getSecond());
	
	}


	

public static <E extends Measurable> Pair minMax(E[] a) {
	
	Pair values = new Pair(a[0].getMeasure(),a[0].getMeasure());
	
	for(int i = 0; i < ((a.length)); i++) {
		if (a[i].getMeasure()< values.getFirst()){
			values.setFirst(a[i].getMeasure());;
		}
		if (a[i].getMeasure()>values.getSecond()){
			values.setSecond(a[i].getMeasure());
		}
	}
	
	return values;	
}

}
