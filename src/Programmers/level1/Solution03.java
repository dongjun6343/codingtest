package Programmers.level1;

import java.util.Arrays;

/**
 * 평균구하기
 *
 * [1,2,3,4]  2.5
 * [5,5]      5
 */
class Solution03 {
    public static void main(String[] args) {
        Solution03 s = new Solution03();
        int i[] = {1,2,3,4};
        System.out.println(s.solution(i));
    }
    public double solution(int[] arr) {
        double answer = 0;
        for(int i = 0; i < arr.length; i++){
            answer += arr[i];
        }
        answer = answer/arr.length;

        return answer;
    }

    // return (int) Arrays.stream(arr).average().orElse(0);
}
