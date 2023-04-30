package 프로그래머스_문제풀이.D0430;


// 문제 설명
//정수 n이 매개변수로 주어집니다.
//다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
//첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
public class Main01 {

    public static void main(String[] args) {
        Main01 m = new Main01();
        m.solution(4);
    }
    public int[] solution(int n) {
        // 구현 문제.
        // 동작을 생각해보자

        // 동작1 : 아래
        // 동작2 : 오른쪽
        // 동작3 : 대각선

        int[][] chk = new int[n][n];
        int x = -1; // 맨처음 0,0에 값을 넣기 위해서.
        int y = 0;
        int num = 1;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i % 3 == 0) { // 아래
                    x++;
                }
                else if(i % 3 == 1) { // 옆
                    y++;
                }
                else if(i % 3 == 2) { // 대각선 위
                    x--;
                    y--;
                }
                chk[x][y] = num++;
            }
        }

        // 정답배열크기 : n*(n+1) / 2
        // 4 -> 10
        // 5 -> 15
        // 6 -> 21
        int[] answer = new int[n*(n+1) / 2];

        int index = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(chk[i][j] == 0) break;
                answer[index++] = chk[i][j];
            }
        }

        return answer;
    }
}