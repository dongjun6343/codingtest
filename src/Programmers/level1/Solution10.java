package Programmers.level1;



/**
 * 함수 solution은 정수 x와 자연수 n을 입력 받아,
 * x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
 * 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
 *
 * 제한조건
 * x는 -10000000 이상, 10000000 이하인 정수입니다.
 * n은 1000 이하인 자연수입니다.
 *
 * x	n	answer
 * 2	5	[2,4,6,8,10]
 * 4	3	[4,8,12]
 * -4	2	[-4, -8]
 *
 */
class Solution10 {
    public static void main(String[] args) {
        Solution10 s = new Solution10();
        System.out.println(s.solution(2,5));
    }
    public long[] solution(int x, int n) {
        // x 값을 n 만큼(for문) 곱해서 배열에 넣는다.
        long[] answer = new long[n];
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum = x * ((long)i+1);
            answer[i] = sum;
        }
        return answer;
    }
}