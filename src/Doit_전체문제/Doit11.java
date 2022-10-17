package Doit_전체문제;

import java.util.Scanner;

/**
 *  백준 1874번
 *  스택으로 오름차순 수열 만들기
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
 *  1. 스택의 pop, push 연산과 후입선출 개념 이해.
 *  2. 스택에 넣는 값은 오름차순 정렬이어야 한다!!
 *  [CHECK]
 *
 */
import java.util.Scanner;
import java.util.Stack;


// 스택
// 선입후출
// FILO
// pust , pop
public class Doit11
{
    public static void main(String[] args) throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수열의 개수
        int[] A = new int[N]; // 수열의 배열
        for(int i=0; i<N; i++) {
            //배열값 세팅
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int num = 1; //오름차순 수
        boolean result = true;

        for (int i=0; i<A.length; i++) {
            int su = A[i]; //현재 수열의 수
            if(su >= num) { //1보다 수열의 수가 크냐?
                // 수열의 수가 크면 push해, 얼만큼인지모르니 while
                while(su>= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int n = stack.pop();

                if(n > su) {
                    System.out.println("NO");
                    result =  false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if(result)System.out.println(sb.toString());
    }
}

