package 프로그래머스_문제풀이.D0407;


// 최대공약수, 최소공배수
// 유클리드 호제법 알고리즘을 사용해보자.
public class Main01 {

        public static void main(String[] args) {
            Main01 s = new Main01();
            System.out.println(s.solution(new int[]{2,6,8,14}));
//        System.out.println(s.solution(new int[]{2,7}));
        }

        public int solution(int[] arr) {
        int answer = arr[0];

        for(int i = 1;i<arr.length;i++) {
            // 두 값의 최대공약수
            int gcd = gcd(answer,arr[i]);
            // 두 값의 최소공배수
            answer = answer * arr[i] / gcd;
        }

        return answer;
    }

    //
    private int gcd(int a, int b) {
        int x = Math.max(a,b);
        int y = Math.min(a,b);

        while(x % y != 0){
            int r = x % y;
            x = y;
            y = r;
        }

        return y;
    }
}
