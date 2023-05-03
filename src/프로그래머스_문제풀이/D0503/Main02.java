package 프로그래머스_문제풀이.D0503;

import java.util.Arrays;

public class Main02 {

    public static void main(String[] args) {
        Main02 s = new Main02();
        System.out.println(s.solution(
                new int[]{1, 5, 2, 6, 3, 7, 4} ,
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
        ));
    }


//배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
//
//예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
//
//array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
//1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
//2에서 나온 배열의 3번째 숫자는 5입니다.

//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
//[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
//[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
//[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] chk;
        int num = 0;
        int ansNum = 0;
        for(int a = 0 ; a < commands.length; a++){

            int i = commands[a][0];// 2번째~
            int j = commands[a][1]; // 5번째
            int k = commands[a][2]; // 3번째숫자.

            chk = new int[j-i + 1]; // 배열 초기화.

            if(i-j == 0){
                chk[0] = array[i-1];
            } else {
                for(int b = i-1; b < j; b++){
                    chk[num] = array[b];
                    num++; //0 , 1 , 2..
                }
            }
            Arrays.sort(chk); // chk 오름차순
            answer[ansNum] = chk[k-1];
            ansNum ++;
            num = 0;// num 초기화

        }
        return answer;
    }
}
