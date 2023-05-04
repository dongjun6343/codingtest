package BOJ_문제풀이.D0504;


import java.util.Scanner;


// https://www.acmicpc.net/submit/2606
// 백준 - 바이러스


//첫째 줄에는 컴퓨터의 수가 주어진다.
//컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
//둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.

//7
//6
//1 2
//2 3
//1 5
//5 2
//5 6
//4 7

//4
public class Main_DFS_01 {

    static boolean[][] graph;
    static boolean[] visited;
    static int answer = 0;

    static int N = 0;
    static int M = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        // 1. 그래프 정보 입력
        int x,y;
        for(int i = 0; i < M; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            graph[x][y] = graph[y][x] = true;
        }
        dfs(1);
        System.out.println(answer - 1);
        sc.close();
    }
    public static void dfs(int index) {
        answer++;
        //방문체크
        visited[index] = true;
        for(int i = 1; i <= N; i++){
            if(!visited[index] && graph[index][i]){
                dfs(i);
            }
        }
    }
}
