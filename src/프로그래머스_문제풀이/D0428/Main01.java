package 프로그래머스_문제풀이.D0428;


//문제 설명
//비내림차순으로 정렬된 수열이 주어질 때,
//다음 조건을 만족하는 부분 수열을 찾으려고 합니다.
//기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
//부분 수열의 합은 k입니다.
//합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
//길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
//수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때,
//위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요.
//이때 수열의 인덱스는 0부터 시작합니다.

// 1 1 1 2 3 4 5  5
// 0 1 2 3 4 5 6  <-- index.
// 1 1 1 2 , 2 3 , 5
// 길이가 짧은 수열 : 5
// 5의 인덱스는 6이므로, [6,6]
public class Main01 {
    public static void main(String[] args) {
        Main01 s = new Main01();
        System.out.println(s.solution(new int[]{1, 2, 3, 4, 5}, 7));

    }
    public int[] solution(int[] sequence, int k) {
        // 투포인트로 풀어보자
        int[] answer = new int[2];
        int sum = 0;
        int left = 0;
        int right = 0;
        int size = Integer.MAX_VALUE;

        while (true) {

            // sum > 찾고자 하는 값 : 크므로 left값 ++ 해주고 합에서 빼기
            if (sum >= k) {
                sum -= sequence[left++];
            }

            // 탈출조건
            else if (right >= sequence.length) break;

            else if (sum < k) {
                sum += sequence[right++];
            }

            // 값이 같을 경우
            if (sum == k) {
                if (right - left < size) {
                    answer[0] = left;
                    answer[1] = right-1;
                    size = right-left;
                }
            }
        }
        return answer;
    }
}
