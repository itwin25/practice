import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt(); // 정점의 개수
			String[][] tree = new String[N + 1][3]; // [0]: 데이터, [1]: 왼자, [2]: 오자

			for (int i = 0; i < N; i++) {
				int n = sc.nextInt(); // 정점 번호
				String s = sc.next();
				// s가 연산자면
				if (s.equals("-") || s.equals("+") || s.equals("/") || s.equals("*")) {
					String L = sc.next();
					String R = sc.next();

					tree[n][0] = s; // 데이터 값
					tree[n][1] = L; // 왼쪽 자식 노드 값
					tree[n][2] = R; // 오른쪽 자식 노드 값

					// 그냥 숫자면 데이터에 s 넣기
				} else {
					tree[n][0] = s;
				}
			}

			System.out.println("#" + test_case + " " + (int) inOrder("1", tree));
		} // tc
	}

	// 후위 순회
	// S : 시작 노드 번호
	public static double inOrder(String S, String[][] tree) {
		// 현재 노드의 데이터 값
		String data = tree[Integer.parseInt(S)][0];

		// 연산자면
		if (data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/")) {

			// 왼쪽, 오른쪽 노드 데이터 값 double로 저장
			double l = inOrder(tree[Integer.parseInt(S)][1], tree);
			double r = inOrder(tree[Integer.parseInt(S)][2], tree);

			// l과 r을 통해 계산
			if (data.equals("+")) {
				return l + r;
			} else if (data.equals("-")) {
				return l - r;
			} else if (data.equals("/")) {
				return l / r;
			} else {
				return l * r;
			}
		}
		// 숫자면 데이터 값 반환
		else {
			return Double.parseDouble(data);
		}
	}
}