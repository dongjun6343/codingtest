package Programmers.level1;


import java.util.Arrays;

/**
 * 자연수 n이 매개변수로 주어집니다.
 * n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요.
 * 답이 항상 존재함은 증명될 수 있습니다.
 *
 * 제한사항
 * 3 ≤ n ≤ 1,000,000
 *
 * n	result
 * 10	  3
 * 12	  11
 */
class Solution11 {
    public static void main(String[] args) {
        Solution11 s = new Solution11();
        System.out.println(s.solution(12));
    }
    public int solution(int n) {
        // 3부터 n 까지 나눠서 나머지가 1인 수만 배열에 담아서
        // 오름차순으로 정렬 후
        // 첫번째값을 꺼낸다.
        int answer = 0;
        int[] temp = new int[n];
        for(int i = 1; i < n; i++){
            int bang = 0;
            if(n%i == 1){
                temp[bang] = i;
                break;
            }
            bang++;
        }
        answer = temp[0];
        return answer;
    }
}

//    public int solution(int n) {
//        int answer = 1;
//
//        while(n % answer != 1){
//            answer++;
//        }
//        return answer;
//    }