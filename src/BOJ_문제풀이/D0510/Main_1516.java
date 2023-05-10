package BOJ_문제풀이.D0510;

//위상정렬
// 어떤 건물을 짓기 위해서는 다른 건물을 먼저 지어야 한다.

import java.util.*;
public class Main_1516 {

    // 5 : 건물의 종류 수
    // 10 -1
    // 10 1 - 1
    // 4 1 -1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        for( int i = 0; i <= N; i++ ){
            A.add(new ArrayList<>());
        }
        int[] indegree = new int[N+1];
        int[] selfBuild = new int[N+1];

        for( int i = 1; i <= N; i++){
            selfBuild[i] = sc.nextInt(); // 건물을 짓는 시간.

            while(true){
                int preTemp = sc.nextInt();
                if(preTemp == -1){
                    break;
                } else {
                    A.get(preTemp).add(i);
                    indegree[i]++;
                }
            }
        }
        // 위상정렬
        Queue<Integer> q = new LinkedList<>();
        for( int i = 1; i <= N; i++){
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[N+1];
        while(!q.isEmpty()){
            int now = q.poll(); // 0인값 큐에서 뽑기
            for(int next : A.get(now)){
                indegree[next]--;
                // 시간 업데이트
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
        for(int i = 1; i <= N; i++){
            System.out.println(result[i] + selfBuild[i]);
        }

    }
}
