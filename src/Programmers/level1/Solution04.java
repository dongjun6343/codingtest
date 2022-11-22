package Programmers.level1;

/**
 * 자릿수 더하기
 *
 * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
 * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 *
 * N	answer
 * 123	6
 * 987	24
 */
class Solution04 {
    public static void main(String[] args) {
        Solution04 s = new Solution04();
        System.out.println(s.solution(987));
    }
    public int solution(int n) {
        String strN = String.valueOf(n);
//        substring(0,1) : 1
//        substring(1,2) : 2
//        substring(2,3) : 3
        int answer = 0;
        for(int i  = 0; i < strN.length(); i++){
            answer += Integer.parseInt(strN.substring(i,i+1));
        }
        return answer;
    }

//    String[] array = String.valueOf(n).split("");
//        for(String s : array){
//        answer += Integer.parseInt(s);
//    }

}
