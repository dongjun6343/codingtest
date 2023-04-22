package 프로그래머스_문제풀이.D0422;


//문제 설명
//리코쳇 로봇이라는 보드게임이 있습니다.
//
//이 보드게임은 격자모양 게임판 위에서 말을 움직이는 게임으로, 시작 위치에서 목표 위치까지 최소 몇 번만에 도달할 수 있는지 말하는 게임입니다.
//
//이 게임에서 말의 움직임은 상, 하, 좌, 우 4방향 중 하나를 선택해서
// 게임판 위의 장애물이나 맨 끝에 부딪힐 때까지 미끄러져 이동하는 것을 한 번의 이동으로 칩니다.
//
//다음은 보드게임판을 나타낸 예시입니다.
//
//...D..R
//.D.G...
//....D.D
//D....D.
//..D....

//여기서 "."은 빈 공간을, "R"은 로봇의 처음 위치를, "D"는 장애물의 위치를, "G"는 목표지점을 나타냅니다.
//위 예시에서는 "R" 위치에서 아래, 왼쪽, 위, 왼쪽, 아래, 오른쪽, 위 순서로 움직이면 7번 만에 "G" 위치에 멈춰 설 수 있으며,
// 이것이 최소 움직임 중 하나입니다.
//
//게임판의 상태를 나타내는 문자열 배열 board가 주어졌을 때,
// 말이 목표위치에 도달하는데 최소 몇 번 이동해야 하는지 return 하는 solution함수를 완성하세요.
// 만약 목표위치에 도달할 수 없다면 -1을 return 해주세요.

import java.util.LinkedList;
import java.util.Queue;

public class Main02 {

    static boolean visited[][];
    static char map[][];
    // 상하좌우
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void main(String[] args) {
        Main02 s = new Main02();
        System.out.println(s.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    }

    // 사방팔방 => 너비로 체크 => bfs => 큐
    // 일반적인 bfs문제에서 벽이나 D를 만나기 전까지 움직이는 로직을 추가한다.
    public int solution(String[] board) {

        int answer = 0;

        map = new char[board.length][board[0].length()];
        visited = new boolean[map.length][map[0].length];

        for(int i = 0 ; i < map.length; i++){
            map[i] = board[i].toCharArray(); // . . . D . . R
        }

        Moving robot = null;
        Moving goal = null;

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                // R과 G의 위치 찾기
                if(map[i][j] == 'R'){
                    robot = new Moving(i,j,0);
                } else if (map[i][j] == 'G'){
                    goal = new Moving(i,j,0);
                }
            }
        }

        answer = bfs(board, robot, goal);

        return answer;
    }

    private int bfs(String[] board, Moving robot, Moving goal) {

        Queue<Moving> q = new LinkedList<>();
        q.offer(robot);

        while(!q.isEmpty()){

            Moving chk = q.poll(); // 현재 자리 (큐에 있는 데이터를 뽑는다)
            visited[robot.x][robot.y] = true; // 현재 방문했으니 true

            if(chk.x == goal.x && chk.y == goal.y){
                return chk.depth;
            }

            for(int k = 0;  k < 4; k++){
                int nx = chk.x;
                int ny = chk.y;

                // 범위를 벗어나거나 장애물을 만날때까지 반복
                while (inRange(nx, ny) && board[nx].charAt(ny) != 'D'){
                    nx += dx[k];
                    ny += dy[k];
                }

                // 범위를 벗어나거나 장애물 만나기 '직전'의 상태
                nx -= dx[k];
                ny -= dy[k];

                // 방문을 하거나 같은 위치일 경우 스킵
                if (visited[nx][ny] || (chk.x == nx && chk.y == ny)) continue;

                visited[nx][ny] = true;
                q.offer(new Moving(nx, ny, chk.depth + 1));
            }
        }
        return -1;
    }

    //범위
    private boolean inRange(int x ,int y) {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }

    public class Moving{
        int x;
        int y;
        int depth;

        public Moving(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
