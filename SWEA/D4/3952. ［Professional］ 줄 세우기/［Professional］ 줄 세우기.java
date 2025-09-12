import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 정점의 개수
			int M = Integer.parseInt(st.nextToken()); // 간선의 개수

			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				adj.add(new ArrayList<>());
			}

			int[] inDegree = new int[N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj.get(from).add(to);
				inDegree[to]++;
			}

			Queue<Integer> q = new LinkedList<>();

			// 진입차수 0이면 큐에 넣기
			for (int i = 1; i <= N; i++) {
				if (inDegree[i] == 0) {
					q.add(i);
				}
			}

			StringBuilder ans = new StringBuilder();

			while (!q.isEmpty()) {
				int curr = q.poll();
				ans.append(curr).append(" ");

				for (int next : adj.get(curr)) {
					inDegree[next]--;
					if (inDegree[next] == 0) {
						q.add(next);
					}
				}
			}

			System.out.println("#" + test_case + " " + ans.toString().trim());

		} // tc
	} // main
}