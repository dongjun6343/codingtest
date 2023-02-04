package Programmers.유형.완전탐색;


import java.util.HashSet;
import java.util.Iterator;

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

        // 2. 소수의 개수만 count
        Iterator<Integer> iter = numberSet.iterator();
        while(iter.hasNext()){
            int num = iter.next();
            // 소수 찾기
            if(isPrime(num)){
                answer++;
            }
        }

        return answer;
    }

    /**
     * 에라토스테네스의 체란 2-MaxNum까지 전부 배수인지 확인할 필요가 없다는 것을 증명한 수학적인 이론이다.
     * 예를 들어 97이라는 숫자가 소수인지 아닌지를 확인하고 싶다면, 97이 2~96 전부의 배수인지 확인할 필요가 없고,
     * 2~sqrt(96)의 배수인지만 확인하면 된다는 이론이다.
     *
     * 그렇기 때문에 isPrime 함수에서 전부를 보지 않고, sqrt한 값까지만 확인하고 비교한다.
     * sqrt(제곱근) : 25 -> 5.0
     *
     */
    private boolean isPrime(int num) {
        // 0, 1 제외
        // num => 7, 17, 71
        if(num == 0 || num == 1){
            return false;
        }
        // 에라토스테네스의 체의 limit 숫자 계산.
        int limit = (int)Math.sqrt(num);

        // limit까지 배수 여부 확인.
        for(int i = 2; i <= limit; i++ ){
            // 0이면 소수가 아니다.
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }


    private void numberMake(String s, String numbers) {

        // 1. 1, 7 은 그대로 set에 추가.
        // set : 순서가 없고, 중복을 허용하지 않는다.
        if(!s.equals("")){
            numberSet.add(Integer.valueOf(s));
        }

        // 남은 숫자로 새로운 조합을 만듬.
        for(int i = 0; i < numbers.length(); i++){
            numberMake(s + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i + 1));
        }
    }
}