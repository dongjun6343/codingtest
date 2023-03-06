package Programmers.유형.큐_스택;


import java.util.LinkedList;
import java.util.Queue;

/**
 * [다리를 지나는 트럭]
 * 문제 설명
 * 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다.
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
 * 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며,
 * 다리는 weight 이하까지의 무게를 견딜 수 있습니다.
 * 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.
 *
 * 예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다.
 * 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 *
 * 경과 시간	      다리를 지난 트럭	    다리를 건너는 트럭	대기 트럭
 * 0	[]	         []	                    [7,4,5,6]
 * 1~2	[]	        [7]	                    [4,5,6]
 * 3	[7]	        [4]           	        [5,6]
 * 4	[7]    	    [4,5]	                [6]
 * 5	[7,4]	    [5]	[6]
 * 6~7	[7,4,5] 	[6]	[]
 * 8	[7,4,5,6]	[]	[]
 * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
 *
 * solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length,
 * 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
 * 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 *
 * 제한 조건
 * bridge_length는 1 이상 10,000 이하입니다.
 * weight는 1 이상 10,000 이하입니다.
 * truck_weights의 길이는 1 이상 10,000 이하입니다.
 * 모든 트럭의 무게는 1 이상 weight 이하입니다.
 * 입출력 예
 * bridge_length	weight	truck_weights	                return
 * 2	                10	[7,4,5,6]	                     8
 * 100	                100	[10]	                         101
 * 100	                100	[10,10,10,10,10,10,10,10,10,10]	 110
 */

//5, 5, [2,2,2,2,1,1,1,1,1], 19




/**
 * 큐를 다리라고 생각하고 트럭을 큐에 넣고 빼면서 다리에 오르는 것을 구현.
 * 고려조건.
 * 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있다.
 * 트럭이 다리에 올라가면 1초.
 * 그 후 다리위에서 1칸씩 움직이면 1초 +
 *
 */
class Solution_큐_스택_02 {
    public static void main(String[] args) {
        Solution_큐_스택_02 s = new Solution_큐_스택_02();
        System.out.println(s.solution(2, 10 , new int[]{7,4,5,6}));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> queue = new LinkedList();
        int sum = 0;
        int time = 0;


        for(int truck : truck_weights){
            // for문이 끝날때까지 계속 반복.
            while (true) {
                //1. 큐에 아무것도 없는경우
                if(queue.isEmpty()){
                    queue.offer(truck);
                    sum += truck;
                    time++;
                    break; // 다시 while문
                } else if(queue.size() == bridge_length){
                    //2. 큐가 가득찬 경우
                    // 가장 앞에 넣은 트럭이 다리의 끝에 도달
                    // poll 메서드로 꺼낸다.
                    // 다리에서 내릴때는 시간이 들지 않는다.
                    sum = sum - queue.poll();
                } else {
                    //3. 큐가 가득차지 않은경우
                    //3-1. weight 값을 넘지 않는 선에서 새로운 트럭을 다리에 올려줌
                    if(sum + truck <= weight){
                        queue.offer(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        //3-2. 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 함
                        queue.offer(0);
                        time++;
                    }

                }
            }
        }

        // 반복문의 특성 상 트럭의 경우 마지막 다리에는 올랐지만 다 건너지 못한다.
        // 따라서 지금까지 걸린 시간 + 마지막 트럭이 건너는데 걸리는 시간인 다리의 길이를 더한다.
        return time + bridge_length;
    }
}
