package Programmers.level2;


import java.util.*;

/**
 * [괄호 회전하기]
 *
 * 문제 설명
 * 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
 *
 * (), [], {} 는 모두 올바른 괄호 문자열입니다.
 * 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다.
 * 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
 * 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다.
 * 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
 * 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
 * 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때
 * s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * s의 길이는 1 이상 1,000 이하입니다.
 *
 * 입출력 예
 *    s	          result
 * "[](){}"	        3
 * "}]()[{"	        2
 * "[)(]"	        0
 * "}}}"	        0
 *
 */
class Solution47 {

    public static void main(String[] args) {
        Solution47 s = new Solution47();
        System.out.println(s.solution("[)(]"));
    }
    public int solution(String s) {
        int answer = 0;
        // 몇번 회전을 했을 시 올바른 괄호가 되는지?
        // 스택을 활용해서 체크
        // 앞에 있는 값을 잘라서 뒤로 이동.
        String chk_s = s;

        for(int i = 0; i < s.length(); i++){
            if(checkStack(chk_s)){
                answer++;
            }
            // 앞에있는 문자열을 뒤에 붙인다.
            chk_s = chk_s.substring(1, s.length()) + chk_s.charAt(0);
        }
        return answer;
    }
    private boolean checkStack(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            // ( { [ 스택에 추가.
            // ) } ] 스택의 맨 위를 확인하고 맞으면 pop해준다.
            //push() - 데이터 삽입
            //pop() - 마지막 데이터 꺼내서 반환(삭제)
            //peek() - 마지막 데이터 확인만 하고 스택에서 제거하지 않음.
            try{
                switch (c){
                    case '(' :
                    case '{' :
                    case '[' :
                        stack.push(c);
                        break;
                    case ')' :
                        if(stack.peek() != '('){
                            return false;
                        }
                        stack.pop();
                        break;
                    case '}' :
                        if(stack.peek() != '{'){
                            return false;
                        }
                        stack.pop();
                        break;
                    case ']' :
                        if(stack.peek() != '['){
                            return false;
                        }
                        stack.pop();
                        break;
                }
            } catch (Exception e){
                return false;
            }

        }
        return stack.isEmpty(); //스택이 비어있으면 올바른 괄호.
    }
}
