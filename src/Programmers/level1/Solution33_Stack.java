package Programmers.level1;


import java.util.Stack;

/**
 * [같은 숫자는 싫어]
 *
 * 문제 설명
 * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
 * 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
 * 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.
 *
 * 예를 들면,
 * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
 * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
 * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 배열 arr의 크기 : 1,000,000 이하의 자연수
 * 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 * 입출력 예
 * arr	answer
 * [1,1,3,3,0,1,1]	[1,3,0,1]
 * [4,4,4,3,3]	[4,3]
 *
 */
class Solution33_Stack {

    public static void main(String[] args) {
        Solution33_Stack s = new Solution33_Stack();
        s.solution(new int[]{1,1,3,3,0,1,1});
    }

    public int[] solution(int []arr) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();

        // arr값만큼 반복
        for(int i : arr) {
            // 1 . 스택이 비어있을때 푸쉬함.
            if(stack.empty()){
                stack.push(i);
                // 2. 스택의 값을 peek했을 때 i랑 다르면 푸쉬함.
                // 같으면 무시.
            } else if(stack.peek() != i){
                stack.push(i);
            }
        }
        System.out.println("stack = " + stack); //  1 3 0 1
        answer = new int[stack.size()];

        // 3. stack에 있는 값을 꺼낸다.(pop) =>  1 0 3 1

        // 1 => a[3]
        // 0 => a[2]
        // 3 => a[1]
        // 1 => a[0]
        // answer 출력 시 :  1 3 0 1
        //for(3 2 1 0 ; i>=0 ; i--){}

        for(int i = answer.length -1; i >=0 ; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}