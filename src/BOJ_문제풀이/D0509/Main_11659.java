package BOJ_문제풀이.D0509;


import java.util.*;


//5 3
//5 4 3 2 1
//1 3
//2 4
//5 5

// 구간 합 구하기.
// 맨 처음부터 배열을 합쳐서 생각한다.
public class Main_11659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int suNo = sc.nextInt(); // 5
        int quizNo = sc.nextInt(); // 3

        long[] S = new long[suNo+1];

        for(int i = 1; i <= suNo; i++){
            S[i] = S[i-1] + sc.nextInt(); // 5 4 3 2 1
            System.out.println(S[i]);
        }

        for(int q = 0; q < quizNo; q++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(S[j] - S[i-1]);
        }
    }
}
