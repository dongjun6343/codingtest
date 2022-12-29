package Programmers.level2;


/**
 * [타겟넘버]
 * 문제 설명
 * n개의 음이 아닌 정수들이 있습니다.
 * 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 사용할 수 있는 숫자가 담긴 배열 numbers,
 * 타겟 넘버 target이 매개변수로 주어질 때
 * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
 * 각 숫자는 1 이상 50 이하인 자연수입니다.
 * 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
 *
 * 입출력 예
 * numbers	        target	return
 * [1, 1, 1, 1, 1]	 3	      5
 * [4, 1, 2, 1]	     4	      2
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * 문제 예시와 같습니다.
 *
 * 입출력 예 #2
 * +4+1-2+1 = 4
 * +4-1+2-1 = 4
 * 총 2가지 방법이 있으므로, 2를 return 합니다.
 */
class Solution51_DFS_BFS {
    //멤버변수
    int[] numbers;
    int answer;
    int target;
    // 깊이/너비 우선 탐색(DFS/BFS)
    // DFS : 재귀, 스택
    // BFS : 큐
    public static void main(String[] args) {
        Solution51_DFS_BFS s = new Solution51_DFS_BFS();
        System.out.println(s.solution(new int[]{1, 1, 1, 1, 1} , 3));
    }

    /**
     * 재귀함수를 구현할때
     * 1. 수행동작을 먼저 구현한다.
     * 2. 탈출조건을 구현한다
     * 3. 재귀함수를 자세하게 그려보기
     */

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;

        dfs(0,0);

        return answer;
    }

    void dfs(int index, int sum){
        // 탈출조건
        // index의 값과 numbers의 길이값이 같으면 탈출(더 이상 값이 없으므로)
        // 마지막 노드까지 탐색했을 때 타겟 넘버와 결과값이 같으면 정답 카운트 증가
        if(index == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }

        // 수행동작
        // 누적합+현재 인덱스 값 => sum
        dfs(index+1, sum + numbers[index]);
        dfs(index+1, sum - numbers[index]);
    }
}

