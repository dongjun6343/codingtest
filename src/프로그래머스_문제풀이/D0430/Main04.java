package 프로그래머스_문제풀이.D0430;


public class Main04 {

    public static void main(String[] args) {
        Main04 m = new Main04();
        System.out.println(m.solution("try hello world"));
    }

    public String solution(String s) {
        //1. 공백을 기준으로 나눈다.

        String[] list = s.split(" ");
        String answer = "";

        for(int i = 0; i < list.length; i++) {
            answer += " "; // 공백 추가
            for(int j = 0; j < list[i].length(); j++) {
                String ch = list[i].substring(j , j+1);
                //2. 짝수는 대문자 , 홀수는 소문자
                if(j % 2 == 0) {
                    answer += ch.toUpperCase();
                } else {
                    answer += ch.toLowerCase();
                }
            }
        }
        return answer.substring(1); // 앞 공백 제거
    }
}

