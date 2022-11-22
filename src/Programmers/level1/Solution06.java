package Programmers.level1;

/**
 *정수 제곱근 판별
 *
 * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 *
 * n	return
 * 121	144
 * 3	-1
 *
 * 121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.
 *
 */
class Solution06 {
    public static void main(String[] args) {
        Solution06 s = new Solution06();
        System.out.println(s.solution(121));
    }
    public long solution(long n) {
        // Math.pow(밑, 지수) : 거듭제곱
        long answer = (long) Math.sqrt(n); // 11
        if(Math.pow(answer, 2) == n){
            answer = (long)Math.pow(answer+1, 2);
        }  else {
            answer = -1;
        }
        return answer;
    }
}

//      if (Math.pow((int)Math.sqrt(n), 2) == n) {
//        return (long) Math.pow(Math.sqrt(n) + 1, 2);
//      }
//      return -1;
