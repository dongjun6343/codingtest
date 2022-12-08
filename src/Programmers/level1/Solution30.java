package Programmers.level1;


/**
 *
 *문제 설명
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수,
 * solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
 * 예를 들어 두 수 3, 12의 최대공약수는 3,
 * 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 *
 * 제한 사항
 * 두 수는 1이상 1000000이하의 자연수입니다.
 *
 * 입출력 예
 * n	m	return
 * 3	12	[3, 12]
 * 2	5	[1, 10]
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * 위의 설명과 같습니다.
 *
 * 입출력 예 #2
 * 자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.
 *
 * 최대공약수(GCD, Greatest Common Divisor)
 * A. 두 수 중 작은 수를 선택한 다음 1부터 작은 자연수까지의 모든 수로 두 수를 나누면서 동시에 나누어 떨어지는 가장 큰 수를 구한다.
 * B. 유클리드 호제법
 *
 * 최소공배수 (LCM)
 * 최소공배수는 두 자연수의 곱 / 최대 공약수 라는 공식으로 구할 수 있습니다.
 */
class Solution30 {

    public static void main(String[] args) {
        Solution30 s = new Solution30();
        System.out.println(s.solution(3,12));
    }

    private int GCD(int x, int y) {
        if(y == 0) {
            return x;
        } else {
            return GCD(y, x % y);
        }
    }

    private int LCD(int x, int y, int gdc) {
        int lcd = x * y / gdc;
        return lcd;
    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int gcd = GCD(n,m);
        answer[0] = gcd;

        int lcd = LCD(n,m, gcd);
        answer[1] = lcd;

        return answer;
    }
}