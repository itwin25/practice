import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = sc.nextInt();
			sc.nextLine();
			char[][] board = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < 100; j++) {
					board[i][j] = s.charAt(j);
				}
			}

			int max = 1;

			// 회문 찾기(가로)
			for (int i = 0; i < 100; i++) {
				for (int j = 1; j < 99; j++) {
					int cnt = 1;

					// ABBA
					if (board[i][j] == board[i][j + 1]) {
						cnt = 2;
						int k = 1;
						while (j - k >= 0 && j + 1 + k < 100) {
							if (board[i][j - k] == board[i][j + 1 + k]) {
								cnt += 2;
								k++;
							} else {
								break;
							}
						}

						// ABA
					} else if (board[i][j - 1] == board[i][j + 1]) {
						cnt = 3;
						int k = 2;
						while (j - k >= 0 && j + k < 100) {
							if (board[i][j - k] == board[i][j + k]) {
								cnt += 2;
								k++;
							} else {
								break;
							}
						}

					}
					max = Math.max(max, cnt);
				}
			}

			// 회문 찾기(세로)
			for (int i = 0; i < 100; i++) {
				for (int j = 1; j < 99; j++) {
					int cnt = 1;
					// ABBA
					if (board[j][i] == board[j + 1][i]) {
						cnt = 2;
						int k = 1;
						while (j - k >= 0 && j + 1 + k < 100) {
							if (board[j - k][i] == board[j + 1 + k][i]) {
								cnt += 2;
								k++;
							} else {
								break;
							}
						}

						// ABA
					} else if (board[j - 1][i] == board[j + 1][i]) {
						cnt = 3;
						int k = 2;
						while (j - k >= 0 && j + k < 100) {
							if (board[j - k][i] == board[j + k][i]) {
								cnt += 2;
								k++;
							} else {
								break;
							}
						}

					}
					max = Math.max(max, cnt);
				}
			}

			System.out.println("#" + tc + " " + max);
		}
	}
}