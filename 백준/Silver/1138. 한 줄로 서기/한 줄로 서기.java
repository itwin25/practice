import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사람의 수
        int[] info = new int[N+1]; // 정보

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[N+1]; // 줄 세울 배열
        int x = 1;

        while (x <= N) {
            int cnt = 0; // 빈 자리 수
            int p = info[x]; // 왼쪽 사람들 수
            
            // 키가 작은 애들부터 자리 찾기
            for(int i = 1; i <= N; i++) {
                // 충족할만한 빈 자리가 있으면 줄 세우기
                if(cnt == p && arr[i] == 0) {
                    arr[i] = x;
                    x++;
                    break;
                }

                // 빈 자리 수 카운트
                if(arr[i] == 0) {
                    cnt++;
                }
            }
        }

        // 정답 출력
        StringBuilder ans = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            ans.append(arr[i]).append(" ");
        }

        System.out.println(ans.toString().trim());

    }
}
