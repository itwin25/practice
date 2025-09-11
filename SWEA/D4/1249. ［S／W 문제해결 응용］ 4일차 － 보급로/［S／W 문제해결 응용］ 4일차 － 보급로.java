import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int[][] map;
	static int[][] dist;
	static final int INF = Integer.MAX_VALUE;
	static int ans;

	static class Edge implements Comparable<Edge> {
		int cost, r, c;

		public Edge(int cost, int r, int c) {
			this.cost = cost;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Solution.Edge o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine()); // NxN
			map = new int[N][N]; // 파여진 깊이(시간)
			String s = "";
			for (int i = 0; i < N; i++) {
				s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Character.getNumericValue(s.charAt(j));
				}
			}

			dist = new int[N][N]; // 출발점에서의 최단 시간 저장
			// 우선 전부 무한대로
			for (int[] row : dist) {
				Arrays.fill(row, INF);
			}
			dist[0][0] = 0; // 시작 지점
			ans = 0;
			dijkstra(0, 0);

			System.out.println("#" + test_case + " " + ans);

		} // tc
	} // main

	private static void dijkstra(int row, int col) {
		int min = INF;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, row, col)); // 시작지점

		while (!pq.isEmpty()) {
			Edge edge = pq.poll(); // 비용이 가장 적은 곳 하나 꺼내기

			// 목적지인지 확인
			if (edge.r == N - 1 && edge.c == N - 1) {
				ans = edge.cost;
				break;
			}

			// 4방향 탐색
			for (int i = 0; i < 4; i++) {
				int nr = edge.r + dr[i];
				int nc = edge.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && dist[nr][nc] == INF) {
					if (dist[nr][nc] > dist[edge.r][edge.c] + map[nr][nc]) {
						dist[nr][nc] = dist[edge.r][edge.c] + map[nr][nc];
						pq.offer(new Edge(dist[nr][nc], nr, nc));
					}
				}
			}
		}
	}
}