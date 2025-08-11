import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String str = sc.next();
			boolean reverse = false;

			for (int i = 0; i <= str.length() - M; i++) {
				String s = str.substring(i, i + M);
				StringBuilder sb = new StringBuilder(s);
				if (s.equals(sb.reverse().toString())) {
					System.out.println("#" + tc + " " + s);
					reverse = true;
					break;
				} else {
					sb.setLength(0);
				}
			}
			if (!reverse) {
				System.out.println("#" + tc + " NONE");
			}

		}
	}
}