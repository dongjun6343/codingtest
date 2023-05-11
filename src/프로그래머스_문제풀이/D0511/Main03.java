package 프로그래머스_문제풀이.D0511;


import java.util.*;
public class Main03 {
    public static void main(String[] args) {
        Main03 m = new Main03();
        System.out.println(m.solution(
                new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}
        ));

    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    boolean[][] visited;

    public int solution(int[][] maps) {
        int answer = 0;
        int R = maps.length;
        int C = maps[0].length;

        int[][] grid = new int[R][C]; // 숫자+1 visited를 int로 해도 될듯.

        visited = new boolean[R][C];

        bfs(maps, visited, grid);

        answer = grid[R - 1][C - 1];
        if (answer == 0) answer = -1;
        return answer;
    }

    private void bfs(int[][] maps, boolean[][] visited, int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0}); // 0,0부터 시작
        visited[0][0] = true; //0,0 방문처리
        grid[0][0] = 1; // 시작점 0,0 - 1 설정.

        while (!queue.isEmpty()) {
            //1. poll
            //2. 상하좌우
            //3. 방문처리
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < maps.length && y < maps[i].length) {
                    if (maps[x][y] == 1 && !visited[x][y]) {
                        grid[x][y] = grid[now[0]][now[1]] + 1;
                        visited[x][y] = true; // 방문처리
                        queue.offer(new int[]{x, y});
                    }

                }
            }
        }
    }
}