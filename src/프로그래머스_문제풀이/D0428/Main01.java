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
        // right를 옮길때는 배열의 길이를 항상 생각하자
        int left = 0;
        int right = 0;
        int sum = 0;
        int size = Integer.MAX_VALUE;
        int[] answer = new int[2];
        // 종료조건 right가 배열의 길이보다 길거나 left가 right보다 클때!
        while(right < sequence.length && left <= right){

            // 1. left == right : 첫번째 접근이거나 같을때
            if(left == right){
                sum = sequence[left]; // 1번째 -> sum : 1
            }
            // 2. 누적합이 k랑 같을때
            if(sum == k ){
                // 2-1. 현재 포인터 간 길이가 이전 포인트보다 짧을때
                if (size > right - left + 1) {
                    size = right - left + 1;
                    answer[0] = left;
                    answer[1] = right;
                }
                // 모든 원소는 양수이기 때문에 다음 경우의 수를 찾기 위해 lt를 증가 시킬 것이며,
                // 누적합 계산을 위해 현재 sequence[lt] 값을 빼준다.
                sum -= sequence[left];

                // 2-2. rt도 마찬가지로 증가시킬 것이기 때문에
                // 현재 누적합에 sequence[rt + 1]을 더해준다.
                if (right + 1 < sequence.length) {
                    sum += sequence[right + 1];
                }
                // 2-3. 두 포인터가 같은 경우 가장 짧은 길이이기 때문에 순회를 종료
                if (left == right) {
                    break;
                }
                // 각 포인터 증가
                left++;
                right++;

                // 3. 누적합이 k보다 클때
            } else if (sum > k) {
                // lt를 증가해가며 k와 같은 지를 비교
                sum -= sequence[left]; //left의 값을 누적합에서 제거한뒤 left한칸 옮김.
                left++;

                // 4. 누적합이 k보다 작을때
            } else if (sum < k) {
                // 누적합이 k 보다 작은 경우 rt를 증가해가며 k와 같은 지를 비교
                if (right + 1 < sequence.length) {
                    sum += sequence[right + 1];
                }


                right++;
            }
        }
        return answer;
    }
}
