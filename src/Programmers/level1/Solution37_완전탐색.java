package Programmers.level1;


import java.util.Arrays;
import java.util.Collections;

/**
 * [최소직사각형]
 *
 * 문제 설명
 * 명함 지갑을 만드는 회사에서 지갑의 크기를 정하려고 합니다.
 * 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서,
 * 작아서 들고 다니기 편한 지갑을 만들어야 합니다.
 * 이러한 요건을 만족하는 지갑을 만들기 위해 디자인팀은 모든 명함의 가로 길이와 세로 길이를 조사했습니다.
 *
 * 아래 표는 4가지 명함의 가로 길이와 세로 길이를 나타냅니다.
 *
 * 명함번호	가로길이	세로길이
 *    1	      60	  50
 *    2	      30	  70
 *    3	      60	  30
 *    4	      80	  40
 * 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다.
 * 하지만 2번 명함을 가로로 눕혀 수납한다면 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다.
 * 이때의 지갑 크기는 4000(=80 x 50)입니다.
 *
 * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
 * 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * sizes의 길이는 1 이상 10,000 이하입니다.
 * sizes의 원소는 [w, h] 형식입니다.
 * w는 명함의 가로 길이를 나타냅니다.
 * h는 명함의 세로 길이를 나타냅니다.
 * w와 h는 1 이상 1,000 이하인 자연수입니다.
 *
 * 입출력 예
 *          sizes	                                result
 * [[60, 50], [30, 70], [60, 30], [80, 40]]	         4000
 * [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	 120
 * [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	 133
 *
 *
 * 두 개의 모서리를 비교하여 큰 값을 전부 가로, 작은 값을 전부 세로로 두면
 * 각 모서리의 길이의 최댓값이 답이 된다.
 * 가로 : 60 70 60 80 , 세로 : 50 30 30 40
 */
class Solution37_완전탐색 {

    public static void main(String[] args) {
        Solution37_완전탐색 s = new Solution37_완전탐색();
//        System.out.println(s.solution(new int[][]{{60, 50}, {30, 70},{60, 30},{80, 40}));
        System.out.println(s.solution(new int[][]{{60, 50},{30, 70},{60, 30},{80, 40}}));
    }
    public int solution(int[][] sizes) {
        int answer = 0;
        int a = 0; //가로
        int b = 0; //세로
        Integer[] chk1 = new Integer[sizes.length];
        Integer[] chk2 = new Integer[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < sizes[i].length; j++) {
//                System.out.println(sizes[i][j] + " ");

                if(j == 0){
                    a = sizes[i][j];
                } else if(j == 1){
                    b = sizes[i][j];
                }
            }
            if(a > b){
                chk1[i] = a;
                chk2[i] = b;
            } else {
                chk1[i] = b;
                chk2[i] = a;
            }
        }

        Arrays.sort(chk1, Collections.reverseOrder());
        Arrays.sort(chk2, Collections.reverseOrder());

        answer = chk1[0] * chk2[0];

        return answer;
    }
}

/**
 * class Solution {
 *     public int solution(int[][] sizes) {
 *         return Arrays.stream(sizes).reduce((a, b) -> new int[]{
 *                 Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])), Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
 *         }).map(it -> it[0] * it[1]).get();
 *     }
 * }
 */
