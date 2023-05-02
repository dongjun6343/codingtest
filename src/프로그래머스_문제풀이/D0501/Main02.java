package 프로그래머스_문제풀이.D0501;


// 3진법 뒤집기
public class Main02 {
    public static void main(String[] args) {
        Main02 s = new Main02();
        System.out.println(s.solution(45));
    }


//  n(10진법)   n(3진법)	   앞뒤 반전(3진법)	10진법으로 표현
//  45	        1200	        0021	        7
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n >= 1) {

            int a =  n / 3; // 몫 : 15
            int b =  n % 3; // 나머지 : 0

            n = a;

            String m = String.valueOf(b);
            sb.append(m); // 0
        }

        String s = sb.toString();
        int cnt = s.length();
        int x = 1;
        for(char ch : s.toCharArray()){
            int chk = Integer.valueOf(ch+"");
            cnt--; // 4 - 1 = 3
            if(cnt == 0 ){
                answer += chk * 1;
            } else if(chk == 0){
                continue;
            } else {
                for(int i = 1; i <= cnt; i++){
                    x *= 3;
                }
                answer += chk * x;
                x = 1; // x 초기화
            }
        }

        return answer;
    }
}

// for(list의 size까지) {
//	list의 요소에 하나씩 접근하여 3의 3승 ~ 3의 0승까지 곱한 후 더하기
//}

// Math.pow(밑, 지수) = 밑^지수 2^10 => 1024
// Math.pow를 생각해서 다시 한번 풀어보자