package 프로그래머스_문제풀이.D0504;


import java.util.*;

public class Main04 {

    public static void main(String[] args) {
        Main04 m = new Main04();
        System.out.println(m.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}
        , "right"));
    }

    class Pos{
        int row;
        int col;
        Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    Pos left;
    Pos right;
    Pos numPos;
    public String solution(int[] numbers, String hand) {
        String answer = "";
        //1. 왼손 오른손 위치 초기화.
        left = new Pos(3,0);
        right = new Pos(3,2);

        for ( int num : numbers){
            //2. 숫자를 누를 손가락 정하기
            numPos = new Pos((num -1) / 3 , (num -1) % 3); // 12345678

            if(num == 0){
                //0일때는 직접 설정이 필요함.
                numPos = new Pos(3,1);
            }

        }


        return answer;
    }
}
