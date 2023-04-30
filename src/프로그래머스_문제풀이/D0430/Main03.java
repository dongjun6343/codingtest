package 프로그래머스_문제풀이.D0430;


// 자연수 뒤집어 배열로 만들기
// 문자열 관련 문제
// 1. substring, trim, compareTo, indexOf
public class Main03 {

    public static void main(String[] args) {
        Main03 m = new Main03();
        m.solution(12345);
    }

    public int[] solution(long n) {
        String chk = String.valueOf(n);
        int[] answer = new int[chk.length()];

        int num = 0;

        for( int i = 0 ;  i < chk.length(); i++) {

            num = Integer.parseInt(
                    chk.substring(chk.length()-i-1 ,chk.length()-i));
            answer[i] = num;
        }
        return answer;
    }
}

