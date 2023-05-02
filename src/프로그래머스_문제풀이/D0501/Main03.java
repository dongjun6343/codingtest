package 프로그래머스_문제풀이.D0501;

public class Main03 {

    public static void main(String[] args) {
        Main03 s = new Main03();
        System.out.println(s.solution("110010101001"));
    }
    public int[] solution(String s) {

        int[] answer = new int[2];
        int count = 0;
        int zeroCount = 0;

        while(!s.equals("1")){

            count++;

            String replace = s.replace("0", ""); // 0 없애기.

            // 0 숫자세기
            zeroCount += s.length() - replace.length();

            s = Integer.toBinaryString(replace.length()); // 6 => 2진수로 변경
        }

        answer[0] = count;
        answer[1] = zeroCount;

        return answer;
    }
}

//십진수 >>>  이진수 변환
//Integer의 치환함수를 사용한다.
//
//Integer.toBinaryString(num); //2진수
//Integer.toOctalString(num);  //8진수
//Integer.toHexString(num);  //16진수

//이진수 >>>  십진수 변환
//parseInt를 사용하면 쉽게 변환이 가능하다.
//
//int binaryToDecimal = Integer.parseInt(binaryString, 2);
//int binaryToOctal = Integer.parseInt(octalString, 8);
//int binaryToHex = Integer.parseInt(hexString, 16);
//
//System.out.println(binaryToDecimal); //127
//System.out.println(binaryToOctal);   //127
//System.out.println(binaryToHex);     //127