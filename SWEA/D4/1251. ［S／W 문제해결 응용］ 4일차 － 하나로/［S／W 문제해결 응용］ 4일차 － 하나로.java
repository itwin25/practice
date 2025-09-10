import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static final double INF = Double.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 섬의 개수
			int[] X = new int[N]; // X좌표
			int[] Y = new int[N]; // Y좌표

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}

			double E = Double.parseDouble(br.readLine()); // 세율

			double adj[][] = new double[N][N];

			// 비용 계산
			for (int i = 0; i < N; i++) {
				int[] A = { X[i], Y[i] };
				for (int j = 0; j < N; j++) {
					int[] B = { X[j], Y[j] }; 
					double tmp = (Math.pow(Math.abs(X[i] - X[j]), 2) + Math.pow(Math.abs(Y[i] - Y[j]), 2)) * E;
					if (i == j) {
						adj[i][j] = 0;
						continue;
					} else {
						adj[i][j] = tmp;
					}
				}
			}

			boolean[] visited = new boolean[N];
			double cost[] = new double[N];
			Arrays.fill(cost, INF);

			cost[0] = 0;

			for (int i = 0; i < N - 1; i++) {
				double min = INF;
				int idx = -1;

				for (int j = 0; j < N; j++) {
					if (!visited[j] && cost[j] < min) {
						min = cost[j];
						idx = j;
					}
				}

				visited[idx] = true;

				for (int j = 0; j < N; j++) {
					if (!visited[j] && adj[idx][j] != 0 && cost[j] > adj[idx][j]) {
						cost[j] = adj[idx][j];
					}
				}
			}

			double ans = 0;
			for (int i = 0; i < N; i++) {
				ans += cost[i];
			}

			System.out.println("#" + test_case + " " + Math.round(ans));

		} // tc
	} // main
}