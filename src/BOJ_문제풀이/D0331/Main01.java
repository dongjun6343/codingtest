package BOJ_문제풀이.D0331;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//문제
// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
// 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
//
//입력
// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
//어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
//
//출력
//첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
//V부터 방문된 점을 순서대로 출력하면 된다.
//
//예제 입력 1
//4 5 1
//1 2
//1 3
//1 4
//2 4
//3 4
//예제 출력 1
//1 2 4 3
//1 2 3 4
public class Main01 {
    // DFS : 재귀, 스택.
    // BFS :  큐
    static boolean[] visited ;
    static int N;
    static int[][] branch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 4
        int M = sc.nextInt(); // 5
        int start = sc.nextInt(); // 1

        branch = new int[N+1][N+1];

        visited = new boolean[N+1]; // 방문체크.

        // 인접행렬 생성
        for(int i = 0; i < M;  i++) {
            int a = sc.nextInt(); // 1
            int b = sc.nextInt(); // 2
            branch[a][b] = branch[b][a] = 1;
        }

        dfs(start);
        System.out.println();
        Arrays.fill(visited, false); // visit list 초기화

        bfs(start);

    }

    private static void dfs(int start) {
        // dfs : 깊이우선, 재귀
        // 방문 체크
        visited[start] = true;
        System.out.print(start + " ");

        // 정점의 개수만큼. 4
        for(int i = 1;  i <= N; i++) {
            if(branch[start][i] == 1 && visited[i] == false ) {
                dfs(i); //인접행렬이고, 방문하지 않았으면.
            }
        }
    }

    private static void bfs(int start) {
        // bfs : 너비우선 , 큐
        Queue<Integer> queue = new LinkedList<>();

        // 처음 값 세팅.
        queue.offer(start);
        // 방문 체크
        visited[start] = true;
        System.out.print(start + " ");

        // 큐가 비어있을때까지.
        while(!queue.isEmpty()) {
            int temp = queue.poll(); //큐에서 꺼낸다.

            for(int i = 1; i < branch.length; i++) {
                // 인접행렬이고 방문하지 않았으면,
                if(branch[temp][i] == 1 && visited[i] == false) {
                    // 큐에 값 추가.
                    queue.offer(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }

        }

    }
}

