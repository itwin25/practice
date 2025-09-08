import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	static int N; // NxN
	static int[][] cheese;
	static int[][] tmp;
	static int cnt;
	static int ans;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 1;
			bfs(1);
			System.out.println("#" + test_case + " " + ans);

		} // tc
	} // main

	private static void bfs(int day) {
		if (day > 100) {
			return;
		}

		cnt = 0;

		// 치즈 갉아먹기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cheese[i][j] == day) {
					cheese[i][j] = 0;
				}
			}
		}
		// 복사본
		tmp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = cheese[i][j];
			}
		}

		// 덩어리 수 세기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (tmp[i][j] != 0) {
					tmp[i][j] = 0;
					piece(i, j);
					cnt++;
				}
			}
		}
		ans = Math.max(ans, cnt);
		bfs(day + 1); // 다음날
	}

	// 덩어리 찾기
	static void piece(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < N && nr >= 0 && nc < N && nc >= 0 && tmp[nr][nc] != 0) {
				tmp[nr][nc] = 0;
				piece(nr, nc);
			}
		}
	}
}
