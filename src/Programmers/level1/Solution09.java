package Programmers.level1;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 *  함수 solution은 정수 n을 매개변수로 입력받습니다.
 *  n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
 *  예를들어 n이 118372면 873211을 리턴하면 됩니다.
 *
 *  n	    return
 * 118372	873211
 *
 */
class Solution09 {
    public static void main(String[] args) {
        Solution09 s = new Solution09();
        System.out.println(s.solution(118372));
    }
    public long solution(long n) {
        long answer = 0;
        String[] temp = String.valueOf(n).split("");
        // 내림차순
        Arrays.sort(temp, Collections.reverseOrder());
        // 배열 문자열합치기
        String strJoin = String.join("",temp);

        answer = Long.parseLong(strJoin);
        return answer;
    }
}

//    public long solution(long n) {
//        return Long.parseLong(String.valueOf(n).chars().mapToObj(ch -> (char) ch)
//                .sorted(Comparator.reverseOrder())
//                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//                .toString());
//    }