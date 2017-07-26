
public class Power {
	public double Power(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
        	result *= base;
        }
        if (exponent > 0) {
        	return result;
        } else {
        	return 1 / result;
        }
	}
}
