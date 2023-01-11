package Programmers.완전탐색;


import java.util.ArrayList;

/**
 * [모의고사]
 * 문제 설명
 * 수포자는 수학을 포기한 사람의 준말입니다.
 * 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
 * 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * 입출력 예
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다
 */

class Solution_완전탐색_01 {
    public static void main(String[] args) {
        Solution_완전탐색_01 s = new Solution_완전탐색_01();
        System.out.println(s.solution(new int[]{1, 2, 3, 4, 5 , 1, 2, 3, 4, 5 , 1, 2, 3, 4, 5, 6}));
    }

    public int[] solution(int[] answers) {

        // 수포자 1 : 1,2,3,4,5,1,2,3,4,5
        // 수포자 2 : 2,1,2,3,2,4,2,5,2,1
        // 수포자 3 : 3,3,2,2,1,1,4,4,5,5
        // 초기값 세팅
        int[] a = new int[]{1,2,3,4,5,1,2,3,4,5};
        int[] b = new int[]{2,1,2,3,2,4,2,5,2,1};
        int[] c = new int[]{3,3,2,2,1,1,4,4,5,5};

        int countA = 0;
        int countB = 0;
        int countC = 0;

        int j = 0;
        for(int i = 0; i < answers.length; i++){
            // 0~9 -> 9가 되면 다시 0
            if(j == 10){
                j = 0;
            }
            if(answers[i] == a[j]){
                countA++;
            }
            if(answers[i] == b[j]){
                countB++;
            }
            if(answers[i] == c[j]){
                countC++;
            }
            j++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        // count 비교
        if(countA == countB && countA == countC && countB == countC){
            list.add(1);
            list.add(2);
            list.add(3);
        } else {
            // 1 => A가 가장 클때
            // 2 => B가 가장 클때
            // 3 => C가 가장 클때
            // 1,2 => 1,2 가 같고 C보다 클때
            // 1,3
            // 2,3
            // 1,2,3 => 모두 다 같은 값일때.
            if(countA > countB && countA > countC) {
                list.add(1);
            } else if(countA < countB && countB > countC) {
                list.add(2);
            } else if(countB < countC && countA < countC) {
                list.add(3);
            } else if(countA == countB && countA > countC && countB > countC) {
                list.add(1);
                list.add(2);
            } else if (countA == countC && countB < countC && countA > countB) {
                list.add(1);
                list.add(3);
            } else if (countB == countC && countA < countB && countC > countA){
                list.add(2);
                list.add(3);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
            System.out.println(list.get(i));
        }

        return answer;
    }
}
