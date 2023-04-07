package 프로그래머스_문제풀이.D0406;


// 게임 맵 최단거리
//              maps	                                                  answer
//        [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	    11
//        [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	    -1


import java.util.LinkedList;
import java.util.Queue;

// 좌표 이동 방향 만들기
// 사방팔방 다 이동 -> bfs - 큐
// 그래프 탐색 - visited 필요
//    문제풀이
//    1. 이동 방향이 정해진 문제라면 전역 상수로 이동 방향을 미리 정의해둔다.
//    e.g. 상하좌우로만 움직일 수 있다면
//    int[] dx = {1,-1,0,0};
//    int[] dy = {0,0,1,-1};
//    혹은
//    int[][] d = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
//    2.시작 위치를 방문 처리하고 현재 위치와 depth의 노드를 생성하며 큐에 넣어준다.
//    3. 배열을 벗어났는지에 대한 체크
public class Main01 {

    public static void main(String[] args) {
        Main01 s = new Main01();
        System.out.println(s.solution(maps));
    }
    static int[][] maps = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    class Node{
        int x;
        int y;
        int count; //depth
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solution(int[][] maps) {
        int answer = -1; // 초기화

        int mapLenX = maps.length;
        int mapLenY = maps[0].length;
        int[][] d = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        boolean[][] visited = new boolean[mapLenX][mapLenY];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0, 1)); // 시작
        visited[0][0] = true;

        while (!q.isEmpty()) { // bfs
            Node node = q.poll();

            if (node.x == mapLenX - 1 && node.y == mapLenY - 1) { // 종료조건
                answer = node.count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dx = node.x + d[i][0];
                int dy = node.y + d[i][1];

                if (dx >= 0 && dx < mapLenX && dy >= 0 && dy < mapLenY &&
                        !visited[dx][dy] && maps[dx][dy] == 1) {
                    visited[dx][dy] = true;
                    q.add(new Node(dx, dy, node.count + 1));
                }
            }
        }

        return answer;
    }
}
