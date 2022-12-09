package Programmers.level2;


/**
 * 숫자의 표현
 * 문제 설명
 * Finn은 요즘 수학공부에 빠져 있습니다.
 * 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다.
 * 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
 *
 * 1 + 2 + 3 + 4 + 5 = 15
 * 4 + 5 + 6 = 15
 * 7 + 8 = 15
 * 15 = 15
 * 자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.
 *
 * 제한사항
 * n은 10,000 이하의 자연수 입니다.
 * 입출력 예
 * n	result
 * 15	  4
 *
 *
 */
class Solution35 {

    public static void main(String[] args) {
        Solution35 s = new Solution35();
        System.out.println(s.solution(15));
    }
    public int solution(int n) {
        int answer = 0;
        // 1. n보다 작거나 같은 범위를 구한다
        // 2. 해당 범위에 있는 n의 값을 다 더한다.
        // 3. n이랑 같으면 count++
        // 4. n+1을 해서 범위를 다시 설정한다.

        int i = 0;
        int a = 1; // 1,2,3,4,5 .. n
        int total = 0; // a == n 이면 +1하고 종료.(15 -> 15)
        while (a != n){
            for(i = i+a; i < n; i++){
                total = total + i;
                if(total == n){
                    answer++;
                    total = 0; //total값 0으로 초기화.
                    i = 0; // i값 초기화
                    break;
                } else if(total > n){
                    total= 0;
                    i = 0; // i값 초기화
                    break;
                }
            }
            //1 --> 2 --> 3
            a++;
        }
        return answer+1;
    }
}

/**
 * 주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는
 * 주어진 수의 홀수 약수의 개수와 같다라는 정수론 정리를 이용해서 해결할 수도 있다.
 *
 *   public int expressions(int num) {
 *         int answer = 0;
 *         for (int i = 1; i <= num; i += 2) {
 *             if (num % i == 0) {
 *                 answer++;
 *             }
 *         }
 *         return answer;
 *     }
 */