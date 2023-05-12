package 프로그래머스_문제풀이.D0512;


import java.util.HashSet;

// 소수찾기
// dfs로 모든 조합찾고
// hashset에 중복된 값은 제거해서 값을 넣고
// 에라토스테네스의 체로 소수를 구한다.
public class Main01 {

    HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Main01 m = new Main01();
        System.out.println(m.solution("17")); //return 2
    }

    public int solution(String numbers) {
        int answer = 0;

        // 1. 모든 숫자를 만든다.
        cur("", numbers); // 조합한숫자 , 남아있는 숫자
        System.out.println(set);
        // 2. 소수의 개수만 센다.
        for(Integer chk : set){
            if(isChk(chk)){
                answer++;
            }
        }
        // 3. 해당 소수의 개수를 반환한다.

        return answer;
    }

    public void cur(String comb , String others){
        // 1 . 현재 조합을 set에 추가한다. - 중복은 누락됨.
        if(!comb.equals("")){ // 첫번쨰엔 comb가 빈값임.
            set.add(Integer.valueOf(comb));
        }
        // 2.  남은 숫자 중 한개를 더해 새로운 조합
        for(int i = 0; i < others.length(); i++){

            cur(comb + others.charAt(i), others.substring(0,i) + others.substring(i + 1)); // 1 , 7 , 71
        }

    }

    //에라토스테네스의 체로 소수 판별
    private boolean isChk(int num) {
        if(num == 0 || num == 1 ) return false;

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }


}
