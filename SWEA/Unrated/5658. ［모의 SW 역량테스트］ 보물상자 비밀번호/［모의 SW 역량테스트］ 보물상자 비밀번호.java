import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 숫자의 개수
			int K = sc.nextInt(); // K번째
			sc.nextLine();
			String nums = sc.nextLine(); // 숫자
			int cnt = N / 4; // 각 숫자의 길이
			List<Character> list = new ArrayList<>();
			String[] arr = new String[N];
			int idx = 0; // arr 인덱스

			for (int i = 0; i < N; i++) {
				list.add(nums.charAt(i));
			}

			// cnt만큼 회전
			for (int i = 0; i < cnt; i++) {
				int tmp1 = 0; // 리스트의 N번까지의 인덱스 값
				for (int j = 0; j < 4; j++) { // 4개의 변
					arr[idx] = "";
					for (int k = 0; k < cnt; k++) { // 인덱스 하나에 16진수 숫자 하나
						arr[idx] += list.get(tmp1);
						tmp1++;
					}
					idx++;
				}
				list.add(0, list.remove(N - 1)); // 회전
			}

			// 중복을 제거하고 내림차순으로 나열
			String[] unique = Arrays.stream(arr).distinct()
					.sorted(Comparator.comparingInt(hex -> Integer.parseInt((String) hex, 16)).reversed())
					.toArray(String[]::new);

			// 10번째로 큰 수를 10진수로 출력
			System.out.println("#" + test_case + " " + Integer.parseInt(unique[K - 1], 16));
		}
	}
}
