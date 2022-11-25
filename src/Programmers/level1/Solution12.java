package Programmers.level1;


import java.util.ArrayList;

/**
 * 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
 * 예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
 *
 * 제한 조건
 * a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
 * a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
 * a와 b의 대소관계는 정해져있지 않습니다.
 *
 * a	b	return
 * 3	5	  12
 * 3	3	  3
 * 5	3	  12
 */
class Solution12 {
    public static void main(String[] args) {
        Solution12 s = new Solution12();
        System.out.println(s.solution(5,3));
    }
    public long solution(int a, int b) {
        long answer = 0;
        //1. for문으로 배열에 해당 값 넣기.
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        int temp = 0;
        if(a > b){
          temp = a;
          a = b;
          b = temp;

        }
        for(int i = a; i <= b; i++){
            arrList.add(i);
        }
        for(int chk : arrList) {
            answer += chk;
        }
        return answer;
    }
}

//    public long solution(int a, int b) {
//        return sumAtoB(Math.min(a, b), Math.max(b, a));
//    }
//
//    등차수열.
//    private long sumAtoB(long a, long b) {
//        return (b - a + 1) * (a + b) / 2;
//    }
