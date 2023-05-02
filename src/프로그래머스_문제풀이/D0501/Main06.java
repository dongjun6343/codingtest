package 프로그래머스_문제풀이.D0501;


public class Main06 {
    public static void main(String[] args) {
        Main06 s = new Main06();
        System.out.println(s.solution("1234"));
    }

    public boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        String[] chk = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
                "n","o","p","q","r","s","t","u","v","w","x","y","z"};

        if(s.length() == 4 || s.length() == 6 ) {
            for(int i = 0; i < chk.length; i++){
                if(s.contains(chk[i])){
                    // 영문자가 있으면 false
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }

        return answer;
    }
}
