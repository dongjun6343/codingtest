package Doit_전체문제;

import java.util.Scanner;

/**
 *  백준 11660번
 *  구간 합 구하기2
 *
 *  N×N개의 수가 N×N 크기의 표에 채워져 있다. (x1, y1)부터 (x2, y2)까지 합을 구하는 프로그램을 작성하시오.
 *  (x, y)는 x행 y열을 의미한다.
 *
 * 예를 들어, N = 4이고, 표가 아래와 같이 채워져 있는 경우를 살펴보자.
 *
 *  1	2	3	4
 *  2	3	4	5
 *  3	4	5	6
 *  4	5	6	7
 *
 * 여기서 (2, 2)부터 (3, 4)까지 합을 구하면 3+4+5+4+5+6 = 27이고, (4, 4)부터 (4, 4)까지 합을 구하면 7이다.
 *
 * 표에 채워져 있는 수와 합을 구하는 연산이 주어졌을 때, 이를 처리하는 프로그램을 작성하시오.
 *
 *  [입력]
 *  첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다.
 *  (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000) 둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다.
 *  다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다.
 *  표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)
 *
 *  [출력]
 *  총 M줄에 걸쳐 (x1, y1)부터 (x2, y2)까지 합을 구해 출력한다.
 *
 *  ------              ------
 *  입력값                출력값
 *  ------              ------
 *  4 3                   27
 *  1 2 3 4               6
 *  2 3 4 5               64
 *  3 4 5 6
 *  4 5 6 7
 *  2 2 3 4
 *  3 4 3 4
 *  1 1 4 4
 *  ---------------------------------------------------------------------------------------------
 * [HINT]
 * 2차원 구간 합.
 * D[X][Y] = 원본 배열 (0,0)부터 (X,Y) 까지의 사각형 영역 안에 있는 수의 합
 *
 * 1. 2차원 구간 합 배열의 1행, 1열부터 구합니다.
 * 2. 구간 합 배열 1행, 1열은 다음과 같이 구합니다.
 *    D[i][j] = D[i][j-1] - D[i-1][j] - D[i-1][j-1] + A[i][j]
 * 3. 질의에 대한 답을 구간 합으로 구하는 방법
 *    D[X2][Y2] - D[X1-1][Y2] - D[X2][Y1-1] + D[X1-1][Y1-1]
 *
 *  N(배열 크기) M(질의 수) 저장
 *  for(N만큼 반복){
 *    for(N만큼 반복){
 *      원본 배열 저장
 *    }
 *  }
 *
 *  for(N만큼 반복){
 *    for(N만큼 반복){
 *      합 배열 저장
 *       D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]
 *    }
 *  }
 *
 *  for(M만큼 반복){
 *     질의 계산 및 출력하기
 *     결과 = D[X2][Y2] - D[X1-1][Y2] - D[X2][Y1-1] + D[X1-1][Y1-1]
 *  }
 *
 * [CHECK]
 *
 *
 */
public class Doit04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 배열 크기
        int inputLeng = sc.nextInt();
        int[][] arr = new int[inputLeng+1][inputLeng+1];
        // 횟수
        int count = sc.nextInt();

        for (int i=1; i<=inputLeng; i++){
            for (int j=1; j<=inputLeng; j++){
                // 원본 배열에 값 세팅.
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] arrSum = new int[inputLeng+1][inputLeng+1];
        for (int i=1; i<=inputLeng; i++){
            for (int j=1; j<=inputLeng; j++){
                // 원본 배열에 값 세팅.
                arrSum[i][j] = arrSum[i][j-1] + arrSum[i-1][j] - arrSum[i-1][j-1] + arr[i][j];
            }
        }

        for (int i=0; i<count; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int result = arrSum[x2][y2] - arrSum[x1-1][y2] - arrSum[x2][y1-1] + arrSum[x1-1][y1-1];
             //D[X2][Y2] - D[X1-1][Y2] - D[X2][Y1-1] + D[X1-1][Y1-1]
            System.out.println(result);
        }
    }
}
