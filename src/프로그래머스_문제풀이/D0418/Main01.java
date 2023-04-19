package 프로그래머스_문제풀이.D0418;

import java.util.*;

//문제 설명
//메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다.
// 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다.
// 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며,
// 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다.
// 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다.
// 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다.
// 지도의 각 칸에 적힌 숫자는 식량을 나타내는데,
// 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다.
// 어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.
//
//지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때,
// 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요.
// 만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.
//maps	                                   result
// ["X591X","X1X5X","X231X", "1XXX1"]	[1, 1, 27]
// ["XXX","XXX","XXX"]	                   [-1]
public class Main01 {
    // 상,하,좌,우 => 사방팔방 -> bfs을 이용해서 풀어보자 - queue
    // 1. bfs를 이용해 상하좌우 인접한 땅을 찾는다.
    // 2. 무인도로 이루어진 숫자의 합을 arraylist에 추가
//            - 'X'가 아닌 경우 bfs를 이용해서 칸에 적힌 숫자들을 더한다.
    // 3. bfs가 끝나면 arraylist를 오름차순 정렬시킨다.
    // 4. ArrayList 크기가 0이면 -1를 넣어준 후 리턴시켜준다.


    // 상하좌우를 탐색하기 위한 변수.
    // 이차원 배열의 index이다. (그래프의 좌표 개념이 아님!)
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static boolean visited[][];
    static char[][] map;

    public static void main(String[] args) {
        Main01 s = new Main01();
        System.out.println(s.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"}));
    }

    public static List<Integer> solution(String[] maps){
        List<Integer> answer = new ArrayList<>();
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[map.length][map[0].length];
        for(int i=0;i<maps.length;i++){
            map[i] = maps[i].toCharArray();
        }

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(!visited[i][j] && map[i][j] != 'X'){
                    answer.add(bfs(i, j));
                }
            }
        }

        if(answer.size() == 0){
            answer.add(-1);
        }
        Collections.sort(answer);
        return answer;
    }

    public static int bfs(int i, int j){
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j}); //처음 들어온 값 시작점.
        while(!q.isEmpty()){ //큐가 빌때까지 돌린다.
            int[] now = q.poll(); // 현재 자리 (큐에 있는 데이터를 뽑는다)
            visited[i][j] = true; // 현재 방문했으니 true

            sum += map[now[0]][now[1]]-'0';

            for(int k = 0; k < 4; k++) { //상하좌우 탐색을 위한 for문.
                int x = now[0] + dx[k]; // 상하좌우 탐색
                int y = now[1] + dy[k]; // 상하좌우 탐색

                if (x >= 0 && y >= 0 && x < map.length && y < map[0].length) { // 배열을 넘어가면 안된다.
                    if (!visited[x][y] && map[x][y] != 'X') { // 이미 방문했던곳과 가지 못하는 곳의 조건

                        // 이제 갈수 있는곳이다.
                        visited[x][y] = true;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        return sum;
    }
}
