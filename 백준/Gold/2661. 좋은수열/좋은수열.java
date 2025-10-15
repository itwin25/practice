import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
	static int N;
	static StringBuilder num;
	static TreeSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 수열의 길이

		num = new StringBuilder();
		num.append("1"); // 맨 앞자리 1 미리 넣어놓기

		sequence(1);
	}

	// 모든 조합 찾기
	private static void sequence(int cnt) {
		if (cnt == N) {
			System.out.println(num);
			System.exit(0);
		}

		for (int i = 1; i <= 3; i++) {
			num.append(i);

			// 좋은 수열을 만족하는지 확인
			boolean isOk = true; // true: 좋은 수열, false: 나쁜 수열
			for (int j = 1; j <= num.length() / 2; j++) { // j는 이번에 확인할 부분 수열의 길이
				for (int k = 0; j + k <= num.length() - j; k++) {
					String tmp1 = num.substring(k, k + j);
					String tmp2 = num.substring(k + j, k + j + j);
					// 인접한 두 개의 부분 수열이 동일하다
					if (tmp1.equals(tmp2)) {
						isOk = false;
					}
				}
			}

			// 좋은 수열이면 계속 진행
			if (isOk) {
				sequence(cnt + 1);
			}

			num.setLength(num.length() - 1);
		}
	}

}
