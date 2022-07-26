import java.util.Scanner;

/**
 *  백준 1253번
 *  '좋은 수' 구하기
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
        sc.nextInt();


    }
}
