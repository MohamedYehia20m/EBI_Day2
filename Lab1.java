package EBI;

import java.util.function.Function;

public class Lab1 {

	public static void main(String[] args) {
		Function<Double, Double> degree = C -> (1.8*C + 32);
		
		Double F = degree.apply(40.0);
		System.out.println("Fahrenheit: " + F);

	}

}
