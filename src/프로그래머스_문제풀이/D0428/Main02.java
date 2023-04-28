package 프로그래머스_문제풀이.D0428;


//문제 설명
//n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
//예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3

//사용할 수 있는 숫자가 담긴 배열 numbers,
//타겟 넘버 target이 매개변수로 주어질 때
//숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를
//return 하도록 solution 함수를 작성해주세요.

public class Main02 {

    int[] numbers;
    int target;
    int answer;
    public static void main(String[] args) {
        Main02 s = new Main02();
        System.out.println(s.solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        this.numbers = numbers;
        this.target = target;
        dfs(0,0);

        return answer;
    }

    private void dfs(int index, int sum) {
        //1. 탈출 조건
        if(index == numbers.length){
            if(sum == target) {
                answer++;
            }
            return;
        }
        //2. 수행동작
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}
