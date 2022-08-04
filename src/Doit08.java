import java.util.Arrays;
import java.util.Scanner;

/**
 *  백준 1253번
 *  '좋은 수' 구하기
 *
 * N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
 * N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
 * 수의 위치가 다르면 값이 같아도 다른 수이다.
 *
 * [입력]
 * 첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)
 *
 * [출력]
 * 좋은 수의 개수를 첫 번째 줄에 출력한다.
 *
 *  ------                       ------
 *  입력값                         출력값
 *  -----                        ------
 * 10 // 수의개수                    8
 * 1 2 3 4 5 6 7 8 9 10
 *
 *  ---------------------------------------------------------------------------------------------
 *  [HINT]
 *  1. 수를 입력받아 배열에 저장한 후 정렬한다.
 *  2. 투 포인터 i, j를 양쪽 끝에 위치시킨 후 포인터 이동 원칙 활용
 *      - A[i] + A[j] > M : j--;
 *      - A[i] + A[j] < M : i++;
 *      - A[i] + A[j] == M : i++; j--; count++;
 *  3. K가 N이 될때까지 반복하며 좋은 수가 몇개인지 셉니다.
 *  [CHECK]
 *
 */
public class Doit08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputLeng =  sc.nextInt();
        int result = 0;
        int[] A = new int[inputLeng];

        for(int i = 0; i < inputLeng; i++){
            A[i] = sc.nextInt();
        }
        // 수를 입력받아 오름차순으로 정렬
        Arrays.sort(A);

        for (int k = 0; k<inputLeng; k++) {
            int find = A[k];
            int i = 0;
            int j = inputLeng - 1;
            // 투포인트 알고리즘
            while( i < j){
                if(A[i] + A[j] == find) {
                    // find는 서로 다른 두 수의 합이어야 함을 체크
                    if(i != k && j !=k ){
                        result++;
                        break;
                    } else if (i == k ){
                        i++;
                    } else if (j == k){
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        System.out.println(result);
    }
}
