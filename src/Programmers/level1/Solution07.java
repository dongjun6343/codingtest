package Programmers.level1;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 문자열 내 p와 y의 개수
 * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True,
 * 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.
 * 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
 *
 * 예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
 *
 *    s	       answer
 * "pPoooyY"	true
 * "Pyy"    	false
 */
class Solution07 {
    public static void main(String[] args) {
        Solution07 s = new Solution07();
        System.out.println(s.solution("Pyy"));
    }
    boolean solution(String s) {
        // s값을 짤라서 배열로 값 넣고 p , y가 있으면  +1 시킨 후 p와 y값이 같으면 true한다?
        String a[] = new String[s.length()];
        int chkP = 0;
        int chkY = 0;
        for(int i = 0; i < s.length(); i ++){
            a[i] = s.substring(i,i+1);
            if("p".equals(a[i])){
                chkP++;
            } else if("y".equals(a[i])){
                chkY++;
            }
        }
        boolean answer = true;
        if(chkP != chkY){
            answer = false;
        }
        return answer;
    }
}
