import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		LinkedList<Character> edit = new LinkedList<>();
		// 초기 문자열
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			edit.add(s.charAt(i));
		}

//		int idx = s.length(); // 초기 커서의 위치 (맨 뒤)
		ListIterator<Character> iterator = edit.listIterator(edit.size());

		int M = Integer.parseInt(br.readLine()); // 입력할 명령어의 개수

		// 명령어 실행
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String cmd = st.nextToken(); // 명령어

			// 커서 왼쪽으로 1칸 (맨 앞이면 무시)
			if (cmd.equals("L")) {
				if (iterator.hasPrevious()) {
					iterator.previous();
				}
			}
			// 커서 오른쪽으로 한 칸 (맨 뒤면 무시)
			else if (cmd.equals("D")) {
				if (iterator.hasNext()) {
					iterator.next();
				}
			}
			// 커서 왼쪽 문자 삭제 (맨 앞이면 무시)
			else if (cmd.equals("B")) {
				if (iterator.hasPrevious()) {
					iterator.previous();
					iterator.remove();
				}
			}
			// 커서 왼쪽에 문자 추가
			else {
				iterator.add(st.nextToken().charAt(0));
			}
		}

		StringBuilder ans = new StringBuilder();
		for (char ch : edit) {
			ans.append(ch);
		}

		System.out.println(ans.toString());

	}
}
