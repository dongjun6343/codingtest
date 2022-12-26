package Programmers.level2;


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * [프린터]
 *
 * 문제 설명
 * 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다.
 * 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
 * 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
 * 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
 *
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 *
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 *
 * 3. 그렇지 않으면 J를 인쇄합니다.
 *
 * 예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
 *
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
 *
 * 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와
 * 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
 * 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
 * location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
 *
 * 입출력 예
 * priorities	         location	return
 * [2, 1, 3, 2]	            2	      1            0 1 2        3 2 2 1       C D A B
 * [1, 1, 9, 1, 1, 1]	    0	      5            0 1 2 3 4 5  9 1 1 1 1 1   C D E F A B
 *
 */
class Solution49_우선순위큐 {
    
    // 스택/큐
    public static void main(String[] args) {
        Solution49_우선순위큐 s = new Solution49_우선순위큐();
//        System.out.println(s.solution(new int[]{2,1,3,2} , 2));
        System.out.println(s.solution(new int[]{1, 1, 9, 1, 1, 1} , 0));
    }

    // 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고
    // 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄
    // [2, 1, 3, 2]와 같은 작업 순서가 주어질 때,
    // 현재 실행하려는 작업보다 우선순위가 더 큰 작업이 있는 경우에 현재 작업을 대기열의 맨 끝으로 보내준다. => 우선순위 큐.
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());

        // 우선순위큐에 담는다
       for(int n : priorities){
           // [3, 2, 2, 1]
           pq.offer(n);
       }

        // 큐에 값이 빌때까지 반복
        // priorities 배열을 탐색하며 큐에서 나오는 값과 location이 일치하는 경우
        while (!pq.isEmpty()){
            for (int i = 0; i < priorities.length; i++){
                // Queue에서 첫번째로 저장된 값을 참조하고 싶다면 peek() 사용.
                // 값만 일치하는 경우
                if(pq.peek() == priorities[i]){
                    System.out.println(pq.peek() + " << ");
                    pq.poll(); //해당값을 제거 후 반환.
                    answer++;
                    // 값과 위치가 모두 일치하면 answer을 반환.
                    if(location == i ) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
