package 프로그래머스_문제풀이.D0414;


import java.util.Stack;

//짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다.
//먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다.
// 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다.
// 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다.
// 문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요.
// 성공적으로 수행할 수 있으면 1을,
// 아닐 경우 0을 리턴해주면 됩니다.
//
//예를 들어, 문자열 S = baabaa 라면
//
//b aa baa → bb aa → aa →
//
//의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
//
//제한사항
//문자열의 길이 : 1,000,000이하의 자연수
//문자열은 모두 소문자로 이루어져 있습니다.
//입출력 예
//s	result
//baabaa	1
//cdcd	0
public class Main03 {
    public static void main(String[] args) {
        Main03 s = new Main03();
        System.out.println(s.solution("cdcd"));

    }

    // 스택으로 풀어보자.
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stack = new Stack<>();


        for(char c : s.toCharArray()){
            if(stack.isEmpty() || stack.peek() != c){
                stack.push(c);
            } else if(stack.peek() == c) {
                stack.pop();
            }
        }

        if(stack.isEmpty()){
            // 모두 제거
            answer = 1;
        } else {
            answer = 0;
        }
        return answer;
    }
}
