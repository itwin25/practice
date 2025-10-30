import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, K, ans1;
	static int[][] map;
	static List<Integer> ans2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 세로
		N = Integer.parseInt(st.nextToken()); // 가로
		K = Integer.parseInt(st.nextToken()); // 직사각형 개수
		map = new int[M][N]; // 모눈종이

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			// 왼쪽 아래 꼭짓점
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			// 오른쪽 위 꼭짓점
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			// 사각형 영역 표시
			for (int c = x1; c < x2; c++) {
				for (int r = y1; r < y2; r++) {
					int r1 = M - 1 - r;
					if (map[r1][c] == 0) {
						map[r1][c] = 1;
					}
				}
			}
		}

		ans1 = 0; // 영역의 개수
		ans2 = new ArrayList<>(); // 각 영역의 넓이

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// 빈 공간 찾음
				if (map[i][j] == 0) {
					find(i, j);
					ans1++; // 영역 개수 증가
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		Collections.sort(ans2);

		for (int n : ans2) {
			sb.append(n).append(" ");
		}

		System.out.println(ans1);
		System.out.println(sb);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void find(int row, int col) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { row, col }); // 시작 좌표 넣기
		map[row][col] = 1; // 방문 표시

		int cnt = 1; // 면적 계산

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				// 범위 안이고 빈 공간이면
				if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] == 0) {
					map[nr][nc] = 1; // 방문 표시
					q.offer(new int[] { nr, nc });
					cnt++; // 면적 증가
				}
			}
		}

		ans2.add(cnt);

	}

}
