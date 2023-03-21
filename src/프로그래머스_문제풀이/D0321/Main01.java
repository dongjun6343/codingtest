package 프로그래머스_문제풀이.D0321;

import java.util.Arrays;
import java.util.Stack;

//뒤에 있는 큰 수 찾기
//문제 설명
//정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다
// 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
//정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요.
// 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.
//
//제한사항
//4 ≤ numbers의 길이 ≤ 1,000,000
//1 ≤ numbers[i] ≤ 1,000,000
//입출력 예
//numbers	        result
//[2, 3, 3, 5]	[3, 5, 5, -1]
//[9, 1, 5, 3, 6, 2]	[-1, 5, 6, 6, -1, -1]
//입출력 예 설명
//입출력 예 #1
//2의 뒷 큰수는 3입니다. 첫 번째 3의 뒷 큰수는 5입니다. 두 번째 3 또한 마찬가지입니다.
// 뒷 큰수가 없으므로 -1입니다. 위 수들을 차례대로 배열에 담으면 [3, 5, 5, -1]이 됩니다.
//
//입출력 예 #2
//9는 뒷 큰수가 없으므로 -1입니다. 1의 뒷 큰수는 5이며, 5와 3의 뒷 큰수는 6입니다.
// 6과 2는 뒷 큰수가 없으므로 -1입니다. 위 수들을 차례대로 배열에 담으면 [-1, 5, 6, 6, -1, -1]이 됩니다.
public class Main01 {

    public static void main(String[] args) {
        Main01 s = new Main01();
        System.out.println(s.solution(new int[] {9, 1, 5, 3, 6, 2}));
    }

    // 숫자가 오르막일때와 숫자가 내리막일 경우 다르다.
    // stack 사용.
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> s = new Stack<>(); // 스택의 값을 인덱스로 생각한다.
        s.push(0);
        for(int i = 1; i < numbers.length; i++){
            while(!s.isEmpty()){
                int idx = s.pop();
                if(numbers[i] > numbers[idx]){ // 뒤가 더 클때
                    answer[idx] = numbers[i]; // 해당 스택의 인덱스 값을 가지고, answer배열의 인덱스에 세팅된 numbers값을 넣는다.
                } else { // 앞이 더 크거나 같을 때 스택에 해당 인덱스 추가.
                    s.push(idx);
                    break;
                }
            }
            s.push(i);
        }
        return answer;
    }
}

