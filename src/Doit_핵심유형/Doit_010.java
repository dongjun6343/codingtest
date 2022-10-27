package Doit_핵심유형;


// 11003번
// 일정범위 안에서 최솟값을 구하는 문제
// 슬라이딩 윈도우와 정렬을 사용하자!
// ==> 하지만 이 문제는 정렬을 사용하지 않고 슬라이딩 원도우와 덱을 이용해 정렬효과를 보는것이다.

// Deque

// 12 3
// 1 5 2 3 6 2 3 7 3 5 2 6

// 1 1 1 2 2 2 2 2 3 3 2 2

import java.io.*;
import java.util.*;


public class Doit_010 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new LinkedList<>();

        for (int i = 0; i < N; i++){

            int nowValue = Integer.parseInt(st.nextToken());

            // 값이 들어올떄마다 정렬 대신 현재 수보다 크면 덱에서 제거한다.
            while (!deque.isEmpty() && deque.getLast().value > nowValue){
                deque.removeLast();
            }
            deque.addLast(new Node(nowValue, i));

            // 범위에서 벗어난 값 - 덱에서 제거
            // deque.getFirst().index : 0 -> 2 -> 8 -> 10
            if (deque.getFirst().index <= i - L){
                // 첫번째값 제거.
                deque.removeFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
