package 프로그래머스_문제풀이.D0504;

import java.util.Stack;


// 올바른 괄호
public class Main03 {
    public static void main(String[] args) {
        Main03 s = new Main03();
        System.out.println(s.solution("(())()"));

    }

    boolean solution(String s) {
        boolean answer = true;

        //pop push peek
        Stack<Character> stack = new Stack<>();


        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            } else if (ch == ')'){
                if(stack.isEmpty()){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }

        return answer;
    }
}
