package Doit_핵심유형;

import java.util.Scanner;

/**
 * 1929
 * 소수 구하기.
 * M이상 N이하의 소수
 *
 * 3 16
 *
 * 3
 * 5
 * 7
 * 11
 * 13
 *
 * 일반적인 소수 방법으로 구하면 시간 초과가 발생함.
 * 에라토스테네스 방법으로 푼다.
 *
 * 1. N+1 배열 선언 후 인덱스 값 채우기
 * 2. 1은 소수가 아니므로 삭제
 * 3. 2부터 N의 제곱근까지의 값 탐색.
 *  - 값이 인덱스값이면 그대로, 그 값의 배수를 탐색해서 0으로 변경
 * 4. 배열에 남아있는 수 중 M이상 N이하의 수 모두 출력.
 *
 */
public class Doit_037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] A = new int[N+1];

        for (int i = 2; i < A.length; i++){
            A[i] = i;
        }
        // 제곱근
        for(int i = 2; i < Math.sqrt(N); i++ ){
            if(A[i] == 0){
                continue;
            }
            // 배수 지우기
            for(int j= i + i; j <= N; j = j + i){
                A[j] = 0;
            }
        }
        for(int i = M; i <=N; i ++){
            if(A[i] != 0)
            System.out.println(A[i]);
        }
    }
}
