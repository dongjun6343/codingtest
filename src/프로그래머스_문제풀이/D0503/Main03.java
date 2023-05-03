package 프로그래머스_문제풀이.D0503;

import java.util.ArrayList;
import java.util.Comparator;

public class Main03 {
    public static void main(String[] args) {
        Main03 m = new Main03();
        System.out.println(m.solution(new int[]{5,0,2,7}));
    }

    public int[] solution(int[] numbers) {

        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = {};
        // 5 + 0  5 => 0 1
        // 5 + 2  7 => 0 2
        // 5 + 7  12 => 0 3
        // 0 + 2  2 => 1 2
        // 0 + 7  7 => 1 3
        // 2 + 7  9 => 2 3
        //          => 3 3이면 종료해야됨.
        int num = 0;
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i+1; j <numbers.length; j++){
                num = numbers[i] + numbers[j];

                if(!list.contains(num)){ // 중복된 값 제거
                    list.add(num);
                }
            }
        }
        list.sort(Comparator.naturalOrder()); // 오름차순

        answer = list.stream().mapToInt(Integer::intValue).toArray(); // list => int[]배열에 값 넣기

        return answer;
    }
}
