package doit_핵심유형;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public static void main(String[] args) throws IOException {
        
        // 입출력을 효율적으로 변경
        //Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // int n = sc.nextInt();
        int n = Integer.parseInt(br.readLine());
        int[] k = new int[n];

        for(int i = 0; i < n; i++){
//            k[i] = sc.nextInt();
            k[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(k);

        for (int val : k) {
            sb.append(val).append('\n');
        }

        System.out.println(sb);
    }
}
