package Doit_전체문제;

import java.util.Scanner;

/**
 *  백준 11399번
 * ATM 인출시간 계산하기
 *  [입력]
 *
 *  [출력]
 *
 *  ------              ------
 *  입력값                출력값
 *  ------              ------
 *  5                    32
 *  3 1 4 3 2
 *  ---------------------------------------------------------------------------------------------
 *  [HINT]
 *
 *  [CHECK]
 *
 */
public class Doit18
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        int[] A = new int[N];
        int[] S = new int[N];  //합배열.


        for(int i = 0 ;i< N; i++) {
            A[i] = sc.nextInt();
        }

        // 삽입정렬
        for(int i = 1; i < N; i++) {
            int insert_point = i; // 1
            int insert_value = A[i]; //1

            for(int j = i - 1; j >= 0; j--) {
                // 3       1
                // 1       4
                if(A[j] < A[i]) {
                    insert_point = j + 1;
                    break;
                }
                if(j == 0) {
                    insert_point = 0;
                }
            }

            for (int j = i; j > insert_point; j--) {
                A[j] = A[j-1];
            }
            A[insert_point] = insert_value;
        }

        S[0] = A[0];
        for(int i = 1; i < N; i++) { // 합배열.
            S[i] = S[i-1] + A[i];
        }

        int sum = 0;
        for(int i = 0; i < N; i++) { // 합배열 총합
            sum = sum + S[i];
        }
        System.out.println(sum);

    }
}


