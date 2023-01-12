package 알고리즘_study;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * "소수가 되는 수의 배수를 지우면 남은 건 소수가 된다"라고 생각하는 알고리즘 ( 소수 구하는 알고리즘 )
 *  소수가 무엇인지 찾을 필요가 없으며 2부터 자기 자신을 제외한 배수가 되는 것을 지운다.
 *
 * 1. 2부터 소수를 구하고자 하는 구간의 모든 수를 나열한다.
 * 2. 소수가 되는 수의 배수를 지우면 남은 건은 소수만 된다
 * 3. 자기 자신을 제외한 2의 배수를 모두 지운다.
 * 4. 남아 있는 수 가운데 3은 소수이므로 오른쪽에 3을 쓴다.
 * 5. 자기 자신을 제외한 3의 배수를 모두 지운다.
 * 6. 남아 있는 수 가운데 5는 소수이므로 오른쪽에 5를 쓴다.
 * 7. 자기 자신을 제외한 5의 배수를 모두 지운다.
 * 위 과정을 반복한다.
 *
 * [정리]
 * 2가 맨 처음이고 2의 배수를 다 삭제한다.
 * 그 다음 3이 맨 처음값이고 3의 배수를 다 삭제한다.
 * 그 다음 5가 맨 처음에고 5의 배수를 다 삭제한다 ...
 *
 */
public class Study_에라토스테네스의_체 {

    public static void main(String[] args) {
        primeNumber(71);
    }

    public static void primeNumber(int num) {
        // 배열에 원소 삽입
        int[] array = new int[num + 1];
        for (int i = 2; i <= num; i++) {
            array[i] = i;
        }

        for (int i = 2; i <= num; i++) {
            // 배열이 이미 0이면 건너뜀
            if (array[i] == 0) {
                continue;
            }

            // i의 배수인 원소들을 모두 지워줌
            for (int j = i * i; j <= num; j += i) {
                array[j] = 0;
            }
        }

        // 0이 아닌(지워지지 않은) 숫자들만 출력
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
