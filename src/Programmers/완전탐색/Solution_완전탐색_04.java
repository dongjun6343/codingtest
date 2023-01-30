package Programmers.완전탐색;


import java.util.*;

/**
 * [전력망을 둘로 나누기]
 * 문제 설명
 * n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다.
 * 당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다.
 * 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.
 *
 * 송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다.
 * 전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때,
 * 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * n은 2 이상 100 이하인 자연수입니다.
 * wires는 길이가 n-1인 정수형 2차원 배열입니다.
 * wires의 각 원소는 [v1, v2] 2개의 자연수로 이루어져 있으며,
 * 이는 전력망의 v1번 송전탑과 v2번 송전탑이 전선으로 연결되어 있다는 것을 의미합니다.
 * 1 ≤ v1 < v2 ≤ n 입니다.
 * 전력망 네트워크가 하나의 트리 형태가 아닌 경우는 입력으로 주어지지 않습니다.
 *
 * 입출력 예
 * n	wires	                                           result
 * 9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
 * 4	[[1,2],[2,3],[3,4]]	                                0
 * 7	[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]	            1
 */

class Solution_완전탐색_04 {

    public static void main(String[] args) {
        Solution_완전탐색_04 s = new Solution_완전탐색_04();
        System.out.println(s.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));

    }
    public int solution(int n, int[][] wires) {
        // 1. wires에 있는 숫자 cnt하기. 
        //    1-1 2-1 3-3 4-4 5-1 6-1 7-1 8-1 9-1
        // 2. cnt한 값중 가장 큰값 2개 선택.
        //    3,4
        // 3. [3,4] 배열을 빼고 3과 4가 들어가는 배열 찾기.
        //    1,3 2,3  - A : 2개
        //    4,5 4,6 4,7 - B : 3개
        // 4. 3,4을 뺀 나머지 숫자가 있는 배열 찾기.
        //    (재귀함수 사용해야 할듯 1. 수행동작, 2.탈출조건)
        //    7,8 7,9  -  B : 5개
        // 5. 없으면 A-B를 하고 절대값
        //    답 : 3

        String key = "";
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < 2; j++){
                key = String.valueOf(wires[i][j]);
                hm.put(key,  hm.getOrDefault(key, 0) + 1);
            }
        }
        System.out.println("출력 결과 : " + hm);

        List<String> listKeySet = new ArrayList<>(hm.keySet());
        // 오름차순
        Collections.sort(listKeySet, (value1, value2) -> (hm.get(value2).compareTo(hm.get(value1))));
        int out = 1;
        for(String sortKey : listKeySet) {
            if(out > 2){
                break;
            }
            out = out + 1;
            System.out.println(sortKey + " < key");
        }



        int answer = -1;

        return answer;
    }
}