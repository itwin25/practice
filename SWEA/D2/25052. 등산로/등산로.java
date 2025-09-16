import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static int[][] map;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine()); // 지도의 크기
			map = new int[N][N]; // 지도

			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}

			max = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, 1);
				}
			}

			System.out.println("#" + test_case + " " + max);

		} // tc
	} // main

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void dfs(int sR, int sC, int cnt) {
		int min = map[sR][sC];
		int mR = 0, mC = 0;

		// 4방향 탐색
		for (int i = 0; i < 4; i++) {
			int nr = sR + dr[i];
			int nc = sC + dc[i];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] < map[sR][sC]) {
				if (map[nr][nc] < min) {
					min = map[nr][nc];
					mR = nr;
					mC = nc;
				}
			}
		}

		if (min != map[sR][sC]) {
			dfs(mR, mC, cnt + 1);
		} else {
			max = Math.max(max, cnt);
			return;
		}
	}
}