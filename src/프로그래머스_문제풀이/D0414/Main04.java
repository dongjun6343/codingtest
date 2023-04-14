package 프로그래머스_문제풀이.D0414;


//문제 설명
//선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
//
//예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때,
// 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고,
// 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
//
//위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다.
// 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만,
// 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
//
//선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때,
// 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
//
//제한 조건
//스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
//스킬 순서와 스킬트리는 문자열로 표기합니다.
//예를 들어, C → B → D 라면 "CBD"로 표기합니다
//선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
//skill_trees는 길이 1 이상 20 이하인 배열입니다.
//skill_trees의 원소는 스킬을 나타내는 문자열입니다.
//skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
//입출력 예
//skill	skill_trees	return
//"CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
//입출력 예 설명
//"BACDE": B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
//"CBADF": 가능한 스킬트리입니다.
//"AECB": 가능한 스킬트리입니다.
//"BDA": B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.

import java.util.LinkedList;
import java.util.Queue;

public class Main04 {

    public static void main(String[] args) {
        Main04 s = new Main04();
        System.out.println(s.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
    
    // 큐로 풀어보자
    // AECB -> CB이므로 알맞은 스킬트리.
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        Queue<Character> q = new LinkedList<>();
        int queueCount = 0;
        int chkCount = 0;

        for(String skill_tree : skill_trees){

            // 큐 값 세팅.
            for(char s : skill.toCharArray()){
                q.offer(s); // CBD
                String chk = String.valueOf(s);
                if(skill_tree.contains(chk)){
                    //스킬트리에 해당 스킬이 개수 체크
                    chkCount++;
                }

            }
            // BACDE
            for(char a : skill_tree.toCharArray()){
                //B
                if(!q.isEmpty() && q.peek() == a){
                    q.poll();
                    queueCount++;
                }
            }

            if(queueCount == chkCount){
                //큐에 값이 없고, 개수가 같으면
                answer++;
            }

            // 큐값 초기화
            q.clear();
            // chkCount&queueCount 초기화
            chkCount = 0;
            queueCount = 0;

        }

        return answer;
    }

}
