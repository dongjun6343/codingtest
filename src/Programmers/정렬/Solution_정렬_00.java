package Programmers.정렬;


import java.util.ArrayList;
import java.util.Comparator;

/**
 * [K번째수]
 * 문제 설명
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 *
 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
 *
 * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
 * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
 * 2에서 나온 배열의 3번째 숫자는 5입니다.
 * 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
 * commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * array의 길이는 1 이상 100 이하입니다.
 * array의 각 원소는 1 이상 100 이하입니다.
 * commands의 길이는 1 이상 50 이하입니다.
 * commands의 각 원소는 길이가 3입니다.
 * 입출력 예
 * array	                              commands	             return
 * [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
 * 입출력 예 설명
 * [1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
 * [1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
 */
public class Solution_정렬_00 {

    public static void main(String[] args) {
        Solution_정렬_00 s = new Solution_정렬_00();
        System.out.println(s.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2,5,3},{4,4,1},{1,7,3}}));
    }
    public int[] solution(int[] array, int[][] commands) {


        // 3. commands : 3 - 3번째 수 뽑기 => 5.
        // 4. 5 리턴.

        //j -> 0 : 구간1
        //j -> 1 : 구간2
        //j -> 2 : 뽑는수
        int start = 0;
        int end = 0;
        int choice = 0;
        ArrayList<Integer> answerList = new ArrayList<>();

        for(int i = 0; i < commands.length; i++){
            for(int j = 0; j < commands[i].length; j++){
                if(j == 0){
                    start = commands[i][j];
                } else if(j == 1){
                    end = commands[i][j];
                } else if(j == 2){
                    choice = commands[i][j];
                }
            }
            // 1. commands : 2,5 - 구간설정
            // int chk[] = new int[end-1];
            ArrayList<Integer> arrchk = new ArrayList<>();

            int cnt = 0;
            // 4 4

            for(int k = start-1; k < end; k++){
                int arr = array[k];
                //chk[cnt] = arr;
                arrchk.add(arr);
                cnt++;
            }
            // 2. 2~5 안에 있는 수 뽑은 후 정렬 => 2,3,5,6 오름차순.
//            arrchk.sort((o1, o2) -> o1.compareTo(o2));
            arrchk.sort(Comparator.naturalOrder());
            System.out.println(arrchk);
            // int pick = chk[choice-1];

            answerList.add(arrchk.get(choice-1));
        }

        int[] answer = new int[answerList.size()];

        for(int i = 0 ; i < answerList.size(); i++){
            answer[i] = answerList.get(i).intValue();
        }

        return answer;
    }
}


/**
 * Arrays.copyOfRange 사용.
 *
 * class Solution {
 *     public int[] solution(int[] array, int[][] commands) {
 *         int[] answer = new int[commands.length];
 *
 *         for(int i=0; i<commands.length; i++){
 *             int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
 *             Arrays.sort(temp);
 *             answer[i] = temp[commands[i][2]-1];
 *         }
 *
 *         return answer;
 *     }
 * }
 */