import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {
	
	private Random random = new Random();


	public int addPositive(int a, int b) {
		if(a < 0 || b < 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return a + b;
	}
	
	public int randomNumberSquared() {
		int a = getRandomInt();
		return (a * a);
	}
	
	@VisibleForTesting
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) +1;
	}
	
}
