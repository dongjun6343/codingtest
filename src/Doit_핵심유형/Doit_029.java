package Doit_핵심유형;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 원하는 정수 찾기.
 * 1920
 *  
 *  
 * 5    // 데이터 개수
 * 4 1 5 2 3
 * 5    // 찾아야 할 숫자 개수
 * 1 3 7 9 5
 *
 *
 * 1
 * 1
 * 0
 * 0
 * 1
 *
 * 이진탐색 알고리즘 사용
 * 정렬 데이터 중에서 원하는 데이터를 탐색할 때 사용하는 가장 일반적인 알고리즘.
 * 대상 데이터의 중앙값과 찾고자 하는 값을 비교해 데이터의 크기를 절반씩 줄인다.
 */
public class Doit_029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        //정렬.
        Arrays.sort(A);

        int M = sc.nextInt();
        for(int i = 0; i < M; i++){
            boolean find = false;

            int target = sc.nextInt();
            int start = 0;
            int end = A.length - 1;
            while(start <= end){
                // 1. 중앙값 > 타겟 : 종료인덱스 = 중간인덱스 - 1
                // 2. 중앙값 < 타겟 : 시작인덱스 = 중간인덱스 + 1
                // 3. 중앙값 == 타겟 : 종료

                int mid = (start+end)/2;
                int minV = A[mid];

                if(minV > target){
                    end = mid-1;
                } else if(minV < target){
                    start = mid+1;
                } else {
                    find = true;
                    break;
                }
            }
            if(find){
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
