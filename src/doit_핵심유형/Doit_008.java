package doit_핵심유형;


// 1253번
// 투포인터 이동원칙
// 앞      뒤
// A[i] + A[j] > K(판별대상) : j--;  A[i] + A[j] < K : i++;
// A[i] + A[j] == K: i++; j--; count++;


// 10
// 1 2 3 4 5 6 7 8 9 10

import java.util.Scanner;

// 8 (3,4,5,6,7,8,9,10은 좋다.)
public class Doit_008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1번쨰 입력 : 10
        int inputFirst = sc.nextInt();
        int[] inputSecond = new int[inputFirst];

        for (int i = 0; i < inputFirst; i++){
            // 배열에 2번쨰 입력값 넣기.
            inputSecond[i] = sc.nextInt();
        }

        int resultCount = 0;

        for (int k = 0; k < inputFirst; k++){
            // 시작점
            int start = inputSecond[0];
            // 끝
            int end = inputSecond[inputFirst-1];
            // 찾는수
            int find = inputSecond[k];
            
            // 투 포인트 알고리즘
            while (start < end) {

                if(find != start && find != end){
                    resultCount++;
                    break;
                }
            }
        }
    }
}
