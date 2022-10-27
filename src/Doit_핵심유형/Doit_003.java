package Doit_핵심유형;


// 백준 11659번

import java.util.Scanner;

//        5 3
//        5 4 3 2 1
//        1 3
//        2 4
//        5 5

//        12
//        9
//        1
public class Doit_003 {
    public static void main(String[] args) {
        // 합배열
        // S[i] = S[i-1] + A[i]

        Scanner sc = new Scanner(System.in);

        int inputA = sc.nextInt();
        // 구간 정하기
        int inputB = sc.nextInt();

        int[] A = new int[inputA];
        int[] S = new int[inputA+1];
        // 합배열+값세팅
        for (int i = 1; i <= inputA; i++){
            // 배열에 세팅값

            A[i-1] = sc.nextInt();
            // 합배열.
            S[i] = S[i-1] + A[i-1];

        }

        // 구간 정하기
        for(int i = 0; i<inputB; i++  ){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(S[b] - S[a-1]);
        }
    }
}
