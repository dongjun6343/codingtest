package Doit_핵심유형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
 */
public class Doit_054 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        //건물의 개수
        for (int i = 0; i <= N; i++){
            A.add(new ArrayList<>());
        }

        // 진입 차수 배열
        int[] indegree = new int[N+1];
        int[] selfBuild = new int[N+1]; //자기 자신을 짓는데 걸리는 시간.
        for(int i = 0; i <= N; i++){

        }

        // 위상정렬 작성하기.
    }
}
