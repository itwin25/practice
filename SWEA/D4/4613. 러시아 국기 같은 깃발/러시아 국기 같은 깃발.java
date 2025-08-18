import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 행
			int M = sc.nextInt(); // 열
			int cnt = 0; // 칠하는 횟수
			int min = 9999;

			sc.nextLine();
			char[][] russia = new char[N][M]; // 러시아 국기 배열

			for (int i = 0; i < N; i++) {
				String color = sc.nextLine();
				for (int j = 0; j < M; j++) {
					russia[i][j] = color.charAt(j);
				}
			}

			// 최솟값 찾기
			for (int i = 1; i < N - 1; i++) { // 흰색 영역
				for (int j = i + 1; j < N; j++) { // 파란색 영역

					// 흰색 영역 칠하는 횟수
					for (int w = 0; w < i; w++) {
						for (int k = 0; k < M; k++) {
							if (russia[w][k] != 'W') {
								cnt++;
							}

						}
					}

					// 파한색 영역 칠하는 횟수
					for (int b = i; b < j; b++) {
						for (int k = 0; k < M; k++) {
							if (russia[b][k] != 'B') {
								cnt++;
							}

						}
					}

					// 빨간색 영역 칠하는 횟수
					for (int r = j; r <= N - 1; r++) {
						for (int k = 0; k < M; k++) {
							if (russia[r][k] != 'R') {
								cnt++;
							}

						}
					}

					min = Math.min(min, cnt);
					cnt = 0;

				}
			}

			System.out.println("#" + test_case + " " + min);
		}
	}
}