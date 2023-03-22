package 프로그래머스_문제풀이.D0322;


import java.util.ArrayList;
import java.util.List;

//줄 서는 방법
//문제 설명
//n명의 사람이 일렬로 줄을 서고 있습니다. n명의 사람들에게는
// 각각 1번부터 n번까지 번호가 매겨져 있습니다.
//n명이 사람을 줄을 서는 방법은 여러가지 방법이 있습니다.
// 예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.
//
//[1, 2, 3]
//[1, 3, 2]
//[2, 1, 3]
//[2, 3, 1]
//[3, 1, 2]
//[3, 2, 1]
//사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때,
// k번째 방법을 return하는 solution 함수를 완성해주세요.
//
//제한사항
//n은 20이하의 자연수 입니다.
//k는 n! 이하의 자연수 입니다.
//입출력 예
//n	k	result
//3	5	[3,1,2]
//입출력 예시 설명
//입출력 예 #1
//문제의 예시와 같습니다.

public class Main01 {
    public static void main(String[] args) {
        Main01 s = new Main01();
    }


    // 재귀로 전체 경우의 수를 구하면 X
    // 팩토리얼 문제.
    // 팩토리얼로 전체 경우의 수를 구한 뒤 거기서 범위를 연산해서 순서를 만든다.
    // n! /n 번씩 첫번째 숫자가 나온다.
    // 3! / 3 = 2


    public int[] solution(int n, long k) {

        int[] answer = new int[n];

        List<Integer> people = new ArrayList<Integer>();

        long factorial = 1;
        int index = 0;

        for(int i = 1; i <=n; i++) {
            factorial *= i; //전체값.
            people.add(i);
        }

        k--;
        while(n > 0) {
            factorial /= n; // 첫번째 값 구하기 (범위 설정)
            int value = (int) (k / factorial);
            answer[index++] = people.get(value);

            people.remove(value);

            k %= factorial;
            n--;
        }

        return answer;
    }
}

