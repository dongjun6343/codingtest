package Doit_핵심유형;


import java.lang.reflect.Array;
import java.util.*;

/**
 * DFS와 BFS 프로그램
 * 1260번.
 *
 * 입력
 * (N : 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V )
 * (M : 간선이 연결하는 두 정점의 번호 )
 * 4 5 1
 * 1 2
 * 1 3
 * 1 4
 * 2 4
 * 3 4
 *
 * 출력
 * (첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.)
 * 1 2 4 3
 * 1 2 3 4
 */
public class Doit_026 {

    static boolean visited[];
    static ArrayList<Integer>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //노드 개수
        int M = sc.nextInt(); //에지 개수
        int Start = sc.nextInt(); //시작점
        
        // 그래프 데이터 저장 인접 리스트
       A = new ArrayList[N+1];
        
        // A의 인접리스트 초기화
        for (int i = 1; i <= N; i++){
            A[i] = new ArrayList<>();
        }

        // A의 인접리스트에 데이터 그래프 저장.
        for(int i = 0; i<M; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();

            A[S].add(E);
            A[E].add(S);
        }

        // 정렬.
        for(int i = 1; i <= N; i++){
            Collections.sort(A[i]);
        }
        
        visited = new boolean[N + 1]; //방문 배열 초기화
        DFS(Start);
        System.out.println();
        visited = new boolean[N + 1]; //방문 배열 초기화
        BFS(Start);
        System.out.println();
    }

    private static void DFS(int index){

        System.out.print(index + " ");

        visited[index] = true; // 방문

        for (int i : A[index]) {
            // 방문하지 않으면 재귀함수
            if(!visited[i]){
                DFS(i);
            }
        }
    }

    /**
     * 스택(stack)이란 쌓아 올린다는 것을 의미한다.
     *  따라서 스택 자료구조라는 것은 책을 쌓는 것처럼 차곡차곡 쌓아 올린 형태의 자료구조를 말한다.
     *  스택에서 top을 통해 삽입하는 연산을 'push', top을 통한 삭제하는 연산을 'pop'이라고 한다
     *  LIFO
     *
     *  -------------------------
     *
     *  Queue : 대기줄
     *  FIFO
     *  너비 우선 탐색(BFS, Breadth-First Search) 구현
     */


    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()){
            int now_Node = queue.poll();
            System.out.print(now_Node + " ");
            for (int i: A[now_Node]) {
                if (!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
