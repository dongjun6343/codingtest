package Doit_전체문제;

import java.util.Scanner;

// 퀵정렬
// 피벗을 중심으로 계산
// K번쨰에 있는 수를 구하는 프로그램.

// 5 2				2
// 4 1 2 3 5
public class Doit19
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt(); // 피벗

        int[] A = new int[N];

        // 배열에 값 할당
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }


    // 퀵정렬
    public static void quickSort(int[] A, int S, int E, int K) {
        // K : 찾는 수
        // p == k : 종료
        // p < k : 왼쪽만 정렬
        // p > k : 오른쪽만 정렬
        if(S < E) {
            int pivot = partition(A, S, E);
            if(pivot == K) {
                return;
            } else if(K < pivot) {
                quickSort(A, S, pivot-1 , K); //왼쪽만 정렬
            } else {
                quickSort(A, pivot+1, E, K); //오른쪽만 정렬
            }
        }

    }

    // 파티션
    public static int partition(int[] A, int S, int E) {
        int M = (S + E) / 2;
        swap(A, S, M);
        int pivot = A[S];
        int i = S;
        int j = E;
        while(i < j) {
            while(pivot < A[j]) {
                j--;
            }
            while(i < j && pivot >= A[i]) {
                i++;
            }
            swap(A, i, j);
        }

        A[S] = A[i];
        A[i] = pivot;
        return i;
    }

    // swap
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
