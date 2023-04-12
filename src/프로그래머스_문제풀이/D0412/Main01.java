package 프로그래머스_문제풀이.D0412;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


//[구명보트]
//무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다.
// 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
//
//예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고
// 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만
// 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로
// 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
//
//구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
//
//사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때,
// 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록
// solution 함수를 작성해주세요.
//
//제한사항
//무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
//각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
//구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
//구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로
// 사람들을 구출할 수 없는 경우는 없습니다.

//입출력 예
//people	limit	return
//[70, 50, 80, 50]	100	3
//[70, 80, 50]	100	3
public class Main01 {
    public static void main(String[] args) {
        Main01 s = new Main01();
//        System.out.println(s.solution(new int[]{70, 50, 80, 50},100));
        System.out.println(s.solution(new int[]{70, 80, 50},100));
    }

// 맨 처음 문제를 본 순간
// 우선순위 큐를 써서 풀려고 했지만, 정렬 후 인덱스를 옮기면서 해결하는게 깔끔한것 같다.
// (left <= right)이면 종료.

// 가장 무거운 사람 + 가장 가벼운 사람을 같이 구명보트에 태우는 방법을 쓰자.
// 1.몸무게를 오름차순으로 정렬
// 2. 가장 무거운 사람과 가장 가벼운 사람의 몸무게를 더했을 때 limit보다 작다면 구명보트 하나 추가
//   -  left++, right-- 를 해서 인덱스를 옮긴다.
// 3. 가장 무거운 사람과 가장 가벼운 사람의 몸무게를 더했을 때 limit보다 크면 구명보트하나 추가
// - 가장 무거운 사람만 구명보트에 타기 때문에 right--만 해준다.


    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length-1;

        Arrays.sort(people); //오름차순

        while(left<=right) { // left <= right이면 모든 인덱스를 찍어봤으니 return
            
            if(people[left] + people[right] <= limit){ //가벼운 사람 + 무거운 사람 가능
                right--;
                left++;
                answer++;
            } else {
                // 둘이 탈 수 없으면 무거운사람 index --
                right--;
                answer++;

            }
        }
        return answer;
    }
}
