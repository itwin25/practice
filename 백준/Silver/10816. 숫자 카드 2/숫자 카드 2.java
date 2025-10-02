import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] cards = new int[20000001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken()) + 10000000;
			cards[num]++;
			
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken()) + 10000000;
			ans.append(cards[tmp]).append(" ");
		}
		
		System.out.println(ans.toString().trim());
		
	}
}