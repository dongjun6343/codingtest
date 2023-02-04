package Programmers.유형.큐_스택;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * [기능개발]
 * 문제 설명
 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다.
 * 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 *
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
 * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 *
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가
 * 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 *
 * 제한 사항
 * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
 * 작업 진도는 100 미만의 자연수입니다.
 * 작업 속도는 100 이하의 자연수입니다.
 * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 * 입출력 예
 * progresses	speeds    	return
 * [93, 30, 55]	[1, 30, 5]	[2, 1]
 * [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 * 입출력 예 설명
 * 입출력 예 #1
 * 첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
 * 두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다.
 * 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
 * 세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
 *
 * 따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
 *
 * 입출력 예 #2
 * 모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일, 1일입니다.
 * 어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.
 *
 * 따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.
 */
class Solution_큐_스택_01 {
    public static void main(String[] args) {
        Solution_큐_스택_01 s = new Solution_큐_스택_01();
        System.out.println(s.solution(new int[]{93, 30, 55},  new int[]{1, 30, 5}));
    }
    // FIFO : 큐. -> LinkedList();
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        // 큐생성 후 값넣기
        // 큐 맨앞에 있는 값 꺼낸 후 스피드의 값만큼 더해서 100이 넘어가는 count 세기.
        // 그 다음 큐에서 꺼내기.
        // 해당 카운트 만큼의 수만큼을 스피드만큼 더한 후 100 이 넘어가는지 확인
        // 100이 넘어간다면 다음 큐 꺼내기
        // 그 다음 큐가 100이 넘어가는지 확인.
        // 넘어가지 않는다면 amswer에 꺼낸 큐 값들 추가
        // 해당 카운트만큼 더한 스피드만큼에서 얼마나 더 추가해야 100까지 가는지 확인.
        // queue에 각 기능의 남은 일수 저장
        for(int i = 0; i < progresses.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0) {
                queue.offer((100 - progresses[i]) / speeds[i]);
            } else {
                queue.offer((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        System.out.println(queue);
        int count = 1;
        int temp = -1;
        while(!queue.isEmpty()){
            if(temp < 0) {
                temp = queue.poll();
            }

            if(temp >= queue.peek()) {
                count++;
                queue.poll();
                if(queue.isEmpty()) {
                    list.add(count);
                    break;
                }
            } else {
                list.add(count);
                count = 1;
                temp = queue.poll();
                if(queue.isEmpty()) {
                    list.add(count);
                    break;
                }
            }
        }

        // 반환값은 int[] 배열로 반환해야 하지만,
        // 길이를 특정할 수 없으므로, List로  add해주면서 동적으로 추가
        // 마지막에 List객체를 반환 하고자하는 Array 객체로 변환시켜주는 작업필요.
        int[] answer = new int[list.size()];

        // 결과 반환할 자료형으로 변환 (list -> array)
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }


        return answer;
    }
}
