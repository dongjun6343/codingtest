package 프로그래머스_문제풀이.D0502;

import java.util.HashMap;

// 완주하지 못한 선수
public class Main06 {
    public static void main(String[] args) {
        Main06 s = new Main06();
        System.out.println(s.solution(new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hm = new HashMap<>();
        
        //참가
        for(String p : participant){
            hm.put(p, hm.getOrDefault(p , 0) + 1);
        }

        //완주
        for(String c : completion){
            hm.put(c, hm.getOrDefault(c , 0) + 1);
        }

        //동명이인o , 한명빼고 완주
        for(String key : hm.keySet()){
            if(hm.get(key) % 2 != 0){
                answer = key;
            }
        }
        return answer;
    }
}
