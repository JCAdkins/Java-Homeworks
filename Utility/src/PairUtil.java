
public class PairUtil<T, S> {
	
	
	
	
	public static <E extends Measurable> Pair minMax(E[] a) {
		
		Pair values = new Pair(0.0,0.0);
		for(int i = 0; i < ((a.length)-1); i++) {
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
