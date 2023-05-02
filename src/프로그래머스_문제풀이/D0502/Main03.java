package 프로그래머스_문제풀이.D0502;

import java.util.HashMap;

public class Main03 {
    public static void main(String[] args) {
        Main03 s = new Main03();
        System.out.println(s.solution("We are the world"));

    }

    public String solution(String my_string) {
        String answer = "";

        HashMap<String, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String key = "";
        for(char ch : my_string.toCharArray()){
            key = String.valueOf(ch);
            hm.put(key, hm.getOrDefault(key, 0) + 1);

            if(hm.get(key) == 1){
                sb.append(key);
            }

        }
        answer = sb.toString();
        return answer;
    }
}
