package 프로그래머스_문제풀이.D0422;



//입출력 예
//k	dungeons	result
//80	[[80,20],[50,40],[30,10]]	3
//입출력 예 설명
//현재 피로도는 80입니다.
//
//만약, 첫 번째 → 두 번째 → 세 번째 던전 순서로 탐험한다면
//
//현재 피로도는 80이며, 첫 번째 던전을 돌기위해 필요한 "최소 필요 피로도" 또한 80이므로, 첫 번째 던전을 탐험할 수 있습니다.
// 첫 번째 던전의 "소모 피로도"는 20이므로, 던전을 탐험한 후 남은 피로도는 60입니다.
//남은 피로도는 60이며, 두 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 50이므로, 두 번째 던전을 탐험할 수 있습니다.
// 두 번째 던전의 "소모 피로도"는 40이므로, 던전을 탐험한 후 남은 피로도는 20입니다.
//남은 피로도는 20이며, 세 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 30입니다. 따라서 세 번째 던전은 탐험할 수 없습니다.
//만약, 첫 번째 → 세 번째 → 두 번째 던전 순서로 탐험한다면
//
//현재 피로도는 80이며, 첫 번째 던전을 돌기위해 필요한 "최소 필요 피로도" 또한 80이므로, 첫 번째 던전을 탐험할 수 있습니다.
// 첫 번째 던전의 "소모 피로도"는 20이므로, 던전을 탐험한 후 남은 피로도는 60입니다.
//남은 피로도는 60이며, 세 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 30이므로, 세 번째 던전을 탐험할 수 있습니다.
// 세 번째 던전의 "소모 피로도"는 10이므로, 던전을 탐험한 후 남은 피로도는 50입니다.
//남은 피로도는 50이며, 두 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 50이므로, 두 번째 던전을 탐험할 수 있습니다.
// 두 번째 던전의 "소모 피로도"는 40이므로, 던전을 탐험한 후 남은 피로도는 10입니다.
//따라서 이 경우 세 던전을 모두 탐험할 수 있으며, 유저가 탐험할 수 있는 최대 던전 수는 3입니다.x

public class Main01 {
    public static void main(String[] args) {
        Main01 s = new Main01();
        System.out.println(s.solution(80, new int[][]{{80,20},{50,40},{30,10}}));
//        System.out.println(s.solution(80, new int[][]{{30,10},{80,20},{50,40}}));
    }

    // [[80,20],[50,40],[30,10]]
    // 80
    static boolean visited[];
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        // DFS => 깊이 우선 탐색 => 재귀
        dfs(0, k , dungeons);
        return answer;
    }

    private void dfs(int depth, int k, int[][] dungeons) {

        // dfs를 돌때마다 최대값 계산
        answer = Math.max(answer, depth);

        // 방문체크
        for(int i = 0; i < dungeons.length; i++){
//            System.out.println(i);
            if(visited[i] == false && k >= dungeons[i][0]){
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1] , dungeons);
                // 다른케이스 확인을 위한 방문처리 초기화
                visited[i] = false;
            }
        }
    }
}
