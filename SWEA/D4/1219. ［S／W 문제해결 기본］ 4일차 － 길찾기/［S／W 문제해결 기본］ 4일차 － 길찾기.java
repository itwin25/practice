import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<Integer>[] list;
	static boolean isPossible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int tc = Integer.parseInt(st.nextToken());
			int ways = Integer.parseInt(st.nextToken()); // 길의 개수

			list = new ArrayList[100];
			for (int i = 0; i < 100; i++) {
				list[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < ways; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list[from].add(to);
			}

			isPossible = false;

			dfs(0);

			if (isPossible) {
				System.out.println("#" + test_case + " 1");
			} else {
				System.out.println("#" + test_case + " 0");
			}
		}
	}

	private static void dfs(int node) {
		if (node == 99) {
			isPossible = true;
			return;
		}

		for (int i = 0; i < list[node].size(); i++) {
			int next = list[node].get(i);
			dfs(next);
		}
	}
}