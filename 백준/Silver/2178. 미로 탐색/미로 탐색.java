import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[][] map;
	static int N, M;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
		min = 987654321;
		bfs(0, 0, 1); // 시작 위치

	} // main

	private static void bfs(int r, int c, int cnt) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { r, c, cnt });

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[0] == N - 1 && now[1] == M - 1) {
				System.out.println(now[2]);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				if (nr < N && nr >= 0 && nc < M && nc >= 0 && map[nr][nc] != 0) {
					map[nr][nc] = 0; // 방문표시
					q.offer(new int[] { nr, nc, now[2] + 1 });
				}
			}
		}
	}
}