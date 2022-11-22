package Programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 자연수 뒤집어 배열로 만들기
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 *
 * n	     return
 * 12345	[5,4,3,2,1]
 */
class Solution05 {
    public static void main(String[] args) {
        Solution05 s = new Solution05();
        System.out.println(s.solution(12345));
    }
    public int[] solution(long n) {
//        int[] answer = {};
        String strN = String.valueOf(n);
        int[] answer  = new int[strN.length()];

        for (int i = 0; i < strN.length(); i++){
//            substring(2,3) : 3
//            substring(1,2) : 2
//            substring(0,1) : 1
            answer[i] = Integer.parseInt(strN.substring(strN.length()-i-1, strN.length()-i));
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}

// return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
