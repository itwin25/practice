import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 학생들의 수
			int M = Integer.parseInt(br.readLine()); // 키를 비교한 횟수
			int[][] height = new int[N][N];

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int A = Integer.parseInt(st.nextToken()) - 1; // 작은 학생
				int B = Integer.parseInt(st.nextToken()) - 1; // 큰 학생
				height[A][B] = 1; // A < B
				height[B][A] = -1; // A > B
			}

			// 숨겨진 비교 진행
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (height[i][k] == -1 && height[k][j] == -1) {
							height[i][j] = -1;
						} else if (height[i][k] == 1 && height[k][j] == 1) {
							height[i][j] = 1;
						}
					}
				}
			}

			// 다 아는 학생 수 계산
			int ans = 0;
			for (int[] row : height) {
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					if (row[i] != 0) {
						cnt++;
					}
				}
				if (cnt == N - 1) {
					ans++;
				}
			}

			System.out.println("#" + test_case + " " + ans);

		} // tc
	} // main

}
