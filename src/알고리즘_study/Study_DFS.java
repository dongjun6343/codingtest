package 알고리즘_study;

public class Study_DFS {

    /**
     * DFS/BFS는 둘다 그래프를 탐색하는 방법.
     *
     * DFS는 깊이 우선 탐색
     * 스택 및 재귀함수로 구현한다.
     */

    // 방문처리에 사용할 배열선언.
    static boolean[] visited = new boolean[9];

    //그래프를 2차원배열로 표현
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
                          //0      1       2        3      4       5      6     7      8
    public static void main(String[] args) {
        dfs(1);
    }

    /**
     * 위와 같은 그래프가 존재한다고 하고, 1번 노드부터 DFS탐색
     *
     * 1번 노드 방문처리 후 출력 (탐색 순서 : 1)
     * 1번 노드에 인접한 노드 2번, 3번, 8번 중 하나를 방문해야 하는데 오름차순으로 방문
     * 2번 노드 방문처리 후 출력 (탐색 순서 : 1 -> 2)
     * 2번 노드에 인접한 노드 6번, 8번 중 오름차순 기준이니까 6번 노드
     * 6번 노드 방문처리 후 출력 (탐색 순서 : 1 -> 2 -> 6)
     * 6번 노드에 인접한 노드는 2번 노드뿐인데 이미 방문을 하였으므로 더 이상 방문처리는 하지 않고
     * 6번 노드를 호출한 노드(부모 노드)로 다시 돌아간다. (여기서는 2번 노드)
     * 2번 노드에 인접한 노드 중 8번 노드가 남아있으므로 8번 노드로 이동
     * 8번 노드 방문처리 후 출력 (탐색 순서 : 1 -> 2 -> 6 -> 8)
     * 8번 노드에 인접한 노드는 1번과 2번 노드인데 둘 다 모두 방문처리가 되어있으므로
     * 더 이상 방문은 하지 않고 8번을 호출한 노드(부모 노드)인 2번 노드로 돌아간다
     * 2번 노드에 인접한 노드(자식 노드) 6번, 8번이 모두 방문 처리된 상태이므로
     * 2번을 호출한 노드(부모 노드)인 1번 노드로 돌아간다
     * 이제 1번 노드에 인접한 노드 중 방문하지 않은 노드 3번으로 이동
     * 3번 노드 방문처리 후 출력 (탐색 순서 : 1 -> 2 -> 6 -> 8 -> 3)
     * 3번 노드에 연결된 노드는 5번 노드뿐이므로 5번 노드 방문 처리 후 출력 (탐색 순서 : 1 -> 2 -> 6 -> 8 -> 3 -> 5)
     * 5번 노드에 연결된 노드 4번, 7번 중 오름차순 기준이니까 4번 먼저 방문처리 후 출력
     * 마지막으로 남은 7번 노드 방문 처리 후 출력하면 더 이상 방문할 노드가 없으므로 종료.
     */
    static void dfs(int nodeIndex) {
        // 방문 처리
        visited[nodeIndex] = true;
        // 방문 노드 출력
        System.out.print(nodeIndex + " -> "); // 1 -> 2 -> 6 -> 8 -> 3 -> 5 -> 4 -> 7
        // 방문한 노드에 인접한 노드 찾기
        for (int node : graph[nodeIndex]) {
            // 인접한 노드가 방문한 적이 없다면 DFS 수행
            if(!visited[node]) {
                // graph[nodeIndex] : 1
                // node : 2

                // graph[nodeIndex] : 2
                // node : 1, 6

                // 방문처리에 사용할 배열선언으로 해당 노드를 갔다왔는지 확인..!
                dfs(node);
            }
        }
    }
}
