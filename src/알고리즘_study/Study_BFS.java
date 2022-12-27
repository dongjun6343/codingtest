package 알고리즘_study;

import java.util.LinkedList;
import java.util.Queue;

public class Study_BFS {

    /**
     * DFS/BFS는 둘다 그래프를 탐색하는 방법.
     *
     * BFS는 너비 우선 탐색
     * 큐로 구현한다.
     */
    public static void main(String[] args) {
        // 방문처리에 사용할 배열선언.
        boolean[] visited = new boolean[9];

        //그래프를 2차원배열로 표현
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
                        //0      1       2        3      4       5      6     7      8

        System.out.println(bfs(1, graph, visited));
        //1 -> 2 -> 3 -> 8 -> 6 -> 5 -> 4 -> 7
    }

    /**
     *   1. 큐에 1번 노드를 넣고 방문 처리
     *   2. 1번 노드와 가까운 노드를 큐에 넣고 방문 처리 (2번, 3번 8번 노드)
     *   3. 큐에서 노드를 하나 꺼낸다. poll()
     *   4. 연결된 노드가 없으면 3번으로 다시 돌아갑니다.
     *   5. 연결된 노드가 있고 방문하지 않았으면 큐에 넣고 방문처리 후 3번으로 돌아갑니다.
     *   6. 연결된 노드가 있지만 방문을 이미 한 경우에는 3번으로 돌아갑니다.
     *   7. 3~6을 큐가 빌 때까지 반복하며 큐가 비었으면 종료합니다.
     */
    private static String bfs(int start, int[][] graph, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        // BFS에 사용할 큐 생성
        Queue<Integer> q = new LinkedList<>();

        // 큐에 BFS를 시작할 번호 추가
        q.offer(start);

        //시작노드 방문처리
        visited[start] = true;
        
        // 큐가 빌때까지 계속 반복
        while(!q.isEmpty()){
            int nodeIndex = q.poll(); // 값 반환 후 삭제
            sb.append(nodeIndex  + " -> ");
            // 큐에서 꺼낸 노드와 연결된 노드 체크
            for(int i = 0; i < graph[nodeIndex].length; i++){
                int temp = graph[nodeIndex][i];
                // 방문하지 않았으면 방문처리 후 큐에 추가
                if(!visited[temp]){
                    visited[temp] = true;
                    q.offer(temp);
                }
            }
        }
        return sb.toString();
    }
}
