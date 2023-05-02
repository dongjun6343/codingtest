package 프로그래머스_문제풀이.D0501;


// 숫자 문자열과 영단어

import java.util.HashMap;

public class Main05 {
    String answer = "";
    public static void main(String[] args) {
        Main05 m = new Main05();
        System.out.println(m.solution("one4seveneight"));
    }

    public int solution(String s) {

        HashMap<String, String> hm = new HashMap<>();
        answer = s;
        hm.put("0",	"zero");
        hm.put("1",	"one");
        hm.put("2",	"two");
        hm.put("3",	"three");
        hm.put("4",	"four");
        hm.put("5",	"five");
        hm.put("6",	"six");
        hm.put("7",	"seven");
        hm.put("8",	"eight");
        hm.put("9",	"nine");
        for(String key : hm.keySet()){
            answer = change(answer, key, hm.get(key));
        }

        return Integer.parseInt(answer);
    }

    private String change(String s, String key, String value) {
        answer = s.replace(value ,key);
        return answer;
    }
}
