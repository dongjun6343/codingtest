package Doit_전체문제;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 : 2750번
 * 수 정렬하기
 * N개의 수가 주어졌을 때 이름 오름차순 정렬하는 프로그램을 작성하시오.
 *
 * 1번쨰 줄에 수의 개수 N(1 <= N <= 1,000,000) , 2번째 줄부터는 N개의 줄의 개수가 주어진다.
 * 이 수는 절댓값이 1,000,000보다 작거나 같은 정수다.
 * 수는 중복되지 않는다.
 *
 * --------              --------
 * 예제 입력               예제 출력
 * --------              --------
 * 5                        1
 * 5                        2
 * 2                        3
 * 3                        4
 * 4                        5
 * 1
 *
 *
 */

public class Doit00 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputValue = sc.nextInt();
        // 1. 수의 개수값.
        // 배열생성
        int[] arr = new int[inputValue];
    
        // 입력한 값 배열에 담기
        for (int i = 0; i<inputValue; i++){
            arr[i] = sc.nextInt();
        }
        // Arrays.sort
        // 정렬
        Arrays.sort(arr);

        // 배열에 있는 값 하나씩 출력
        for (int val: arr) {
            System.out.println(val);
        }
    }
}
