package Doit_핵심유형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1516
 * 위상정렬
 *
 * 어떤 건물을 짓기 위해 먼저 지어야하는 건물이 있다.
 * 건물 == 노드
 * 노드 순서를 정렬한다.
 *
 * 위상 정렬(Topology Sort)은 '순서가 정해져있는 작업'을 차례로 수행해야 할 때
 * 그 순서를 결정해주기 위해 사용하는 알고리즘
 *
 * 입력
 * 5
 * 10 -1
 * 10 1 -1
 * 4 1 -1
 * 4 3 1 -1
 * 3 3 -1
 *
 * 출력
 * 10
 * 20
 * 14
 * 18
 * 17
 *
 */
public class Doit_054 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 위상정렬에 사용할 그래프 2차원 리스트로 구현.
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        //건물의 개수
        for (int i = 0; i <= N; i++){
            A.add(new ArrayList<>());
        }

        int[] indegree = new int[N+1];  //진입차수 배열
        int[] selfBuild = new int[N+1]; //자기 자신을 짓는데 걸리는 시간.
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 건물을 짓는데 걸리는 시간.
            selfBuild[i] = Integer.parseInt(st.nextToken());
            // -1이면 종료(break)
            while(true){
                int preTemp = Integer.parseInt(st.nextToken());
                if(preTemp == -1){
                    break;
                }
                A.get(preTemp).add(i);
                indegree[i]++;
            }
        }

        // 위상 정렬
        // 큐 : 선입선출.
        Queue<Integer> queue = new LinkedList<>();

        //Queue - 보관할 때 offer 메서드
        for (int i = 0; i <= N; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int[] result = new int[N + 1];
        while(!queue.isEmpty()){
            //poll()
            //큐 맨 앞에 있는 값 반환 후 삭제
            //큐가 비어있을 경우 null 반환
            int now = queue.poll();
            for(int next : A.get(now)){
                // 타깃 노드 진입 차수 배열 --
                indegree[next]--;
                //결과 노드 업데이트 = Math.max(현재 지정된 값, 현재 출발 노드 + 비용)
                result[next] = Math.max(result[next], result[now] + selfBuild[now]);
                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        for(int i = 1; i <= N; i++){
            System.out.println(result[i] + selfBuild[i]);
        }
    }
}
