package 프로그래머스_문제풀이.D0502;

import java.util.HashMap;

public class Main04 {
    public static void main(String[] args) {
        Main04 m = new Main04();
        System.out.println(m.solution("allpe", "apple"));
    }

    public int solution(String before, String after) {

        int answer = 1;

        HashMap<String, Integer> hm = new HashMap<>();
        for(char ch : before.toCharArray()){
            String key = String.valueOf(ch);
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }
        for(char ch : after.toCharArray()){
            String key = String.valueOf(ch);
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }
        // hm의 value가 홀수면 짝이 안맞는다
        System.out.println(hm.toString());

        for (Integer value : hm.values()) {
            if(value % 2 != 0) {
                return 0;
            }
        }
        return answer;
    }
}
