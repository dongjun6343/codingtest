package Programmers.level1;


/**
 * 문제 설명
 * 두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서,
 * 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 1 ≤ left ≤ right ≤ 1,000
 *
 * 입출력 예
 * left	    right	result
 * 13	     17	     43
 * 24	     27	     52
 */
class Solution25 {

    public static void main(String[] args) {
        Solution25 s = new Solution25();
        System.out.println(s.solution(1,1));
    }

    int answer = 0;

    public int solution(int left, int right) {
        for(int i = left; i <= right; i++){
            chk(i);
        }
        return answer;
    }
    // 약수의 개수 구하기.
    private int chk(int left) {
        if (left == 1){
            answer -= 1;
        } else {
            int count = 2;
            for(int i = 2; i < left; i++){
                if(left%i == 0){
                    count++;
                }
            }
            // count 짝수? 홀수? 판단.
            if(count%2 == 0){
                answer += left;
            } else {
                answer -= left;
            }
        }
        return answer;
    }
}

/**
 *  left가 1인경우를 빼먹어서 시간이 생각보다 꽤 걸렸다.
 *
 * 제곱수의 경우 약수의 개수가 홀수로 해결할 수도 있다.
 *
 * public int solution(int left, int right) {
 *         int answer = 0;
 *
 *         for (int i=left;i<=right;i++) {
 *             //제곱수인 경우 약수의 개수가 홀수
 *             if (i % Math.sqrt(i) == 0) {
 *                 answer -= i;
 *             }
 *             //제곱수가 아닌 경우 약수의 개수가 짝수
 *             else {
 *                 answer += i;
 *             }
 *         }
 *
 *         return answer;
 *     }
 */