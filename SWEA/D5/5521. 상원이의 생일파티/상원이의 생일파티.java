import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 반 인원 수
			int M = sc.nextInt(); // 친한친구 관계의 수
			int[][] rel = new int[M][2]; // 관계 배열

			for (int i = 0; i < M; i++) {
				rel[i][0] = sc.nextInt();
				rel[i][1] = sc.nextInt();
			}

			List<Integer> list = new ArrayList<>();
			HashSet<Integer> hash = new HashSet<>();

			for (int i = 0; i < M; i++) {
				if (rel[i][0] == 1) {
					list.add(rel[i][1]);
				} else if (rel[i][1] == 1) {
					list.add(rel[i][0]);
				}
			}

			if (!list.isEmpty()) {
				for (int i = 0; i < M; i++) {
					if (list.contains(rel[i][0])) {
						if (rel[i][1] != 1) {
							hash.add(rel[i][1]);
						}
					} else if (list.contains(rel[i][1])) {
						if (rel[i][0] != 1) {
							hash.add(rel[i][0]);
						}
					}
				}
			}
			hash.addAll(list);
			System.out.println("#" + test_case + " " + hash.size());

		} // tc
	} // main
}
