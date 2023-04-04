package BOJ_문제풀이.D0404;


import java.util.Scanner;

/**
 * 적록색약
 *
 * 문제
 * 적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다.
 * 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
 *
 * 크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다.
 * 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다.
 * 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다.
 * (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
 *
 * 예를 들어, 그림이 아래와 같은 경우에
 *
 * RRRBB
 * GGBBB
 * BBBRR
 * BBRRR
 * RRRRR
 * 적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다.
 * (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
 *
 * 그림이 입력으로 주어졌을 때,
 * 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
 * 둘째 줄부터 N개 줄에는 그림이 주어진다.
 *
 * 출력
 * 적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
 *
 * 예제 입력
 * 5
 * RRRBB
 * GGBBB
 * BBBRR
 * BBRRR
 * RRRRR
 *
 * 예제 출력
 * 4 3
 */

public class Main01 {


    static boolean[][] visited;
    static char[][] arr;
    //좌표
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    static int N;
    public static void main(String[] args) {
        // 입력갑 세팅
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 5
        arr = new char[N+1][N+1];
        for(int i = 0; i < N; i++ ){
            String S = sc.next(); //RRRBB
            for(int j = 0; j < N; j++){
                arr[i][j] = S.charAt(j); // R R R B B
            }
        }

        // 방문 체크
        visited = new boolean[N + 1][N + 1];

        // 정상
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }
        int count1 = count;
        count = 0; // 카운트 초기화
        visited = new boolean[N + 1][N + 1];

        // 비정상인 경우
        // G를 R로 바꿔주고 돌린다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R'; // G를 R로 변경.
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    dfs(i, j);
                    count++;
                }
            }
        }

        int count2 = count;
        System.out.println(count1 + " " + count2);
    }

    private static void dfs(int x, int y) {
        // 방문체크
        visited[x][y] = true;
        char temp_char = arr[x][y];

        for (int i = 0; i < 4; i++) {
            int new_x = x + dx[i];
            int new_y = y + dy[i];

            // 상하좌우.
            if (new_x < 0 || new_y < 0 || new_x > N || new_y > N) {
                continue;
            }

            if (!visited[new_x][new_y] && arr[new_x][new_y] == temp_char) {
                dfs(new_x, new_y);
            }
        }

    }
}

/**
 * DFS/BFS 풀어보면 좌표 관련 문제가 많다.
 * 좌표 이동/탐색에 대해서 정리해보자
 */