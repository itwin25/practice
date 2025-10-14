import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int gcd, lcm;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 두 개의 자연수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 1. 최대 공약수

		int l = Math.max(N, M);
		int s = Math.min(N, M);

		GCD(l, s);

		// 2. 최소 공배수
		// N * M = GCD * LCM
		lcm = (N * M) / gcd;

		System.out.println(gcd);
		System.out.println(lcm);

	}

	// 큰 수를 작은 수로 계속 나누다가 나머지가 0이 되면 그 작은 수가 최대 공약수
	private static void GCD(int l, int s) {
		int tmp = l % s;

		if (tmp == 0) {
			gcd = s;
			return;
		} else {
			GCD(s, tmp);
		}
	}

}
