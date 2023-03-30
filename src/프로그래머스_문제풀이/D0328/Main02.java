package 프로그래머스_문제풀이.D0328;

import java.util.LinkedList;
import java.util.Queue;

// 스킬트리
// 선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
// 예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고,
// 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
// 위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다.
// 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만,
// 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
// 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때,
// 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

//skill	             skill_trees	        return
//"CBD"	["BACDE", "CBADF", "AECB", "BDA"]	   2


//"CBDK" ["CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"] 4
public class Main02 {
    public static void main(String[] args) {
        Main02 s = new Main02();
        System.out.println(s.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
//        System.out.println(s.solution("CBDK", new String[]{"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"}));
    }
        public int solution(String skill, String[] skill_trees) {
        Queue<Character> queue = new LinkedList<>();

        int answer = 0;

        for(int i=0; i<skill_trees.length; i++){
            queue.clear();
            // 큐에 값 다시 세팅. C B D
            for(char ch: skill.toCharArray()) {
                queue.offer(ch);
            }
            // B A C D E
            for(int j = 0; j < skill_trees[i].length(); j++){

                // 큐가 비어있다 => 모든 스킬트리 잘찍었다.
                if(queue.isEmpty()){
                    answer++;
                    break;
                }
                // 큐에 스킬트리값이 포함되어있으면,
                if(queue.contains(skill_trees[i].charAt(j))){
                    // 큐 순서와 스킬트리 값의 순서가 같지 않을때.
                    // 해당 스킬트리는 잘못된것이다. => break;
                    if(queue.poll() != skill_trees[i].charAt(j)){
                        break;
                    }
                }

                // 스킬트리의 길이만큼 for문을 이상없이 잘 돈다면, 제대로 찍은 스킬트리다.
                if(j == skill_trees[i].length()-1){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
