package 프로그래머스_문제풀이.D0511;


import java.util.*;
public class Main02 {

    public String solution(int[] numbers) {

        String[] chk = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            chk[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(chk, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if(chk[0].equals("0")){
            return "0";
        }

        StringBuilder answer = new StringBuilder();

        for(String s : chk){
            answer.append(s);
        }


        return answer.toString();
    }
}
