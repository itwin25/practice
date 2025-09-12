import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken()); // 정점의 개수
			int E = Integer.parseInt(st.nextToken()); // 간선의 개수

			int[][] adj = new int[V + 1][V + 1];
			int[] inDegree = new int[V + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1;
				inDegree[to]++;
			}

			Queue<Integer> q = new LinkedList<>();

			// 진입차수 0이면 큐에 넣기
			for (int i = 1; i <= V; i++) {
				if (inDegree[i] == 0) {
					q.add(i);
				}
			}

			StringBuilder ans = new StringBuilder();

			while (!q.isEmpty()) {
				int curr = q.poll();
				ans.append(curr).append(" ");

				for (int i = 1; i <= V; i++) {
					if (adj[curr][i] == 1) {
						inDegree[i]--;

						if (inDegree[i] == 0) {
							q.add(i);
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + ans.toString().trim());
		} // tc
	} // main
}