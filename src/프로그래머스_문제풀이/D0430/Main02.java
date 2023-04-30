package 프로그래머스_문제풀이.D0430;


public class Main02 {
    public static void main(String[] args) {
        Main02 s = new Main02();
        s.solution(new int[][] {{1, 4}, {3, 2}, {4, 1}},
                new int[][] {{3, 3}, {3, 3}});
    }
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // m*n n*k 행렬의 곱셈 결과는 m*k 행렬이다.
        // 결과의 배열 생성
        int[][] answer = new int[arr1.length][arr2[0].length]; // 3x2

        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[i].length; j++){
                for(int k = 0; k < arr1[0].length; k++){ // A의 열개수만큼 or B의 행개수
                    answer[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }
        return answer;
    }
}

