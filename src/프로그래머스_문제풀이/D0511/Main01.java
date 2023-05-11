package 프로그래머스_문제풀이.D0511;


import java.util.*;
public class Main01 {
    private int answer = 0;
    private int total;

    public static void main(String[] args) {
        Main01 s = new Main01();
        System.out.println(s.solution(
                new int[]{120, 110, 140, 150} , 485
        ));
    }
    public int solution(int[] budgets, int M) {
        total = M;
        int sum = 0;
        int maxChk = budgets.length-1;
        Arrays.sort(budgets);  // 오름차순

        int max = budgets[maxChk]; //150

        binarySearch(budgets, 0, max);

        return answer;
    }

    private void binarySearch(int[] budgets, int min, int max) {
        int start = min;
        int end = max;

        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for (int budget : budgets) {
                if (budget > mid) {
                    sum += mid;
                } else {
                    sum += budget;
                }
            }

            if (sum < total) {
                start = mid + 1;
            } else if (sum > total){
                end = mid - 1;
            } else {
                answer = mid;
                return;
            }
        }

        answer = end;
    }

    private boolean isUnder(int[] budgets, int M) {
        long sum = 0;

        for (int budget : budgets) {
            sum += budget;
        }

        return sum <= M;
    }
}
