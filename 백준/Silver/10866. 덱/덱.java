import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 명령의 수
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String cmd = st.nextToken(); // 명령어

			switch (cmd) {
			case "push_front":
				dq.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if (!dq.isEmpty()) {
					ans.append(dq.pollFirst()).append("\n");
				} else {
					ans.append("-1").append("\n");
				}
				break;
			case "pop_back":
				if (!dq.isEmpty()) {
					ans.append(dq.pollLast()).append("\n");
				} else {
					ans.append("-1").append("\n");
				}
				break;
			case "size":
				ans.append(dq.size()).append("\n");
				break;
			case "empty":
				if (dq.isEmpty()) {
					ans.append("1").append("\n");
				} else {
					ans.append("0").append("\n");
				}
				break;
			case "front":
				if (!dq.isEmpty()) {
					ans.append(dq.peekFirst()).append("\n");
				} else {
					ans.append("-1").append("\n");
				}
				break;
			case "back":
				if (!dq.isEmpty()) {
					ans.append(dq.peekLast()).append("\n");
				} else {
					ans.append("-1").append("\n");
				}
				break;
			}
		}

		System.out.println(ans.toString());

	}
}
