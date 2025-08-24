import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static int[] dr = { 1, 0, 1, 1 }; // 하, 우, 좌하, 우하
	static int[] dc = { 0, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 길이
			sc.nextLine();
			char[][] board = new char[N][N]; // 오목판
			String omok = "NO";

			// 오목판 현황
			for (int i = 0; i < N; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = s.charAt(j);
				}
			}

			// 오목 찾기
			loop1: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					// 바둑돌이면
					if (board[i][j] == 'o') {
						// 델타배열 하나씩 탐색
						for (int d = 0; d < 4; d++) {
							int cnt = 1; // 연속된 바둑돌 수

							// 하, 우, 좌하, 우하 탐색
							for (int k = 1; k <= N; k++) {
								int nr = i + dr[d] * k;
								int nc = j + dc[d] * k;

								if (nr < N && nr >= 0 && nc < N && nc >= 0 && board[nr][nc] == 'o') {
									cnt++;
									// 오목을 찾으면 종료
									if (cnt == 5) {
										omok = "YES";
										break loop1;
									}
								} else {
									// 연속이 끊기면 탐색 중단
									break;
								}

							}
						}
					}

				}
			}

			System.out.println("#" + test_case + " " + omok);
		}
	}
}