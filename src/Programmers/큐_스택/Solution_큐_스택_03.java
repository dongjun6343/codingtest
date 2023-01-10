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
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();
        boolean flag;
        int sum = 0;
        for (int price : prices){
            queue.offer(price);
        }

        while (!queue.isEmpty()){
            flag = false;
            Integer chk = queue.poll();// 1
            Iterator<Integer> iter = queue.iterator();
            while (iter.hasNext()){
                list.add(iter.next());

            } // 2 3 2 3
            for(int a: list){
                // 1     2
                if(chk > a){
                    sum--;
                    flag = true;
                } else {
                    sum++;
                }
            }

            if(flag){
                sum += 1;
                if(sum < 0){
                    answerList.add(0);
                }else {
                    answerList.add(sum);
                }
            } else {
                answerList.add(sum);
            }
            sum = 0; // sum 초기화.
            list.clear(); // list 지우기.
        }
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
