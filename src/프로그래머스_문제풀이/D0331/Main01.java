package 프로그래머스_문제풀이.D0331;


//함수 solution은 정수 x와 자연수 n을 입력 받아,
//x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
//다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
//x	n	answer
//2	5	[2,4,6,8,10]
//4	3	[4,8,12]
//-4	2	[-4, -8]

public class Main01 {

    public static void main(String[] args) {
        Main01 s = new Main01();
//        System.out.println(s.solution(2, 5));
        System.out.println(s.solution(-4, 2));
    }

    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i =0; i<n; i++) {
            if(i == 0) {
                answer[i] = x;
            }else {
                answer[i] = answer[i-1] + x;
            }

        }
        return answer;
    }

}

