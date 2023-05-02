package 프로그래머스_문제풀이.D0501;


// 문자열 내 p와 y의 개수
public class Main04 {
    public static void main(String[] args) {
        Main04 s = new Main04();
        System.out.println(s.solution("pPoooyY"));
    }

    boolean solution(String s) {

        boolean answer = true;

        String chk = s.toUpperCase();

        int pCount = chk.length() - chk.replace("P", "").length();
        int yCount = chk.length() - chk.replace("Y", "").length();

        if(pCount == yCount){
            return true;
        } else {
            return false;
        }
    }
}
