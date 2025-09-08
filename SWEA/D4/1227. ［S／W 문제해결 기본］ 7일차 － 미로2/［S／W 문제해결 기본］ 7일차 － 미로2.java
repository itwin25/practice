import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[][] map;
	static int sR;
	static int sC;
	static int eR;
	static int eC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean finish;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = Integer.parseInt(br.readLine());
			map = new int[100][100];

			for (int i = 0; i < 100; i++) {
				String s = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = Character.getNumericValue(s.charAt(j));
					if (map[i][j] == 2) {
						sR = i;
						sC = j;
					}
					if (map[i][j] == 3) {
						eR = i;
						eC = j;
					}
				}
			}
			finish = false;
			dfs(sR, sC, eR, eC);

			if (finish) {
				System.out.println("#" + test_case + " 1");
			} else {
				System.out.println("#" + test_case + " 0");
			}
		} // tc
	} // main

	private static void dfs(int sR, int sC, int eR, int eC) {
		int currR = sR;
		int currC = sC;

		for (int i = 0; i < 4; i++) {
			int nr = currR + dr[i];
			int nc = currC + dc[i];
			if (nr == eR && nc == eC) {
				finish = true;
				return;
			}
			if (nr >= 0 && nr < 100 && nr >= 0 && nr < 100 && map[nr][nc] != 1) {
				map[nr][nc] = 1; // 벽
				dfs(nr, nc, eR, eC);
			}
		}
	}
}