import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, time, eatCnt;
	static int[][] map, dist;
	static int[] shark;
	static List<int[]> fish, target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 공간의 크기 N
		map = new int[N][N]; // 공간 상태
		fish = new ArrayList<>(); // 물고기 정보
		time = 0; // 걸린 시간

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;

				// 상어 발견
				if (num == 9) {
					shark = new int[3];
					shark[0] = 2; // 상어의 크기
					shark[1] = i; // 상어 x 좌표
					shark[2] = j; // 상어 j 좌표
				}

			}
		}

		eatCnt = 0; // 먹은 횟수

		while (true) {
			target = new ArrayList<>(); // 먹을 수 있는 물고기 정보
			dist = new int[N][N]; // 최단 거리 정보 저장

			// -1로 초기화
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], -1);
			}

			// 먹을 수 있는 물고기 정보 찾기
			find(shark[1], shark[2]);

			// 없으면 종료
			if (target.size() == 0) {
				System.out.println(time);
				break;
			}

			// 거리, 행, 열 순서로 정렬
			target.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] a) -> a[1])
					.thenComparingInt((int[] a) -> a[2]));

			int[] eat = target.get(0);

			// 상어 및 공간 정보 업데이트
			map[shark[1]][shark[2]] = 0; // 상어 옮기기
			shark[1] = eat[1];
			shark[2] = eat[2];
			map[shark[1]][shark[2]] = 9;

			eatCnt++; // 먹은 횟수 증가
			time += eat[0]; // 시간 증가

			// 먹은 횟수가 상어 크기만큼 되면 상어 크기 증가
			if (eatCnt == shark[0]) {
				eatCnt = 0;
				shark[0]++;
			}

			// 물고기 냠
			map[eat[1]][eat[2]] = 0;

		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void find(int row, int col) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { row, col });
		dist[row][col] = 0; // 상어 위치

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] <= shark[0] && dist[nr][nc] == -1) {
					dist[nr][nc] = dist[r][c] + 1; // 거리 1 증가
					q.offer(new int[] { nr, nc });

					// 나보다 작은 물고기면?
					if (map[nr][nc] > 0 && map[nr][nc] < shark[0]) {
						target.add(new int[] { dist[nr][nc], nr, nc }); // 먹을 수 있는 물고기 저장!
					}
				}
			}
		}

	}

}
