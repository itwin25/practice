import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			int cnt = 0;
			int max = 0;

			// 파리 배열
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 찾기
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					cnt = arr[i][j]; // 현재 파리 개수 초기화

					// 분사 중점
					int nr = i;
					int nc = j;

					// 퍼져나가기
					for (int v = 1; v < M; v++) {
						// + 탐색
						for (int k = 0; k < 4; k++) {
							nr = i;
							nc = j;

							nr += dr[k] * v;
							nc += dc[k] * v;
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								cnt += arr[nr][nc];
							}
						}
					}

					max = Math.max(max, cnt); // 최대 파리 수 저장
					cnt = arr[i][j]; // 현재 파리 개수 초기화

					for (int v = 1; v < M; v++) {
						// x 탐색
						for (int k = 4; k < 8; k++) {
							nr = i;
							nc = j;

							nr += dr[k] * v;
							nc += dc[k] * v;
							if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
								cnt += arr[nr][nc];
							}
						}
					}
					max = Math.max(max, cnt); // 최대 파리 수 저장
				}
			}
			System.out.println("#" + tc + " " + max);
		} // tc
	}
}