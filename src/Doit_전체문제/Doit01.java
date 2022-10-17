package Doit_전체문제;

import java.util.Scanner;

/**
 *  백준 11720번
 *
 *  숫자의 합 구하기
 *  N개의 숫자가 공백없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.
 *
 *  입력
 *  1번째 줄에 숫자의 개수 N(1<= N <= 100) , 2번째 줄에 숫자 N개가 공백 없이 주어진다.
 *
 *  출력
 *  입력으로 주어진 숫자 N개의 합을 출력한다.
 *
 *  -------                            -------
 *  예제입력                               출력
 *  -------                            -------
 *                                        1
 *  1 // 숫자의 개수
 *  1 // 공백 없이 주어진 N개의 숫자
 */

public class Doit01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 숫자의 개숫
        int inputLeng = sc.nextInt();

        int sum = 0;
        String inputValue = sc.next();
        for (int i = 0; i<inputLeng; i++ ){
            //아스키코드값 빼기. 48 , '0'
            sum += inputValue.charAt(i)-'0';
        }
        System.out.println(sum);
    }
}