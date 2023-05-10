package BOJ_문제풀이.D0510;

import java.util.Scanner;

// 유니온파인드
public class Main_1717 {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 7 - 원소의 개수
        int M = sc.nextInt(); // 8 - 질의 개수

        parent = new int[N+1];

        for(int i = 0; i <= N; i++){
            parent[i] = i; // 대표노드 초기화
        }

        for(int i = 0; i < M; i++){
            int q = sc.nextInt(); // 0 , 1
            int a = sc.nextInt(); //
            int b = sc.nextInt(); //

            if(q == 0){
                union(a,b);
            } else {
                if(chkSame(a,b)){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean chkSame(int a, int b) { // 두 원소가 같은 집합인지 확인
        a = find(a);
        b = find(b);
        if(a == b){
            return true;
        } else {
            return false;
        }
    }

    private static void union(int a, int b) { // 대표노드끼리 연결하기
        a = find(a);
        b = find(b);

        if( a != b ){
            parent[b] = a;
        }
    }
    private static int find(int v) {
        if( v == parent[v]){
            return v;
        } else {
            return parent[v] = find(parent[v]);
        }
    }
}
