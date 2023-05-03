package 프로그래머스_문제풀이.D0503;

import java.util.Arrays;

public class Main01 {


    public static void main(String[] args) {
        Main01 s = new Main01();
        System.out.println(s.solution(6, new int[]{7, 10}));
    }

    //n	times	return
//6	[7, 10]	28
    public long solution(int n, int[] times) {
        long answer = 0;
        //1. 정렬
        Arrays.sort(times);

        //2.
        long left = 0;
        long right = times[times.length - 1] * (long) n; // 모든 사람이 늦게 심사 받는 값

        // 이진탐색 기본 틀
        while (left <= right) {

            long mid = (left + right) / 2;
            long complete = 0;

            // 3-2. 각 심사대 별로 주어진 시간 mid동안 몇명의 사람을 심사할 수 있는지 합산한다.
            //(ex. mid = 10, times = {2, 3, 4}인 경우,  10 / 2 + 10 / 3 + 10 / 4로 총 5+3+2=10명 가능
            for (int time : times) {
                complete += mid / time;
            }

            if (complete < n) { //해당 시간에는 모든 사람이 검사받을 수 없다.
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid; // 모두 검사받았으나, 더 최솟값이 있을 수 있다.
            }
        }
        return answer;
    }
}


//1. 내가 찾아야 할 정답의 범위를 left ~ right로 정한다.
//2. 정답을 mid로 간주한 후, 해당 정답이 유효한지 살펴본다.
//3. 2번 여부를 따지며 left와 right의 범위를 좁힌다.
//4. left > right가 되면 반복을 끝내고 답을 반환한다.