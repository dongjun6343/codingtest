package 프로그래머스_문제풀이.D0315;

import java.util.LinkedList;
import java.util.Queue;

//두 큐 합 같게 만들기
//문제 설명
//길이가 같은 두 개의 큐가 주어집니다.
//하나의 큐를 골라 원소를 추출(pop)하고, 추출된 원소를 다른 큐에 집어넣는(insert) 작업을 통해 각 큐의 원소 합이 같도록 만들려고 합니다.
//이때 필요한 작업의 최소 횟수를 구하고자 합니다. 한 번의 pop과 한 번의 insert를 합쳐서 작업을 1회 수행한 것으로 간주합니다.
//
//큐는 먼저 집어넣은 원소가 먼저 나오는 구조입니다. 이 문제에서는 큐를 배열로 표현하며, 원소가 배열 앞쪽에 있을수록 먼저 집어넣은 원소임을 의미합니다.
//즉, pop을 하면 배열의 첫 번째 원소가 추출되며, insert를 하면 배열의 끝에 원소가 추가됩니다.
//예를 들어 큐 [1, 2, 3, 4]가 주어졌을 때, pop을 하면 맨 앞에 있는 원소 1이 추출되어 [2, 3, 4]가 되며, 이어서 5를 insert하면 [2, 3, 4, 5]가 됩니다.
//
//다음은 두 큐를 나타내는 예시입니다.
//
//queue1 = [3, 2, 7, 2]
//queue2 = [4, 6, 5, 1]
//두 큐에 담긴 모든 원소의 합은 30입니다. 따라서, 각 큐의 합을 15로 만들어야 합니다. 예를 들어, 다음과 같이 2가지 방법이 있습니다.
//
//queue2의 4, 6, 5를 순서대로 추출하여 queue1에 추가한 뒤, queue1의 3, 2, 7, 2를 순서대로 추출하여 queue2에 추가합니다.
//그 결과 queue1은 [4, 6, 5], queue2는 [1, 3, 2, 7, 2]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 7번 수행합니다.

//queue1에서 3을 추출하여 queue2에 추가합니다. 그리고 queue2에서 4를 추출하여 queue1에 추가합니다.
//그 결과 queue1은 [2, 7, 2, 4], queue2는 [6, 5, 1, 3]가 되며, 각 큐의 원소 합은 15로 같습니다.
// 이 방법은 작업을 2번만 수행하며, 이보다 적은 횟수로 목표를 달성할 수 없습니다.
//따라서 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수는 2입니다.
//
//길이가 같은 두 개의 큐를 나타내는 정수 배열 queue1, queue2가 매개변수로 주어집니다.
//각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수를 return 하도록 solution 함수를 완성해주세요.
// 단, 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1을 return 해주세요.
//
//제한사항
//1 ≤ queue1의 길이 = queue2의 길이 ≤ 300,000
//1 ≤ queue1의 원소, queue2의 원소 ≤ 109
//주의: 언어에 따라 합 계산 과정 중 산술 오버플로우 발생 가능성이 있으므로 long type 고려가 필요합니다.
//입출력 예
//queue1	queue2	result
//[3, 2, 7, 2]	[4, 6, 5, 1]	2
//[1, 2, 1, 2]	[1, 10, 1, 2]	7
//[1, 1]	[1, 5]	-1
//입출력 예 설명
//입출력 예 #1
//
//문제 예시와 같습니다.
//
//입출력 예 #2
//
//두 큐에 담긴 모든 원소의 합은 20입니다. 따라서, 각 큐의 합을 10으로 만들어야 합니다.
//queue2에서 1, 10을 순서대로 추출하여 queue1에 추가하고,
// queue1에서 1, 2, 1, 2와 1(queue2으로부터 받은 원소)을 순서대로 추출하여 queue2에 추가합니다.
//그 결과 queue1은 [10], queue2는 [1, 2, 1, 2, 1, 2, 1]가 되며, 각 큐의 원소 합은 10으로 같습니다.
// 이때 작업 횟수는 7회이며, 이보다 적은 횟수로 목표를 달성하는 방법은 없습니다. 따라서 7를 return 합니다.
//
//입출력 예 #3
//어떤 방법을 쓰더라도 각 큐의 원소 합을 같게 만들 수 없습니다. 따라서 -1을 return 합니다.

public class Main01 {

    public static void main(String[] args) {

        Main01 s = new Main01();
        System.out.println(s.solution(new int[]{3, 2, 7, 2}, new int[] {4, 6, 5, 1}));

    }

    // 정리.
    // 길이가 같은 두 개의 큐가 주어집니다.
    // 두 큐에 담긴 모든 원소의 합은 20입니다.
    // 따라서, 각 큐의 합을 10으로 만들어야 합니다.

    // 큐1에서 큐2로 전부 보낼경우 = n번
    //현재 큐1=0 , 큐 2= 2n개
    //2. 다시 큐2에서 큐1로 전부 보낼경우 = 2n 번
    //현재 큐1=2n개, 큐2= 0
    //3n의 교체를 거치면 모든 경우의수를 탐색할 수 있다.


    // 1. 한쪽큐를  원소의합/2 로 만든다.
    // 2. 큐1을 기준으로 큐2번을 교체한다.
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long chkHap = 0; // 기준값 (q1 합)
        long total = 0; // 전체값. (q1 + q2)

        for(int i = 0; i < queue1.length; i++) {
            chkHap += queue1[i];

            total += queue1[i];
            total += queue2[i];

            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        total = total / 2;
        int maxCount  = queue1.length * 3;

        while(chkHap != total) {

            if(maxCount == 0) {
                return -1;
            }
            //  17        15
            if(chkHap > total) {
                int chk = q1.poll();
                q2.offer(chk);
                chkHap -= chk;
            } else {
                int chk = q2.poll();
                q1.offer(chk);
                chkHap += chk;
            }
            maxCount--;
        }
        return queue1.length * 3 - maxCount;
    }
}
