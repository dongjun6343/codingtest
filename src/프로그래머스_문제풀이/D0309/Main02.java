package 프로그래머스_문제풀이.D0309;

import java.util.Stack;


// 짝지어 제거 하기
// baabaa -> bbaa -> bb -> empty => 1
// baabaa -> bbaab -> bb -> b => 비어있지 않으므로 0

public class Main02 {
    public static void main(String[] args) {

        Main02 s = new Main02();
        System.out.println(s.solution("baabaa"));
    }
    public int solution(String s) {
        // 짝지어 제거? 괄호문제랑 비슷하다. => 스택으로 풀어야 할듯!

        Stack<Character> stack = new Stack<>();

        // b a a b a a
        for(char ch : s.toCharArray()) {
            // 스택이 비어있지 않고, 스택에서 고른값과 char값이 같으면, 스택에서 해당 값 삭제한다.
            if(!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch); // b a
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
