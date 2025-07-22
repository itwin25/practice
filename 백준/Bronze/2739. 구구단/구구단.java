import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력
		int N = sc.nextInt();

		// N에 대한 구구단 출력
		for (int i = 1; i < 10; i++) {
//			System.out.println(N + " * " + i + " = " + N * i);
			System.out.printf("%d * %d = %d\n", N, i, N * i);
		}
	}
}