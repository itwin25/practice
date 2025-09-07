import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int ans;
	static int N;
	static int[] queens;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine()); // 퀸의 수
			ans = 0;

			queens = new int[N];
			queen(0);

			System.out.println("#" + test_case + " " + ans);
		}

	}

	private static void queen(int row) {
		if (row == N) {
			ans++; // 정답 개수 증가
			return;
		}
		int nr = row;

		for (int i = 0; i < N; i++) {
			boolean isOk = true;
			int nc = i;
			// 같은 열에 있는지
			for (int j = 0; j < row; j++) {
				if (queens[j] == nc) {
					isOk = false;
				}
			}
			// 대각선에 있는지
			for (int j = 0; j < row; j++) {
				if (Math.abs(nr - j) == Math.abs(nc - queens[j])) {
					isOk = false;
				}
			}

			if (isOk) {
				queens[nr] = nc;
				queen(row + 1);
			}
		}

	}
}