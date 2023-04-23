package 프로그래머스_문제풀이.D0423;

//문제 설명
//Finn은 요즘 수학공부에 빠져 있습니다. 수학 공부를 하던 Finn은 자연수 n을 연속한 자연수들로 표현 하는 방법이 여러개라는 사실을 알게 되었습니다.
// 예를들어 15는 다음과 같이 4가지로 표현 할 수 있습니다.
//
//1 + 2 + 3 + 4 + 5 = 15
//4 + 5 + 6 = 15
//7 + 8 = 15
//15 = 15

// 15  4
//자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 return하는 solution를 완성해주세요.

public class Main01 {

    public static void main(String[] args) {
        Main01 s = new Main01();
        System.out.println(s.solution(15));
    }

    public int solution(int n) {
        int answer = 0;
        int chk = 1;
        int hap = 0;

        while(chk <= n){

            for(int i = chk ; i <= n; i++){
                hap = hap + i;
                if(hap == n){
                    answer++;
                    chk++;
                    hap = 0;
                    break;
                } else if(hap > n){
                    chk++;
                    hap = 0;
                    break;
                }
            }

        }
        return answer;
    }

}
