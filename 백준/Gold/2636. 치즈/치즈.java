import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] cheese;
	static boolean[][] visited;
	static int cnt, h, w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		h = Integer.parseInt(st.nextToken()); // 치즈 세로
		w = Integer.parseInt(st.nextToken()); // 치즈 가로
		cheese = new int[h][w];
		cnt = 0; // 치즈 초기 갯수

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				cheese[i][j] = tmp;
				// 치즈 세기
				if (tmp == 1) {
					cnt++;
				}
			}
		}

		int left = 0; // 남은 치즈 개수
		int time = 0; // 걸린 시간

		// 치즈 판 탐색(테두리 제외)
		while (cnt != 0) {
			visited = new boolean[h][w]; // 방문 배열 초기화
			left = cnt; // 현재 남은 치즈 개수

			find(0, 0); // bfs 진행

			time++; // 시간 증가

		}

		System.out.println(time);
		System.out.println(left);

	}

	static int[] dr = { 0, 1, 0, -1 }; // 우하좌상
	static int[] dc = { 1, 0, -1, 0 };

	// bfs로 치즈 가장자리 찾기
	private static void find(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { r, c });
		visited[r][c] = true; // 방문 표시

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int row = curr[0];
			int col = curr[1];

			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				// 범위 내에 있고 방문을 하지 않았다면
				if (nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc]) {
					// 치즈다!
					if (cheese[nr][nc] == 1) {
						cheese[nr][nc] = -1; // 치즈 녹음 표시
						cnt--; // 치즈 개수 1 감소

						// 공기다!
					} else if (cheese[nr][nc] == 0) {
						q.offer(new int[] { nr, nc }); // 큐에 넣기
						visited[nr][nc] = true; // 방문 표시
					}
				}
			}
		}

		// 녹은 치즈들 공기로 변환
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (cheese[i][j] == -1) {
					cheese[i][j] = 0;
				}
			}
		}

	}

}
