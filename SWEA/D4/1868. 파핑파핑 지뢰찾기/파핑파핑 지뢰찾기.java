import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static char[][] map;
	static int N;
	static int ans;
	static int[][] landMine;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}

			ans = 0;
			landMine = new int[N][N];
			for (int[] tmp : landMine) {
				Arrays.fill(tmp, -1);
			}

			// 0인 칸 찾기 (주변 8칸에 지뢰x)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = 0;
					if (map[i][j] == '.') {
						for (int d = 0; d < 8; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								if (map[nr][nc] == '*') {
									cnt++;
								}
							}
						}
						landMine[i][j] = cnt; // 지뢰의 개수 계산
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 지뢰가 없는 칸이면 클릭!
					if (landMine[i][j] == 0) {
						landMine[i][j] = -1; // 이미 클릭했음
						map[i][j] = '0';
						bfs(i, j);
						ans++;
					}
				}
			}

			// 이제 남은 칸들 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						ans++;
					}
				}
			}

			System.out.println("#" + test_case + " " + ans);

		} // tc
	} // main

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int R = curr[0];
			int C = curr[1];

			// 시작 지점의 8방향
			for (int i = 0; i < 8; i++) {
				int nr = R + dr[i];
				int nc = C + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					int cnt2 = landMine[nr][nc];
					if (cnt2 > 0) {
						map[nr][nc] = (char) (cnt2 + '0');
					} else if (cnt2 == 0) {
						landMine[nr][nc] = -1; // 클릭 했음
						map[nr][nc] = '0';
						q.offer(new int[] { nr, nc });
					}
				}
			}

		}

	}

}
