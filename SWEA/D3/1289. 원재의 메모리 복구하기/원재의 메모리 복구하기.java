import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String M = br.readLine(); // 메모리의 원래 값
			int length = M.length();
			int curr = 0; // 현재 값
			int ans = 0;

			for (int i = 0; i < length; i++) {
				// 메모리 원래 값
				int original = Character.getNumericValue(M.charAt(i));

				// 메모리 원래 값과 현재 값이랑 다르면
				if (curr != original) {
					ans++; // 횟수 증가
					for (int j = i; j < length; j++) {
						curr = original; // 메모리 원래 값으로 뒷부분 다 덮어씌우기
					}
				}
			}

			System.out.println("#" + test_case + " " + ans);
		} // tc
	}
}
