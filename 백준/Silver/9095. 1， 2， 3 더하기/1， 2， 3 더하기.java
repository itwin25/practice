import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, ans, sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine()); // 정수 n

			ans = 0; // 갯수
			sum = 0; // 현재 합

			back(0);

			System.out.println(ans);

		}

	}

	// 방법의 수 구하기
	private static void back(int sum) {
		// n을 넘어가면 종료
		if (sum > n) {
			return;
		}

		// n에 도달하면 ans 증가
		if (sum == n) {
			ans++;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			back(sum + i);
		}
	}
}
