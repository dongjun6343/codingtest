import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *  백준 1546번
 *  평균 구하기
 *
 *  세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다.
 *  일단 세준이는 자기 점수 중에 최댓값을 골랐다.이 값을 M이라고 한다.
 *  그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
 *  예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
 *  세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
 *
 *  [입력]
 *  첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 둘째 줄에 세준이의 현재 성적이 주어진다.
 *  이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
 *  [출력]
 *  첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.
 *
 *  ------              ------
 *  입력값                출력값
 *  ------              ------
 *  3                    75.0
 *  40 80 60
 *
 *  ---------------------------------------------------------------------------------------------
 * [HINT]
 *  1. 점수를 1차원 배열에 저장한다
 *  2. 배열을 탐색하며 최고 점수와 점수의 총합을 구한다
 *  3. 모든 점수에 (점수/M)*100 으로 연산한 뒤 새로운 평균
 *
 *  [CHECK]
 *  소수점이 있으니 double형을 생각하자.
 */
public class Doit02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 과목의 개수
        int inputLeng = sc.nextInt();
        // 과목의 개수만큼 배열생성
        double[] arr = new double[inputLeng];

        // 입력한 값 배열에 세팅
        for (int i = 0; i<inputLeng; i++ ) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        double arrMax = arr[inputLeng-1];
        double sum = 0;
        for (double val : arr) {
            // ((점수값/최고값)*100)
            sum += ((val / arrMax) * 100);
        }
        // 과목수로 나누기.
        System.out.println(sum / inputLeng);
    }
}
