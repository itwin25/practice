import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int ans;
	static int[][] month;
	static int[] fee;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			fee = new int[4]; // 요금
			month = new int[13][2]; // 월별 사용일[0], 요금[1]

			// 요금 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}

			// 달 입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i < 13; i++) {
				month[i][0] = Integer.parseInt(st.nextToken());
			}

			// 1일? 한 달?
			for (int i = 1; i < 13; i++) {
				// 1일 요금제 > 한 달 요금제
				if (month[i][0] * fee[0] > fee[1]) {
					month[i][1] = fee[1];
				} else {
					month[i][1] = fee[0] * month[i][0];
				}
			}

			ans = fee[3];
			int totalCost = 0;

			dfs(1, totalCost);
			System.out.println("#" + test_case + " " + ans);
		} // tc
	} // main

	private static void dfs(int curr, int totalCost) {
		if (curr >= 13) {
			ans = Math.min(totalCost, ans);
			return;
		}
		if (totalCost >= ans) {
			return;
		}

		dfs(curr + 1, totalCost + month[curr][1]);
		dfs(curr + 3, totalCost + fee[2]);
	}
}