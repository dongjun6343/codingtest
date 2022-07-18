import java.util.Scanner;

/**
 *  백준 2018번
 *  연속된 자연수의 합 구하기.
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
 *  1. 입력받은 값을 N에 저장한 후 코드에서 사용할 변수를 모두 초기화한다.
 *  2. 투 포인트 원칙을 활용해 배열의 끝까지 탐색하면서 합이 N이 될 경우의 수를 구한다.
 *      - sum > N : sum = sum - start_index; start_index++;
 *      - sum < N : end_index++; sum = sum + end_index;
 *      - sum == N : end_index++; sum = sum + end_index; count++;
 *  3. 2단계를 end_index 가 N이 될때까지 반복, 포인터가 이동할 떄마다 현재의 총합과 N을 비교해 값이 같으면 count를 1만큼 증가.
 *
 *  [CHECK]
 *
 */
public class Doit06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();


    }
}
