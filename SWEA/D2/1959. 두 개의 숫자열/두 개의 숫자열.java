import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // Aj의 길이
			int M = sc.nextInt(); // Bj의 길이
			int max = 0; // sum 중에서 최댓값
			int[] Aj = new int[N];
			int[] Bj = new int[M];

			// Aj 배열에 값 넣기
			for (int i = 0; i < N; i++) {
				Aj[i] = sc.nextInt();
			}

			// Bj 배열에 값 넣기
			for (int i = 0; i < M; i++) {
				Bj[i] = sc.nextInt();
			}

			// Aj가 더 긴 경우
			if (N < M) {
				for (int i = 0; i <= M - N; i++) {
					int sum = 0; // 곱하고 더한 값
					for (int j = 0; j < N; j++) {
						sum += Aj[j] * Bj[i + j];
					}
					max = Math.max(max, sum);
				}
				// Bj가 더 긴 경우
			} else if (M < N) {
				for (int i = 0; i <= N - M; i++) {
					int sum = 0; // 곱하고 더한 값
					for (int j = 0; j < M; j++) {
						sum += Aj[i + j] * Bj[j];
					}
					max = Math.max(max, sum);
				}
			}
			// Aj, Bj의 길이가 같은 경우
			else {
				for (int i = 0; i < N; i++) {
					max += Aj[i] * Bj[i];
				}
			}

			System.out.println("#" + test_case + " " + max);
		} // tc
	}
}