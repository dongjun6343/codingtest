package 프로그래머스_문제풀이.D0326;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

//야근 지수
//문제 설명
//회사원 Demi는 가끔은 야근을 하는데요, 야근을 하면 야근 피로도가 쌓입니다.
//야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다.
//Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.
//Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때,
//퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해
//야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.
//
//제한 사항
//works는 길이 1 이상, 20,000 이하인 배열입니다.
//works의 원소는 50000 이하인 자연수입니다.
//n은 1,000,000 이하인 자연수입니다.

//입출력 예
//works	n	result
//[4, 3, 3]	4	12
//[2, 1, 2]	1	6
//[1,1]	3	0
//입출력 예 설명
//입출력 예 #1
//n=4 일 때, 남은 일의 작업량이 [4, 3, 3] 이라면 야근 지수를 최소화하기 위해 4시간동안 일을 한 결과는 [2, 2, 2]입니다.
//이 때 야근 지수는 2의제곱 + 2의제곱 + 2의제곱 = 12 입니다.
//
//입출력 예 #2
//n=1일 때, 남은 일의 작업량이 [2,1,2]라면 야근 지수를 최소화하기 위해 1시간동안 일을 한 결과는 [1,1,2]입니다.
//야근지수는 1의제곱 + 1의제곱 + 2의제곱 = 6입니다.
//
//입출력 예 #3
//
//남은 작업량이 없으므로 피로도는 0입니다.

// 16 9 9
// 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다.
// 일의 작업량 [4,3,3]
// N(4)시간 동안 야근 피로도를 최소화하도록 일할 겁니다.
// 4-2 , 3-1, 3-1 =>  [2,2,2] => 12

//99, [2, 15, 22, 55, 55], 580
public class Main03 {
    public static void main(String[] args) {
        Main03 s = new Main03();
//		System.out.println(s.solution(4, new int[] {4, 3, 3}));
//		System.out.println(s.solution(1, new int[] {2, 1, 2}));
//		System.out.println(s.solution(3, new int[] {1, 1}));
        System.out.println(s.solution(99, new int[] {2, 15, 22, 55, 55}));
    }

    // 어떻게 해야 야근 피로도를 최소화할까?
    // 가장 많은 수부터 하나씩 빼서 저장한다
    // 우선순위 큐를 활용해서 큰값부터 뺴면 될 거 같다!
    public long solution(int n, int[] works) {
        long answer = 0;

        // 우선순위 큐 내림차순
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // 우선순위 큐 값 세팅
        for(int work : works) {
            queue.offer(work);
        }

        try {
            for(int i = 1; i <= n; i++) {
                int chk = queue.remove(); // 큐에서 가장 큰값 제거
                chk = chk - 1; // 그 값을 하나 뺀 후
                if(chk != 0) { // chk값이 0이 아니면 다시 큐에 저장한다.
                    queue.offer(chk);
                }
            }
        } catch (NoSuchElementException e) {
            // 큐에 값이 없으므로 예외발생 시 0으로 리턴시킨다.
            return 0;
        }

        while(!queue.isEmpty()) {
            int chk = queue.remove();
            if(chk != 1) { // 1이면 1만 더한다.
                chk = chk * chk; // 그렇지 않으면 제곱값.
            }
            answer += chk;
        }

        return answer;
    }

}

