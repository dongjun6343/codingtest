package Programmers.level1;


import java.util.Arrays;
import java.util.Collections;

/**
 * 문제 설명
 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 *
 * 제한 사항
 * str은 길이 1 이상인 문자열입니다.
 *
 * 입출력 예
 *     s  	     return
 * "Zbcdefg"	"gfedcbZ"
 */
class Solution23 {

    public static void main(String[] args) {
        Solution23 s = new Solution23();
        System.out.println(s.solution("Zbcdefg"));
    }
    public String solution(String s) {
        String answer = "";
        String arr[] = new String[s.length()];
        for (int i = 0; i < s.length(); i++){
            arr[i] = s.substring(i, i+1);
        }

        Arrays.sort(arr, Collections.reverseOrder());
        for(String asc : arr) {
            answer += asc;
        }
        return answer;
    }
}
