import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 숫자 카드의 개수
		HashSet<Integer> cards = new HashSet<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cards.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine()); // 비교할 M개의 정수

		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		// 맞는 숫자가 있는지 확인
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (cards.contains(num)) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
		}

		System.out.println(sb.toString().trim());

	}
}
