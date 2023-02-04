package Programmers.유형.큐_스택;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [기능개발]
 */
class Solution_큐_스택_01_1 {
    public static void main(String[] args) {
        Solution_큐_스택_01_1 s = new Solution_큐_스택_01_1();
        System.out.println(s.solution(new int[]{93, 30, 55},  new int[]{1, 30, 5}));
    }
    // FIFO : 큐. -> LinkedList();
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            queue.offer((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));
        }
        // queue : 7 3 9
        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()){
            int day = queue.poll(); // 7

            int cnt = 1;
            // 7 >= 3 ?
            while(!queue.isEmpty() && day >= queue.peek()){
                cnt++; // 2
                System.out.println("cnt = " + cnt);
                queue.poll(); // 3 제거
            }
            answer.add(cnt);
        }

        // 결과 List 배열로 변환
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
