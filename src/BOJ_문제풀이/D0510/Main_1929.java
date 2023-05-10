package BOJ_문제풀이.D0510;

import java.util.*;

// 3  16

// 3
// 5
// 7
// 11
// 13

// 소수 구하기
// 에라토스테네스의 체 알고리즘을 사용해서 - 소수를 구해보자
public class Main_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();


        int[] A = new int[N + 1];
        // 입력
        for (int i = 2; i < A.length; i++){
            A[i] = i;
        }


        for(int i = 2; i <= Math.sqrt(N); i++){ // 제곱근까지만.
            if(A[i] == 0){
                continue;
            }
            for(int j = i + i; j <= N; j = j+i){ //배수 지우기
                A[j] = 0;
            }
        }

        // 출력
        for (int i = M; i <= N; i++){
            if(A[i] != 0){
                System.out.println(A[i]);
            }
        }
    }
}

