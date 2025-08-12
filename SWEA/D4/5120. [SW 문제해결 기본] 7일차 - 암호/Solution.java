import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("sample_input (1).txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 숫자 개수
			int M = sc.nextInt(); // 건너뛸 칸의 수
			int K = sc.nextInt(); // 반복 횟수
			int idx = 0; // 현재 인덱스

			LinkedList<Integer> list = new LinkedList<>(); // 비밀번호를 담을 리스트

			// 숫자 담기
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}

			// K번 반복
			for (int i = 0; i < K; i++) {
				idx += M; // 삽입할 위치 계산

				// 삽입할 인덱스가 리스트의 크기와 같음 -> 리스트에 그냥 add
				if (idx == list.size()) {
					list.addLast(list.getLast() + list.getFirst()); // 마지막 값과 처음 값 합산
					// 삽입할 인덱스가 리스트 범위를 벗어남 -> 나머지 연산자로 인덱스 재계산
				} else if (idx > list.size()) {
					idx %= list.size();
					list.add(idx, list.get(idx - 1) + list.get(idx));
					// 삽입할 인덱스가 리스트 범위 안에 있음
				} else {
					list.add(idx, list.get(idx) + list.get(idx - 1));
				}
			}

			// 답을 저장할 StringBuilder
			StringBuilder ans = new StringBuilder();

			// 숫자가 10개보다 많으면 뒤에서부터 10개 추출
			if (list.size() > 10) {
				for (int n = list.size() - 1; n >= list.size() - 10; n--) {
					ans.append(list.get(n)).append(" ");
				}
				// 숫자가 10개 이내
			} else {
				for (int n = list.size() - 1; n >= 0; n--) {
					ans.append(list.get(n)).append(" ");
				}
			}
			System.out.println("#" + test_case + " " + ans.toString().trim());
		}
	}
}