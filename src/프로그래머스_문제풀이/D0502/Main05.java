package 프로그래머스_문제풀이.D0502;


import java.util.HashMap;

//없는 숫자 더하기
public class Main05 {
    public static void main(String[] args) {
        Main05 s = new Main05();
        System.out.println(s.solution(new int[]{1,2,3,4,6,7,8,0}));
    }
    public int solution(int[] numbers) {
        int answer = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < 10; i++){
            hm.put(i,0);
        }

        for(int key : numbers){
            hm.put(key, hm.getOrDefault(key, 0) + 1 );
        }

        for(Integer key : hm.keySet()){
            if(hm.get(key) == 0){
                answer += key;
            }
        }
        return answer;
    }
}
