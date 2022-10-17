package Doit_전체문제;

import java.util.Scanner;

/**
 *  백준 1427번
 * 수의 자릿수를 내림차순으로 정렬하시오.
 *  [입력]
 *
 *  [출력]
 *
 *  ------              ------
 *  입력값                출력값
 *  ------              ------
 *  2143                 4321
 *  ---------------------------------------------------------------------------------------------
 *  [HINT]
 *
 *  [CHECK]
 *
 */
public class Doit17
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 값입력
        String str = sc.next();
        int[] A = new int[str.length()];
        for(int i = 0; i < str.length(); i++){
            A[i] = Integer.parseInt(str.substring(i,i+1));
        }

        for(int i = 0; i < str.length(); i++){
            int Max = i;
            // 내림차순이므로 최댓값을 찾는다.
            for(int j = i+1; j < str.length(); j++){
                // A[j]값이 크다면
                if(A[j] > A[Max]){
                    Max = j;
                }
            }
            if(A[i] < A[Max]){
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }
        for (int i = 0; i < str.length(); i++)
        System.out.print(A[i]);
    }
}

