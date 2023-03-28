package 프로그래머스_문제풀이.D0328;


//1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
//2. words에 있는 단어로만 변환할 수 있습니다.

//예를 들어 begin이 "hit", target가 "cog",
//words가 ["hot","dot","dog","lot","log","cog"]라면
//        "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
//
//두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때,
//        최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

//begin	target	                words                   	return
//"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	   4
//"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	           0
public class Main01 {

    static boolean[] visited;
    static int answer;
    public static void main(String[] args) {
        Main01 s = new Main01();
        System.out.println(s.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    public int solution(String begin, String target, String[] words) {
        answer = 0;
        // 1. 방문했는지 확인.
        visited = new boolean[words.length];
        int count = 0;
        // 2. 깊이우선탐색 : 재귀
        dfs(begin, target, words, count);
        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int count) {
        // 시작단어와 타켓단어가 같으면
        if(begin.equals(target)){
            answer = count;
            return;
        }

        // words 반복
        for(int i = 0 ; i < words.length; i++){
            // 방문여부
            if(visited[i]){
                //방문했으니 X
                continue;
            }
            int k = 0;
            // 시작단어 하나씩
            for(int j = 0; j < begin.length(); j++){

                if(begin.charAt(j) == words[i].charAt(j)){
                    // 글자 동일 여부 카운트.
                    k++;
                }
            }
            if(k == begin.length() - 1){ // 한글자만 다르다 -> 방문한다.
                visited[i] = true;
                dfs(words[i] , target, words , count+1);
                visited[i] = false; // 다시 탐색을 위해서 방문횟수 초기화
            }
        }
    }
}
