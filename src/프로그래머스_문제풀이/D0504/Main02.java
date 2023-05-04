package 프로그래머스_문제풀이.D0504;


import java.util.ArrayList;
import java.util.Comparator;


public class Main02 {
    public static void main(String[] args) {
        Main02 m = new Main02();
        System.out.println(m.solution(new String[]{"abce", "abcd", "cdx"} , 2));
    }
    public String[] solution(String[] strings, int n) {
        ArrayList<String> answer = new ArrayList<>();

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> chkList = new ArrayList<>();

        for( String chk : strings) {
            list.add(chk);
        }

        // ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬
        for( int i = 0; i < list.size(); i++){
            String substring = "";
            substring = list.get(i).substring(n,n+1);

            if(!chkList.contains(substring)){
                chkList.add(substring); // 중복제거
            }
        }

        list.sort(Comparator.naturalOrder());
        chkList.sort(Comparator.naturalOrder());

        for(int i = 0; i < chkList.size(); i++){
            for (int j = 0; j < list.size(); j++){
                if(list.get(j).substring(n,n+1).equals(chkList.get(i))){
                    answer.add(list.get(j));
                }
            }
        }

        return answer.toArray(new String[answer.size()]);
    }
}
