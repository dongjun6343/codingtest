package Programmers.level1;


import java.util.Arrays;
import java.util.Collections;

/**
 * 문제 설명
 * 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수,
 * solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
 * 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
 *
 * 제한 조건
 * arr은 길이 1 이상인 배열입니다.
 * 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
 *
 * 입출력           예
 * arr	         return
 * [4,3,2,1]	[4,3,2]
 * [10]	[-1]
 *
 */
class Solution17 {
    public static void main(String[] args) {
        Solution17 s = new Solution17();
        System.out.println(s.solution(new int[]{3,2,1,4}));
    }

    public int[] solution(int[] arr) {
        // 원본배열
        int[] answer = arr.clone();
        if(arr.length == 1) {
            answer = new int[]{-1};
        } else {
            // int -> 박싱해주기 -> 다시 int형 배열로.
            arr = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
            // copyOfRange(복사하고하는배열, 시작위치, 배열크기
            int[] removeArr = Arrays.copyOfRange(arr, arr.length-1, arr.length); // 1
            int chk = removeArr[0];
            answer = Arrays.stream(answer).filter(v -> v != chk).toArray(); //필터로 해당 값 없애기.
        }
        return answer;
    }
}

// 예시가 내림차순이라서 내림차순으로 출력해주면 되는줄 알았는데 그게 아니라
// 출력받을 배열은 내림차순으로 정렬이 되면 안되는거라서....... 좀 헤맸다..


/**
 1.
      if (arr.length <= 1) return new int[]{ -1 };
      int min = Arrays.stream(arr).min().getAsInt();
      return Arrays.stream(arr).filter(i -> i != min).toArray();

 2.
      List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
      Arrays.sort(arr);
      list.remove(list.indexOf(arr[0]));
      if (list.size() <= 0) return new int[]{-1};
      return list.stream().mapToInt(i->i).toArray();
 */