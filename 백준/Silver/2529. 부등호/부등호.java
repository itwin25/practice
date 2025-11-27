import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<String> list; // 완성된 숫자 담을 리스트
	static String[] arr;
	static boolean[] visited;
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine()); // 부등호 문자의 개수
		arr = new String[k];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < k; i++) {
			arr[i] = st.nextToken();
		}

		list = new ArrayList<>();
		visited = new boolean[10];

		dfs(0, "");

		// 문자열로 저장된 숫자들을 오름차순 정렬
		Collections.sort(list);

		// 최댓값 (리스트의 마지막 요소)
		System.out.println(list.get(list.size() - 1));
		// 최솟값 (리스트의 첫 번째 요소)
		System.out.println(list.get(0));

	}

	private static void dfs(int depth, String numStr) {
		// 모두 선택했으면 끝
		if (depth == k + 1) {
			list.add(numStr);
			return;
		}

		// 0부터 9까지의 숫자를 하나씩 시도
		for (int i = 0; i <= 9; i++) {
			// 이미 사용한 숫자는 건너뜀
			if (visited[i]) {
				continue;
			}

			// 첫 번째 숫자(depth == 0)이거나, 부등호 조건을 만족하는 경우에만 진행
			if (depth == 0 || check(numStr.charAt(depth - 1) - '0', i, arr[depth - 1])) {
				visited[i] = true; // 방문 체크
				dfs(depth + 1, numStr + i); // 재귀 호출 (문자열 이어 붙이기)
				visited[i] = false; // 백트래킹 (방문 체크 해제)
			}
		}

	}

	// 부등호 체크
	private static boolean check(int a, int b, String op) {
		if (op.equals("<")) {
			return a < b;
		} else { // ">"
			return a > b;
		}
	}
}