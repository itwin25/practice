import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 빌딩의 수
        int[] buildings = new int[N]; // 빌딩

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for(int i = 0; i < N; i++){
            int cnt = 0; // 현재 위치에서 보이는 빌딩 수

            // 왼쪽 빌딩 찾기
            double minSlope = 1000000000.0;
            for(int j = i-1; j >= 0; j--){
                // y증가량/x증가량
                double slope = (double)(buildings[i] - buildings[j]) / (i - j);

                if (slope < minSlope){
                    minSlope = slope;
                    cnt++;
                }
            }

            // 오른쪽 빌딩 찾기
            double maxSlope = -1000000000.0;
            for(int j = i+1; j < N; j++){
                // y증가량/x증가량
                double slope = (double)(buildings[i] - buildings[j]) / (i - j);

                if (slope > maxSlope){
                    maxSlope = slope;
                    cnt++;
                }
            }

            if (cnt > ans){
                ans = cnt;
            }
        }

        System.out.println(ans);

    }
}
