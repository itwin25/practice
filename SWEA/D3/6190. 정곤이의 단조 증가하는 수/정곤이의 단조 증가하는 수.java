import java.io.FileInputStream;
import java.util.Scanner;

class Solution {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 정수 개수
			int[] nums = new int[N];
			int max = -1; // 단조 증가 중에서 최댓값

			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}

			// 단조 증가 중에서 최댓값 찾기
			for (int j = 0; j < N; j++) {
				boolean ok = false; // 단조 증가인가?
				String sum = "";
				for (int k = j + 1; k < N; k++) {
					// 숫자의 곱을 String으로 저장
					sum = (nums[j] * nums[k]) + "";
					// 단조 증가인지 확인
					for (int d = 0; d < sum.length() - 1; d++) {
						if (Character.getNumericValue(sum.charAt(d)) <= Character.getNumericValue(sum.charAt(d + 1))) {
							ok = true;
						} else { // 아니면 바로 다음으로 넘어가기
							ok = false;
							break;
						}
					}
					if (ok) { // 단조 증가이면 max 값과 비교해서 최댓값 찾기
						max = Math.max(max, Integer.parseInt(sum));
					}
				}

			}
			if (max == -1) { // 하나도 없으면
				System.out.println("#" + test_case + " " + max);
			} else {
				System.out.println("#" + test_case + " " + max);
			}
		}
	}
}