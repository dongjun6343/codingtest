package Programmers.level2;



/**
 * [올바른 괄호]
 *
 * 문제 설명
 * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
 *
 * "()()" 또는 "(())()" 는 올바른 괄호입니다.
 * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고,
 * 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 문자열 s의 길이 : 100,000 이하의 자연수
 * 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
 *
 * 입출력 예
 *    s	   answer
 * "()()"	true
 * "(())()"	true
 * ")()("	false
 * "(()("	false
 *
 */
class Solution32 {

    public static void main(String[] args) {
        Solution32 s = new Solution32();
//        System.out.println(s.solution("(())()"));
//        System.out.println(s.solution("()("));
    }
    boolean solution(String s) {
        boolean answer = true;

        String[] a = new String[s.length()];
        int x = 0;
        int y = 0;

        for(int i = 0 ; i < s.length(); i++){
            a[i] = s.substring(i,i+1);
            if(")".equals(a[0])){
                return false;
            }
        }
        int i = 0;
        int countA = 0;
        int countB = 0;

        while (i < s.length()){
            if("(".equals(a[i])){
                countA++; // 0 1  4
                i++; // 0 1
            } else {
                // 2번 돌기. 2 3
                for(int j = 0; j < countA; j++){
                    // 3 4
                    System.out.println( (a[i]) + " : " + i);
                    if(")".equals(a[i])){
                        countB++;
                    }
                    i++;
                }
                if(countA != countB){
                    return false;
                }

                // countA,B 초기화
                countA = 0;
                countB = 0;
            }
        }
        return answer;
    }
}