package Doit_핵심유형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연결 요소의 개수 구하기
 * 11724번
 *
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 *
 * 깊이 우선 탐색
 * DFS -> 후입선출 -> 스택
 *
 * 연결 요소 문제는 대표적인 DFS와 BFS문제이다.
 *
 * 방문배열을 만들고 처음부터 돌면서 방문하지 않은 정점이 있다면 dfs탐색을 돌리고
 * 연결개수1증가.
 *
 * 깊이 우선 탐색(DFS, Depth-First Search)
 */

//6 5
//1 2
//2 5
//5 1
//3 4
//4 6

//2
public class Doit_023 {
    static int graph[][];
    static boolean visited[];
    static int N, count;

    public static void main(String[] args) throws Exception{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        //5
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); //1
            int y = Integer.parseInt(st.nextToken()); //2

            // 무방향 그래프 특성.
//            graph[x][y] = 1;
//            graph[y][x] = 1;
            // 간선연결
            graph[x][y] = graph[y][x] = 1;
        }

        count = 0;

        for(int i = 1; i <=N; i++){
            if (visited[i] == false){ //방문을 하지 않음.
                DFS(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void DFS(int index) {

        //이미 방문한 곳은 탐색할 필요X
        if (visited[index] == true){
            return;
        }

        visited[index] = true;
        for(int i = 1; i <=N; i++){
            if(graph[index][i]  == 1){
                DFS(i);
            }
        }
    }
}
