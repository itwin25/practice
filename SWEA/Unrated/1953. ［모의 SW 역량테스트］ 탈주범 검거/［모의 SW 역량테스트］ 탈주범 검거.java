import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int M;
	static int L;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cnt;
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 행 크기
			M = Integer.parseInt(st.nextToken()); // 열 크기
			int R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 행
			int C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 열
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 1;
			visited = new boolean[N][M];
			bfs(R, C, 1);

			System.out.println("#" + test_case + " " + cnt);

		} // tc
	} // main

	private static void bfs(int R, int C, int time) {
		q = new LinkedList<>();
		q.add(new int[] { R, C, time }); // 처음 좌표 (뚜껑)
		visited[R][C] = true; // 방문 처리

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currR = curr[0];
			int currC = curr[1];

			int type = map[currR][currC];

			pipe(type, currR, currC, curr[2]);
		}
	}

	static void pipe(int type, int currR, int currC, int time) {
		// 상
		if (type == 1 || type == 2 || type == 4 || type == 7) {
			int nr = currR + dr[0];
			int nc = currC + dc[0];
			// 맵 안에 있음, 터널이 있음, 방문하지 않음
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0 && !visited[nr][nc]) {
				int ntype = map[nr][nc];
				if (ntype == 1 || ntype == 2 || ntype == 5 || ntype == 6) {
					if (time + 1 <= L) {
						visited[nr][nc] = true; // 방문 처리
						q.add(new int[] { nr, nc, time + 1 });
						cnt++;
					}
				}
			}
		}

		// 하
		if (type == 1 || type == 2 || type == 5 || type == 6) {
			int nr = currR + dr[1];
			int nc = currC + dc[1];
			// 맵 안에 있음, 터널이 있음, 방문하지 않음
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0 && !visited[nr][nc]) {
				int ntype = map[nr][nc];
				if (ntype == 1 || ntype == 2 || ntype == 4 || ntype == 7) {
					if (time + 1 <= L) {
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc, time + 1 });
						cnt++;
					}
				}
			}
		}

		// 좌
		if (type == 1 || type == 3 || type == 6 || type == 7) {
			int nr = currR + dr[2];
			int nc = currC + dc[2];
			// 맵 안에 있음, 터널이 있음, 방문하지 않음
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0 && !visited[nr][nc]) {
				int ntype = map[nr][nc];
				if (ntype == 1 || ntype == 3 || ntype == 4 || ntype == 5) {
					if (time + 1 <= L) {
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc, time + 1 });
						cnt++;
					}
				}
			}
		}

		// 우
		if (type == 1 || type == 3 || type == 4 || type == 5) {
			int nr = currR + dr[3];
			int nc = currC + dc[3];
			// 맵 안에 있음, 터널이 있음, 방문하지 않음
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 0 && !visited[nr][nc]) {
				int ntype = map[nr][nc];
				if (ntype == 1 || ntype == 3 || ntype == 6 || ntype == 7) {
					if (time + 1 <= L) {
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc, time + 1 });
						cnt++;
					}
				}
			}
		}
	}
}