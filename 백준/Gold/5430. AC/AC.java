import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String p = br.readLine(); // 수행할 함수
			int n = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수
			String[] arr = new String[n]; // 수가 들어갈 배열
			LinkedList<String> list = new LinkedList<>(); // 함수 수행을 위한 리스트

			String s = br.readLine();

			// 비어있는 배열이 아니라면
			if (n > 0) {
				s = s.substring(1, s.length() - 1); // 괄호 빼기
				arr = s.split(",");
				list = new LinkedList<>(Arrays.asList(arr));
			}

			// 에러인지 확인
			boolean isOk = true;

			// 현재 방향 확인 (true: 정방향, false: 역방향)
			boolean dir = true;

			// 함수 수행
			for (int i = 0; i < p.length(); i++) {
				char curr = p.charAt(i);
				if (curr == 'R') {
					// 뒤집기
					if (list.size() > 1) {
						dir = !dir;
					}
				} else {
					// 앞에 하나 지우기
					if (!list.isEmpty()) {
						if (dir) { // 정방향이면
							list.poll();
						} else { // 역방향이면
							list.pollLast();
						}
					} else { // 비었는데 버리려고 하면 종료
						isOk = false;
						break;
					}
				}
			}

			// 출력
			if (isOk) {
				// 정답 출력을 위한 StringBuilder
				StringBuilder ans = new StringBuilder();
				ans.append("[");

				// 리스트가 비어있지 않다면 내용물 append
				if (list.size() != 0) {
					if (dir) { // 정방향
						ans.append(list.poll());
						while (!list.isEmpty()) {
							ans.append(",").append(list.poll());
						}
					} else { // 역방향
						ans.append(list.pollLast());
						while (!list.isEmpty()) {
							ans.append(",").append(list.pollLast());
						}
					}
				}

				ans.append("]");
				System.out.println(ans);
			} else {
				System.out.println("error");
			}

		}

	}
}
