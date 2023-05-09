package BOJ_문제풀이.D0509;

//그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
// 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

//첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
// V부터 방문된 점을 순서대로 출력하면 된다.


//4 5 1
//1 2
//1 3
//1 4
//2 4
//3 4

//1 2 4 3
//1 2 3 4

import java.util.*;

public class Main_1206 {

    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //4 노드개수
        int N = sc.nextInt();
        //5 애지개수
        int M = sc.nextInt();
        //1 시작점
        int start = sc.nextInt();

        A = new ArrayList[N+1]; // 연결개수

        for(int i = 1; i < N+1; i++){
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){ //5
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        for(int i = 1; i < N+1; i++ ){
            A[i].sort(Comparator.naturalOrder());
        }

        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        visited = new boolean[N+1]; // 방문배열 초기화
        BFS(start);

    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node); // 초기값 세팅
        visited[node] = true;

        while(!queue.isEmpty()){
            int now_node = queue.poll();
            System.out.print(now_node + " ");
            for(int i : A[now_node]){
                if(!visited[i]){
                    //연결노드가 방문한곳이 아니라면
                    visited[i] = true;
                    queue.add(i); // 큐에 삽입
                }
            }
        }

    }

    private static void DFS(int node) {
        System.out.print(node + " ");
        if(!visited[node]){
            //방문하지 않은 곳이면
            visited[node] = true; // 방문처리
            for(int i : A[node]){
                if(!visited[i]){ //연결노드가 방문처리 안된곳
                    DFS(i);
                }
            }
        }
    }
}
