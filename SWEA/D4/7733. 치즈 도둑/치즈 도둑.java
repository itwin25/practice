import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N; // NxN
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			cheese = new int[N][N];

			// 치즈 맛 정보
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 1; // 최대 덩어리 수

			for (int day = 1; day <= 100; day++) {

				// 치즈 갉아먹기
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (cheese[i][j] == day) {
							cheese[i][j] = 0;
						}
					}
				}

				visited = new boolean[N][N];
				int cnt = 0;
				// 덩어리 개수 세기
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (cheese[i][j] != 0 && !visited[i][j]) {
							bfs(i, j); // 연결된 곳 전부 방문
							cnt++;
						}
					}
				}
				ans = Math.max(ans, cnt);
			}

			System.out.println("#" + test_case + " " + ans);

		} // tc
	} // main

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c }); // 처음 좌표
		visited[r][c] = true; // 방문 처리

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currR = curr[0];
			int currC = curr[1];

			for (int i = 0; i < 4; i++) {
				int nr = currR + dr[i];
				int nc = currC + dc[i];
				// 범위 안 + 먹지 않은 치즈 + 방문하지 않음
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && cheese[nr][nc] != 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}
	}

}
