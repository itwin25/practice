import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int X;
	static int M;
	static int[][] memo;
	static List<int[]> list;
	static int[] cmb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 햄스터 우리 수
			X = Integer.parseInt(st.nextToken()); // 최대 X마리
			M = Integer.parseInt(st.nextToken()); // 남긴 기록 수

			memo = new int[M][3]; // [0]: 시작 우리 [1]: 마지막 우리 [2]: 햄스터 수
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 3; j++) {
					memo[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			list = new ArrayList<>();
			cmb = new int[N];

			dfs(0);

			int max = 0;
			int[] ans = new int[N];
			Arrays.fill(ans, 999);

			if (!list.isEmpty()) {
				for (int[] tmp : list) {
					int sum = 0;
					for (int i = 0; i < N; i++) {
						sum += tmp[i];
					}
					if (sum > max) {
						max = sum; 
						ans = tmp;
					} else if (sum == max) { 
						for (int i = 0; i < N; i++) {
							if (ans[i] > tmp[i]) {
								ans = tmp;
								break;
							} else if (ans[i] < tmp[i]) {
								break;
							}
						}
					}
				}
				// 출력
				System.out.print("#" + test_case + " ");
				for (int i = 0; i < N; i++) {
					System.out.print(ans[i] + " ");
				}
				System.out.println();
			} else { 
				System.out.println("#" + test_case + " -1");
			}
		} // tc
	} // main

	static void dfs(int cageIdx) {
		if (cageIdx == N) {
			boolean isOk = true;

			for (int i = 0; i < M; i++) {
				int S = memo[i][0] - 1;
				int L = memo[i][1] - 1;
				int total = memo[i][2];
				int sum = 0;

				for (int j = S; j <= L; j++) {
					sum += cmb[j];
				}
				if (sum != total) {
					isOk = false;
					break;
				}
			}
         
			if (isOk) {
				list.add(cmb.clone());
			}
			return;
		}

		for (int i = 0; i <= X; i++) {
			cmb[cageIdx] = i;
			dfs(cageIdx + 1);
		}
	}
}