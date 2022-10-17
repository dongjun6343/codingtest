package Doit_전체문제;

import java.util.Scanner;

/**
 *  백준 10986번
 *  나머지 합 구하기
 *
 *  수 N개 A1, A2, ..., AN이 주어진다.
 *  이때, 연속된 부분 구간의 합M이 으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
 *  즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
 *
 *  [입력]
 *  첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
 *  둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
 *
 *  [출력]
 *  첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
 *
 *  ------              ------
 *  입력값                출력값
 *  ------              ------
 *  5 3                   7
 *  1 2 3 1 2
 *  ---------------------------------------------------------------------------------------------
 *  [HINT]
 *  1. A배열의 합 배열 S를 생성합니다.
 *  2. 합 배열 S의 모든 값을 M으로 나머지 연산을 수행해 값을 업데이트 합니다.
 *  3. 우선 변경된 합 배열에서 원소 값이 0인 개수만 세어 정답에 더한다.
 *  4. 변경된 합 배열에서 원소 값이 같은 인덱스의 개수. 즉, 나머지 값이 같은 합 배열의 개수를 센다.
 *
 *  [CHECK]
 *
 */
public class Doit05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //1. 수열의 개수
        int N = sc.nextInt();
        //2. 나눠서 떨어져야 할 수
        int M = sc.nextInt();
        //3. 합 배열 선언
        int[] S = new int[N+1];
        //4. 같은 나머지의 인덱스를 카운트하는 배열
        int[] C = new int[N];

        int remainder = 0;
        long result = 0;

        S[0] = 0;
    
        // 합 배열 세팅
        for (int i=1; i<=N; i++ ){
            S[i] = S[i-1] + sc.nextInt();
        }

        for (int i=0; i<N; i++ ) {
            remainder = S[i] % M;
            if (remainder == 0)
                C[i]++;
        }
        // 수정필요.
        for(int i=0;i<N;i++) {
            result += (long)C[i]*(C[i]-1)/2;
        }

        System.out.println(result);
    }
}
