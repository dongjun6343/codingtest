package 프로그래머스_문제풀이.D0310;

import java.util.PriorityQueue;

//더 맵게
//문제 설명
//매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
//
//섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
//Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
//Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
//
//제한 사항
//scoville의 길이는 2 이상 1,000,000 이하입니다.
//K는 0 이상 1,000,000,000 이하입니다.
//scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
//모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
//입출력 예
//scoville	K	return
//[1, 2, 3, 9, 10, 12]	7	2
//입출력 예 설명
//스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
//새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
//가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]
//
//스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
//새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
//가진 음식의 스코빌 지수 = [13, 9, 10, 12]
//
//모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.

public class Main01 {

    public static void main(String[] args) {

        Main01 s = new Main01();

        System.out.println(s.solution(new int[] {1, 2, 3, 9, 10, 12}, 7));

    }

    // 우선 순위 큐를 사용해서 풀어보자.
    // 우선순위 큐(Priority Queue)는 들어간 순서에 상관없이 우선순위가 높은 데이터가 먼저 나오는 것

    public int solution(int[] scoville, int K) {

        // 1. 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        // 2. Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.

        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++) {
            queue.offer(scoville[i]);
        }

        while(queue.peek() < K ) {
            if(queue.size() == 1) {
                // 사이즈가 1이면 섞은 음식의 스코빌 지수가 X
                return -1;
            } else {
                queue.offer(queue.poll() + queue.poll() * 2);
                answer++;
            }
        }
        return answer;
    }

}