import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] field; // 뿌요 맵
    static LinkedList<int[]> stack; // 터질 뿌요들
    static int[][] visited; // 방문 맵
    static int ans; // 연쇄 횟수
    static boolean puyo; // 폭발 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                field[i][j] = str.charAt(j);
            }
        }


        while (true) {
            puyo = false;
            visited = new int[12][6]; // 방문 처리
            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    // 빈 칸이 아니고, 방문하지 않은 뿌요인 경우
                    if (field[i][j] != '.' && visited[i][j] == 0) {
                        find(field[i][j], i, j);
                    }
                }
            }

            // 터진 뿌요가 없다면 종료
            if(puyo) {
                gravity(); // 중력 적용
                ans++; // 폭발 횟수 증가
            }else{
                break;
            }
        }

        System.out.println(ans);

    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    // 같은 컬러 뿌요들 찾기
    static void find(char color, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        stack = new LinkedList<>(); //

        q.offer(new int[]{row, col});
        stack.add(new int[]{row, col});
        visited[row][col] = 1;

        // 뿌요 탐색
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6 && field[nr][nc] == color && visited[nr][nc] == 0) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = 1;
                    stack.offer(new int[]{nr, nc});
                }
            }
        }

        if (stack.size() >= 4) {
            explode(stack);
        }
    }

    // 중력 적용
    static void gravity() {
        for (int j = 0; j < 6; j++) {
            int emptyRow = 11; // 맨 아래를 비었다고 가정
            for (int i = 11; i >= 0; i--) {
                if (field[i][j] != '.') { // 뿌요가 있다면 빈칸으로 내리기
                    field[emptyRow][j] = field[i][j];
                    if (emptyRow != i) { // 원래 자리를 .으로 변환
                        field[i][j] = '.';
                    }
                    emptyRow--; // 빈칸 하나 위로 이동
                }
            }
        }
    }

    // 폭발
    static void explode(Deque<int[]> stack) {
        int size = stack.size();

        for (int i = 0; i < size; i++) {
            int[] now = stack.pop();
            field[now[0]][now[1]] = '.';
        }

        puyo = true;
    }
}
