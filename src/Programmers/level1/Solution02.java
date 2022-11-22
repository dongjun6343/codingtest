package Programmers.level1;

/**
 * 약수의 합
 * 12 28
 * 5   6
 */
class Solution02 {
    public static void main(String[] args) {
        Solution02 s = new Solution02();
        System.out.println(s.solution(12));
    }
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(n%i == 0){
                answer += i;
            }
        }
        return answer;
    }
}
