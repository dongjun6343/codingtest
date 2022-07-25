import java.util.Scanner;

/**
 *  백준 2018번
 *  연속된 자연수의 합 구하기.
 *  어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
 *  당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서,
 *  이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다.
 *  이때, 사용하는 자연수는 N이하여야 한다.
 *  예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다.
 *  반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.
 *  N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.
 *
 *  [입력]
 * 첫 줄에 정수 N이 주어진다.
 *  [출력]
 * 입력된 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 출력하시오
 *  ------              ------
 *  입력값                출력값
 *  ------              ------
 *    15                   4
 *
 *  ---------------------------------------------------------------------------------------------
 *  [HINT]
 *  1. 입력받은 값을 N에 저장한 후 코드에서 사용할 변수를 모두 초기화한다.
 *  2. 투 포인트 원칙을 활용해 배열의 끝까지 탐색하면서 합이 N이 될 경우의 수를 구한다.
 *      - sum > N : sum = sum - start_index; start_index++;
 *      - sum < N : end_index++; sum = sum + end_index;
 *      - sum == N : end_index++; sum = sum + end_index; count++;
 *  3. 2단계를 end_index 가 N이 될때까지 반복, 포인터가 이동할 떄마다 현재의 총합과 N을 비교해 값이 같으면 count를 1만큼 증가.
 *
 *  [CHECK]
 *  sum < 찾고자 하는 값 -->
 *      sum이 더 작으니까 값을 늘려주어야 한다.
 *      start 값은 그대로 두고, end 값을 1 늘려주고 그 end 인덱스의 값을 sum에 더해준다.
 *  sum > 찾고자 하는 값 -->
 *      sum이 더 크니까 값을 줄여주어야 한다.
 *      end 값은 그대로 두고, start 인덱스 값을 sum에서 빼주고 start값을 1 늘려서 갱신해준다.
 *
 *  투 포인트 원칙 - 알고리즘 문제에 자주 등장하니 꼭 익히자.
 */
public class Doit06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start_index = 1;
        int end_index = 1;
        int count = 1; // 자기자신은 무조건 있으니 +1
        int sum = 1;
        // end_index가 N이면 stop.
        while (end_index != N ) {
            if (sum > N ){
                sum = sum - start_index;
                start_index++;
            } else if(sum < N) {
                end_index++;
                sum = sum + end_index;
            } else if(sum == N){
                end_index++;
                sum = sum + end_index;
                count++;
            }
        }
        System.out.println(count);
    }
}
