import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			Queue<String> deck1 = new LinkedList<>();
			Queue<String> deck2 = new LinkedList<>();
			StringBuilder ans = new StringBuilder();

			// 양쪽 덱에 카드 저장하기
			for (int i = 0; i < N; i++) {
				if (i < (N + 1) / 2) {
					deck1.add(sc.next());
				} else {
					deck2.add(sc.next());
				}
			}

			// 번갈아가면서 덱 뽑기
			while (!deck1.isEmpty() || !deck2.isEmpty()) {
				if (!deck1.isEmpty()) {
					ans.append(deck1.poll()).append(" ");
				}
				if (!deck2.isEmpty()) {
					ans.append(deck2.poll()).append(" ");
				}
			}

			System.out.println("#" + test_case + " " + ans.toString().trim());
		}
	}
}
