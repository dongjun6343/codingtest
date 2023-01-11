package Programmers.큐_스택;


import java.util.*;

/**
 * [주식가격]
 * 문제 설명
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 * prices의 길이는 2 이상 100,000 이하입니다.
 *
 * 입출력                 예
 * prices	            return
 * [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
 *
 * 입출력 예 설명
 * 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
 * 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
 * 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
 * 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
 * 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
 *
 *
 *
 * 문제 이해하는 것부터 어려웠다.
 * 이 문제는 초 별로 주식 가격이 담긴 배열을 주고,
 * 가격이 떨어지지 않는 시간을 각각 구해서 반환하는 문제이다.
 *
 * 1 : 2, 3, 2, 3	=> 끝까지 가격이 떨어지지 않았음		=> 총 4초동안 가격 하락X
 * 2 : 3, 2, 3	=> 마찬가지로 끝까지 가격이 떨어지지 않았음 	=> 총 3초동안 가격 하락X
 * 3 : 2, 3	=> 1초 후 가격이 2로 떨어졌음		=> 총 1초동안 가격 하락X
 * 2 : 3		=> 끝까지 가격이 떨어지지 않았음		=> 총 1초동안 가격 하락X
 * 3 : 		=> 마지막 값이라 측정X			=> 마지막 값이라 0초동안 하락X
 *
 */

class Solution_큐_스택_03 {
    public static void main(String[] args) {
        Solution_큐_스택_03 s = new Solution_큐_스택_03();
        System.out.println(s.solution(new int[]{1, 2, 3, 2, 3}));
    }

    // 통과하지 못하는 테스트가 존재함. (수정필요)
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++ ){
            while (!stack.empty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop(); // 답을 구했으므로 스택에서 제거.
            }
            stack.push(i); // 1 2 3 2 3
        }

        while (!stack.isEmpty()){ // 끝까지 값이 안떨어진 주식일 경우
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
}
