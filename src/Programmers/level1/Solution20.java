package Programmers.level1;


import java.util.Arrays;

/**
 * 문제 설명
 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
 * 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
 *
 * 재한사항
 * s는 길이가 1 이상, 100이하인 스트링입니다.
 * 입출력 예
 * s	return
 * "abcde"	"c"
 * "qwer"	"we"
 *
 */
class Solution20 {

    public static void main(String[] args) {
        Solution20 s = new Solution20();
        System.out.println(s.solution("qwer"));
    }

    public String solution(String s) {
        String answer = "";

        String[] arr = new String[s.length()];
        for(int i = 0; i < s.length(); i++){
            arr[i] = s.substring(i,i+1);
        }
        String chk[];
        if(s.length()%2 == 0){
            int i = s.length()/2;
            String s1 = arr[i-1];
            String s2 = arr[i];
            answer = s1+s2;
        } else {
            int i = s.length()/2;
            String s1 = arr[i];
            answer = s1;
        }
        return answer;
    }
}


/**
 *  return word.substring((word.length()-1) / 2, word.length()/2 + 1);
 */