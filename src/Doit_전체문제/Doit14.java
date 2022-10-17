package Doit_전체문제;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *  백준 11286번
 *
 * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
 * 배열에 정수 x (x ≠ 0)를 넣는다.
 * 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
 * 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
 *
 *  [입력]
 *  첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
 *  만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고,
 *  x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 입력되는 정수는 -231보다 크고, 231보다 작다.
 *  [출력]
 *  입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
 *  ------              ------
 *  입력값                출력값
 *  ------              ------
 *
 *  ---------------------------------------------------------------------------------------------
 *  [HINT]
 * PriorityQueue(우선순위 큐)는 먼저 들어온 순서대로 데이터가 나가는 것이 아닌
 * 우선순위를 먼저 결정하고 그 우선순위가 높은 엘리먼트가 먼저 나가는 자료구조입니다.
 * 우선순위 큐는 힙을 이용하여 구현하는 것이 일반적입니다.
 * (응급실과 같이 우선순위를 중요시해야 하는 상황에서 쓰임)
 *
 *  [CHECK]
 *
 *
 *
 */
public class Doit14
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 요청 개수.
        int N = sc.nextInt();
        // 우선순위 큐
        PriorityQueue<Integer> myQueue = new PriorityQueue<Integer>((o1, o2) -> {

            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if(first_abs== second_abs){
                return o1 > o2 ? 1 : -1;
            } else {
                return first_abs  - second_abs; // 절댓값을 기준으로 정렬하기.
            }
        });
        for(int i = 0; i < N; i++){
            int request = sc.nextInt();
            if(request == 0) {
                if(myQueue.isEmpty()){
                    System.out.println("0");
                } else {
                    System.out.println(myQueue.poll());
                }
            } else {
                myQueue.add(request);
            }
        }
    }
}

