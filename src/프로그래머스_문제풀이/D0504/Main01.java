package 프로그래머스_문제풀이.D0504;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main01 {

    public static void main(String[] args) {
        Main01 m = new Main01();
        System.out.println(m.solution("Zbcdefg"));
    }

    public String solution(String s) {
        String answer = "";
        // a = 97
        // Z = 90
        ArrayList<Character> list = new ArrayList<>();
        for (char ch : s.toCharArray()){
            list.add(ch);
            list.sort(Collections.reverseOrder());
        }

        for(int i = 0; i < list.size(); i++){
            answer += list.get(i).toString();
        }


        return answer;
    }
}
