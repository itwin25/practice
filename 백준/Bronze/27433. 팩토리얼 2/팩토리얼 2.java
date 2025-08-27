import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger N = sc.nextBigInteger();
		BigInteger ans = facto(N);
		System.out.println(ans);
	} // main

	static BigInteger facto(BigInteger N) {
		if (N.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		}
		return N.multiply(facto(N.subtract(BigInteger.ONE)));
	}
}
