package Programmers.유형.완전탐색;


import java.util.*;

/**
 * [전력망을 둘로 나누기]
 * 문제 설명
 * n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다.
 * 당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다.
 * 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.
 *
 * 송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다.
 * 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때,
 * 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * n은 2 이상 100 이하인 자연수입니다.
 * wires는 길이가 n-1인 정수형 2차원 배열입니다.
 * wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며,
 * 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
 * 1 ≤ v1 < v2 ≤ n 입니다.
 * 전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
 *
 * 입출력 예
 * n	wires	                                           result
 * 9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
 * 4	[[1,2],[2,3],[3,4]]	                                0
 * 7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	            1
 *
 *
 * [문제 풀이 힌트]
 * 인접리스트를 리스트의 배열로 만들고 무향 그래프로이므로 양쪽으로 추가
 * 모든 간선에 대하여 끊었을때 각 전력망의 송전탑 개수를 bfs 탐색을 사용하여 구한다.
 * bfs에서 연결이 끊긴것을 v1에서 v2로 가는 경우를 제외
 */

class Solution_완전탐색_04 {
    public static void main(String[] args) {
        Solution_완전탐색_04 s = new Solution_완전탐색_04();
        System.out.println(s.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
    }

    // 그래프 탐색
    // 인접리스트, 인접행렬을 bfs 혹은 dfs 탐색으로 해결하는 문제
    public List<Integer>[] list;

    public int solution(int n, int[][] wires) {
        int answer = 100;

        list = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }

        for (int[] wire : wires) {
            int n1 = bfs(wire[0], wire[1], n);
            int n2 = bfs(wire[1], wire[0], n);

            answer = Math.min(answer, Math.abs(n1 - n2));
        }

        return answer;
    }

    public int bfs(int v1, int v2, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        int cnt = 0;

        queue.add(v1);
        visit[v1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            cnt++;

            for (int next : list[cur]) {
                if (next != v2 && !visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                }
            }
        }
        return cnt;
    }
}