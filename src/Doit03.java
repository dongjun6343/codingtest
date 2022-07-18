import java.util.Scanner;

/**
 *  백준 11659번
 *  구간 합 구하기
 *
 *  수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
 *
 *  [입력]
 *  첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
 *  둘째 줄에는 N개의 수가 주어진다.
 *  수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
 *  [출력]
 *  총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
 *  ------              ------
 *  입력값                출력값
 *  ------              ------
 *  5 3                   12
 *  5 4 3 2 1             9
 *  1 3                   1
 *  2 4
 *  5 5
 *
 *  ---------------------------------------------------------------------------------------------
 *  합 배열 S 정의
 *  A[0]부터 A[i]까지의 합
 *  S[i] = A[0] + A[1] + ... + A[i-1] + A[i]
 *  S[i] = S[i - 1] + A[i] // 합 배열
 *
 *  구간 합을 구하는 공식
 *  S[j] - S[i-1] : i에서 J까지의 구간 합
 *
 *  1. N개의 수를 입력받으면서 동시에 합 배열을 생성한다. (S[i] = S[i - 1] + A[i])
 *  2. 구간 i ~ j 까지 정해지면 구간 합을 구하는 공식으로 정답을 출력한다.
 *
 *  A : 배열
 *  S : 합 배열
 *
 *  [Check]
 *  arr[0] = 0; 으로 설정하자!
 */
public class Doit03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 배열 길이값.
        int inputLeng = sc.nextInt();
        // 2. 구간 합을 구하는 횟수
        int inputSumLeng = sc.nextInt();

        // 배열 생성
        int[] arr = new int[inputLeng+1];

        arr[0] = 0;

        // 0 5 9 12 14 15
        for (int i = 1; i<=inputLeng; i++){
            // 배열에 값 세팅
            // 동시에 합 배열 생성
            arr[i] = arr[i-1] + sc.nextInt();
        }

        // 구간 정하기
        for(int i = 0; i<inputSumLeng; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(arr[b] - arr[a-1]);
        }
    }
}
