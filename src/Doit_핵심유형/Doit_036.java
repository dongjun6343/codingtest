package Doit_핵심유형;

import java.util.Scanner;

/**
 * 1541번
 * 최솟값을 만드는 괄호 배치 찾기.
 *
 */
public class Doit_036 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] str = input.split("-");
        for(int i = 0; i< str.length; i++){
            int temp = mySum(str[i]);
            if(i == 0){
                answer = answer + temp;
            } else {
                answer = answer - temp;
            }
        }
        System.out.println(answer);
    }

    private static int mySum(String s) {
        int sum = 0;
        String temp[] = s.split("\\+");

        for(int i = 0; i < temp.length; i++ ){
            sum += Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
