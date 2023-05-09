package BOJ_문제풀이.D0509;

import java.util.*;


// 10  => 수의 개수
// 1 2 3 4 5 6 7 8 9 10
public class Main_1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = 0;

        //A배열에 데이터 저장
        long[] A = new long[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextLong();
        }



        Arrays.sort(A);
        for(int k = 0 ; k < N ; k++) {
            long find = A[k];
            int i = 0; // 앞
            int j = N-1; //뒤
            while(i < j){
                if(A[i] + A[j] == find){
                    // find의 값은 k이면 안된다.
                    if( i != k && j != k ){ // 배열의 값
                        result++;
                        break;
                    }
                } else if(A[i] + A[j] > find){
                    j--;
                } else {
                    i++;
                }
            }
        }
    }
}
