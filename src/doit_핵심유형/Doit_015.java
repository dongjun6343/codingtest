package doit_핵심유형;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 수 정렬하기
 * 2750번
 *
 */

// 5

// 5
// 2
// 3
// 4
// 1

// 1
// 2
// 3
// 4
// 5
public class Doit_015 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] k = new int[n];

        for(int i = 0; i < n; i++){
            k[i] = sc.nextInt();
        }
        Arrays.sort(k);

        for (int val : k) {
            System.out.println(val);
        }
    }
}
