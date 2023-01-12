package Programmers.완전탐색;


import java.util.HashSet;

/**
 * [소수 찾기]
 * 문제 설명
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
 * 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
 * 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * 입출력 예
 * numbers	return
 * "17"	      3
 * "011"	  2
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 *
 * 11과 011은 같은 숫자로 취급합니다.
 *
 *
 */

class Solution_완전탐색_02 {

    HashSet<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) {
        Solution_완전탐색_02 s = new Solution_완전탐색_02();
        System.out.println(s.solution("17"));
    }

    public int solution(String numbers) {
        int answer = 0;

        // 1. 모든 조합의 수를 만든다. 1, 7 , 17, 71
        numberMake("", numbers);


        return answer;
    }


    private void numberMake(String s, String numbers) {

        // 1. 1, 7 은 그대로 set에 추가.
        // set : 순서가 없고, 중복을 허용하지 않는다.
        if(!s.equals("")){
            numberSet.add(Integer.valueOf(s));
        }
    }
}