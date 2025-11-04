import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 0, 1, 0, -1 }; // 우하좌상
	static int[] dc = { 1, 0, -1, 0 };
	static int N, L, R, sum;
	static int[][] land;
	static boolean[][] move;
	static boolean isOk;
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // N x N
		L = Integer.parseInt(st.nextToken()); // L명 이상
		R = Integer.parseInt(st.nextToken()); // R명 이하
		land = new int[N][N]; // N x N 크기의 땅

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0; // 인구 이동이 발생하는 일수

		while (true) {
			// 초기화
			isOk = false; // 인구 이동이 발생했는지 확인
			move = new boolean[N][N]; // T: 이동O , F: 이동X

			// 연합 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					// 아직 이동이 발생하지 않은 국가라면
					if (!move[i][j]) {
						// 초기화
						sum = 0;
						list = new ArrayList<>(); // 연합에 속하는 국가들 리스트

						// 현재 위치
						move[i][j] = true;
						list.add(new int[] { i, j });
						sum += land[i][j];

						find(i, j);

						// 연합이 존재했으면 인구 이동
						if (list.size() > 1) {
							cal();
						}
					}

				}
			}

			// 인구 이동이 한번도 발생하지 않았다면 종료
			if (!isOk) {
				break;
			} else {
				ans++;
			}

		}
		System.out.println(ans);
	}

	// 연합 찾기
	static void find(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int row = curr[0];
			int col = curr[1];

			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !move[nr][nc]) {
					int gap = Math.abs(land[row][col] - land[nr][nc]); // 인구 차이
					if (gap >= L && gap <= R) {
						// 이동이 발생하는 국가
						q.offer(new int[] { nr, nc });
						move[nr][nc] = true; // 이동 발생!
						list.add(new int[] { nr, nc }); // 이번 연합 국가 좌표 저장
						sum += land[nr][nc];
						isOk = true;
					}
				}
			}
		}

	}

	// 인구 업데이트
	private static void cal() {
		int num = sum / list.size();

		for (int[] tmp : list) {
			land[tmp[0]][tmp[1]] = num;
		}
	}

}
