package Programmers.level2;



/**
 * [행렬의 곱셈]
 * 문제 설명
 * 2차원 행렬 arr1과 arr2를 입력받아,
 * arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
 *
 * 제한 조건
 * 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
 * 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
 * 곱할 수 있는 배열만 주어집니다.
 *
 * 입출력 예
 * arr1                 	                         arr2	                                 return
 * [[1, 4], [3, 2], [4, 1]]	                 [[3, 3], [3, 3]]	                 [[15, 15], [15, 15], [15, 15]]
 * [[2, 3, 2], [4, 2, 4], [3, 1, 4]]	[[5, 4, 3], [2, 4, 1], [3, 1, 1]]	[[22, 22, 11], [36, 28, 18], [29, 20, 14]]
 *
 *
 *
 */
class Solution46 {

    public static void main(String[] args) {
        Solution46 s = new Solution46();
        System.out.println(s.solution(new int[][]{{1,4},{3,2},{4,1}}, new int[][]{{3,3},{3,3}}));
    }
    public int[][] solution(int[][] arr1, int[][] arr2) {

        //1. 행, 열 구하기
        int row = arr1.length;
        int col = arr2[0].length;

        int[][] answer = new int[row][col];

        // [0][0]*[0][0] + [0][1]*[1][0]
        // [0][0]*[1][0] + [0][1]*[1][1]

        return answer;
    }
}
