package Programmers.level2;


import java.util.Arrays;

/**
 * 문제 설명
 * 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
 * str에 나타나는 숫자 중 최소값과 최대값을 찾아
 * 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
 * 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
 *
 * 제한 조건
 * s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 *
 * 입출력 예
 *     s	         return
 * "1 2 3 4"	      "1 4"
 * "-1 -2 -3 -4"	 "-4 -1"
 * "-1 -1"	         "-1 -1"
 */
class Solution26 {

    public static void main(String[] args) {
        Solution26 s = new Solution26();
        System.out.println(s.solution("-1 -2 -3 -4"));
    }

    public String solution(String s) {
        String answer = "";

        // 1. 공백으로 값을 잘라서 배열에 넣는다.
        String[] arr = s.split(" ");
        int[] valueInt = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            valueInt[i] = Integer.parseInt(arr[i]);
        }
        // "1","2" -> 1,2
        // 2. 해당 배열을 오름차순으로 정렬한다.
        // 3. 첫번째 값과 마지막값을 뽑는다.

        Arrays.sort(valueInt);
        String start = String.valueOf(valueInt[0]);
        String end = String.valueOf(valueInt[valueInt.length-1]);

        answer = start + " " + end;

        return answer;
    }
}