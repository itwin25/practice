import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();

			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt());
			}

			int cnt = 1;

			while (true) {
				int num = q.poll();
				num -= cnt;
				if (num <= 0) {
					q.add(0);
					break;
				} else {
					q.add(num);
				}

				cnt++;

				if (cnt > 5) {
					cnt = 1;
				}
			}

			System.out.print("#" + tc + " ");
			for (Integer n : q) {
				System.out.print(n + " ");
			}
			System.out.println();
		}

	}
}
