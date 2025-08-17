import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 가로, 세로 길이
			int K = sc.nextInt(); // 단어의 길이
			int[][] words = new int[N][N]; // 퍼즐
			int ans = 0; // 답

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					words[i][j] = sc.nextInt();
				}
			}

			// 가로 탐색
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (words[i][j] == 1) {
						cnt++;
					} else {
						if (cnt == K) {
							ans++;
						}
						cnt = 0;
					}
				}
				if (cnt == K) {
					ans++;
				}
			}

			// 세로 탐색
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (words[j][i] == 1) {
						cnt++;
					} else {
						if (cnt == K) {
							ans++;
						}
						cnt = 0;
					}
				}
				if (cnt == K) {
					ans++;
				}
			}

			System.out.println("#" + test_case + " " + ans);
		}
	}
}