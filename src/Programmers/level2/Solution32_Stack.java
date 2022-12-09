package Programmers.level2;


import java.util.Stack;

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
class Solution32_Stack {

    public static void main(String[] args) {
        Solution32_Stack s = new Solution32_Stack();
//        System.out.println(s.solution("(())()"));
        System.out.println(s.solution("()("));
//        System.out.println(s.solution(")()()"));
    }

    // 스택/큐로 구현해보자.
    // pop 꺼내기
    // push 넣기
    // 1.  '(' - 스택에 넣기
    // 2.  ')' - 스택에서 꺼내기
    // 3. 모든 작업이 끝나고 스택이 비어있다면 짝이 완벽히 맞는 올바른 괄호이고, 스택이 비어있지 않다면 올바르지 않은 괄호다.
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length(); i++){
            // i번째 문자.
            char c = s.charAt(i);

            if(c == '('){
                stack.push(c);
            } else if (stack.empty()){
                return false;
            } else {
                stack.pop();
            }

        }
        return stack.empty() ? true : false;
    }
}