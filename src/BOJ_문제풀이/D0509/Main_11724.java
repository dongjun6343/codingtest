package BOJ_문제풀이.D0509;


//문제
//방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

//입력
//첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2)
//둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

//출력
//첫째 줄에 연결 요소의 개수를 출력한다.

//6 5
//1 2
//2 5
//5 1
//3 4
//4 6

//2

//간선 -> 그래프 -> dfs -> 재귀.

import java.util.*;
public class Main_11724 {

    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 6
        int m = sc.nextInt(); // 5

        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < n+1; i++){ //인접 리스트 초기화
            A[i] = new ArrayList<>();
        }

        // A 인접 리스트에 그래프 데이터 저장하기
        for(int i = 0; i < m; i++){ // 5번 반복
            int start = sc.nextInt();
            int end = sc.nextInt();
            A[start].add(end);
            A[end].add(start);
        }

        // 노드의 개수만큼 반복
        // 방문하지 않았으면
        // 연결개수++ ,
        // DFS 실행하기
        int count = 0;
        for(int i = 1; i < n + 1; i++){ // 6번반복
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }

        System.out.println(count);

    }

    // DFS 구현하기
    // if(현재 노드 == 방문 노드) - 이미 방문했으니 return;
    // 현재 노드의 연결 노드 중 방문하지 않은 노드로  DFS 실행
    private static void DFS(int i) {
        if(!visited[i]){
            visited[i] = true; //방문처리
            for(int k : A[i]){
                if(!visited[k]){
                    // 연결노드 중 방문하지 않은 노드
                    DFS(k);
                }
            }
        }
    }
}
