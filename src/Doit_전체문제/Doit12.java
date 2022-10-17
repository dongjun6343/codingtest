package Doit_전체문제;

import java.util.Scanner;
import java.util.Stack;

/**
 *  백준 17298번
 *  오큰수 구하기
 *
 *
 *  [입력]
 *
 *  [출력]
 *
 *  ------              ------
 *  입력값                출력값
 *  ------              ------
 *
 *
 *  ---------------------------------------------------------------------------------------------
 *  [HINT]
 *  1. 스택에 새로 들어오는 수가 top에 존재하는 수보다 크면 그 수는 오큰수가 된다.
 *  2. 오큰수를 구한 후 수열에서 오큰수가 존재하지 않는 숫자에 -1을 출력해야한다.
 *  [CHECK]
 *
 */
// 오큰수
// 4 수열의 개수
// 3 5 2 7
public class Doit12
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수열의 개수 입력받기
        int[] A = new int[n]; // 입력받은 수열의 값으로 배열 생성
        int[] ans = new int[n]; // 정답 배열 생성
        for(int i = 0; i<n; i++) {
            A[i] = sc.nextInt(); // 배열에 값 생성.
        }

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0); // 처음엔 값이 없으므로 push

        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                ans[stack.pop()] = A[i]; //삭제하고 확인.
            }
            stack.push(i); // 신규데이터 삽입.
        }

        // 스택이 비어있지 않다면 다빌때까지
        while(!stack.isEmpty())	{
            ans[stack.pop()] = -1;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

