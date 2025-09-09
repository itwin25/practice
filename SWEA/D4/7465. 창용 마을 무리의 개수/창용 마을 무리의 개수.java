import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static Integer[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 사람의 수
			int M = Integer.parseInt(st.nextToken()); // 관계의 수

			p = new Integer[N + 1];
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int A = Integer.parseInt(st.nextToken()); // 첫번째 사람
				int B = Integer.parseInt(st.nextToken()); // 두번째 사람

				int root_A = findSet(A);
				int root_B = findSet(B);

				p[root_B] = root_A;
			}

			for (int i = 1; i <= N; i++) {
				p[i] = findSet(i);
			}

			HashSet<Integer> tmp = new HashSet<>(Arrays.asList(p));

			System.out.println("#" + test_case + " " + (tmp.size() - 1));
		} // tc
	} // main

	// 부모 찾기
	static int findSet(int x) {
		if (p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
}