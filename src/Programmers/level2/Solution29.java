package Programmers.level2;


import java.util.StringTokenizer;

/**
 *
 * 문제 설명
 * JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
 * 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
 * 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
 *
 * 제한 조건
 * s는 길이 1 이상 200 이하인 문자열입니다.
 * s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
 * 숫자는 단어의 첫 문자로만 나옵니다.
 * 숫자로만 이루어진 단어는 없습니다.
 * 공백문자가 연속해서 나올 수 있습니다.
 *
 *
 * 입출력 예
 *           s	                    return
 * "3people unFollowed me"	   "3people Unfollowed Me"
 * "for the last week"	        "For The Last Week"
 *
 *
 */
class Solution29 {

    public static void main(String[] args) {
        Solution29 s = new Solution29();
        System.out.println(s.solution("3people unFollowed me"));
    }

    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s," ",true);
        // true : " "값도 토큰으로 가져온다.

        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if(" ".equals(word)){
                sb.append(" ");
                continue;
            }
            String a = word.substring(0,1).toUpperCase();
            String b = word.substring(1).toLowerCase();
            sb.append(a).append(b);
        }
        answer = sb.toString();

        return answer;
    }
}


/**
 * StringTokenizer , StringBuilder 사용!
 *
 * 1. StringTokenizer vs split
 * split은 정규식에 사용(가변적인 요소가 많은 문자나 정확한 분리가 필요할때 사용.
 * StringTokenizer는 속도적인 측면에서 좋음.
 *
 *  - StringTokenizer는 결과값이 문자열이라면 split는 결과 값이 문자열 배열이다.
 *
 * 2. +로 문자열을 합쳐서 해보니  런타임 에러 발생.
 * String 객체끼리 더하는 방법은 메모리 할당과 해제를 발생시키는데, 덧셈 연산이 많아진다면 성능적으로 좋지 않다.
 * (왜 그런지???? 이유는 블로그에 정리를 해보자)
 */
