package Programmers.level1;

import java.util.Arrays;

/**
 * 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
 * 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
 * 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
 * 입출력 예
 * arr	return
 * 10	 true
 * 12	 true
 * 11	 false
 * 13	 false
 */
class Solution08 {
    public static void main(String[] args) {
        Solution08 s = new Solution08();
        System.out.println(s.solution(18));
    }
    public boolean solution(int x) {
        String strN = String.valueOf(x);
        int arr[] = new int[strN.length()];
        for(int i = 0; i < strN.length(); i++){
            arr[i] = Integer.parseInt(strN.substring(i, i+1));
        }

        int sum = Arrays.stream(arr).sum();
        boolean answer;
        // 나누어 떨어지면
        if(x%sum == 0){
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}

//    String[] temp = String.valueOf(num).split("");
//
//    int sum = 0;
//    for (String s : temp) {
//            sum += Integer.parseInt(s);
//    }