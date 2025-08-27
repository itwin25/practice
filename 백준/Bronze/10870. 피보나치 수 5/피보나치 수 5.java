import java.util.Scanner;

public class Main {
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fibo(N));
	} // main

	static int fibo(int N) {
		if (N < 2) {
			return N;
		} else {
			return fibo(N - 2) + fibo(N - 1);
		}
	}
}
