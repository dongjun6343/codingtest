package Programmers.level1;


/**
 * 비밀지도
 * 네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다.
 * 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다.
 * 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.
 *
 * 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
 * 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
 * 각각 "지도 1"과 "지도 2"라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
 * 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
 * "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
 * 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
 *
 * 네오가 프로도의 비상금을 손에 넣을 수 있도록,
 * 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.
 *
 * 입력 형식
 * 입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.
 *
 * 1 ≦ n ≦ 16
 * arr1, arr2는 길이 n인 정수 배열로 주어진다.
 * 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2n - 1을 만족한다.
 * 출력 형식
 * 원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라.
 *
 * 입출력 예제
 * 매개변수	       값
 * n	           5
 * arr1	    [9, 20, 28, 18, 11]
 * arr2	    [30, 1, 21, 17, 28]
 * 출력	    ["#####","# # #", "### #", "# ##", "#####"]
 * 매개변수	      값
 * n	           6
 * arr1	    [46, 33, 33 ,22, 31, 50]
 * arr2	    [27 ,56, 19, 14, 14, 10]
 * 출력	    ["######", "### #", "## ##", " #### ", " #####", "### # "]
 */
class Solution38_2018_KAKAO {

    public static void main(String[] args) {
        Solution38_2018_KAKAO s = new Solution38_2018_KAKAO();
        System.out.println(s.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}));
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // 1. 숫자를 이진수로 변환.
        // 2. 1 => "#" , 0 => " " 변환.
        // 3. arr1과 arr2에 #을 합쳐서 출력한다.
        String[] answer = new String[n];
        String[] input1 = new String[n];
        String[] input2 = new String[n];

        StringBuffer sb = null;

        for(int i = 0 ; i < n; i++){
            String a = Integer.toBinaryString(arr1[i]);
            String b = Integer.toBinaryString(arr2[i]);
            // length만큼 0을 채운다.
            if(a.length() != n){
                sb = new StringBuffer();
//                1 , 00001 : 총 4번을 돌면서 0을 붙인다.
                for(int k = 1; k <= n - a.length(); k++){
                    input1[i] = String.valueOf(sb.append("0"));
                }
                input1[i] = String.valueOf(sb.append(a));
            } else {
                input1[i] = a;
            }

            if(b.length() != n){
                sb = new StringBuffer();
                for(int k = 1; k <= n - b.length(); k++){
                    input2[i] = String.valueOf(sb.append("0"));
                }
                input2[i] = String.valueOf(sb.append(b));
            }else {
                input2[i] = b;
            }
        }
        for(int i = 0; i < n; i++){
            sb = new StringBuffer();
            for (int k = 0; k < n; k++){
                if("0".equals(input1[i].substring(k,k+1)) && "0".equals(input2[i].substring(k,k+1))){
                    // input1 , input2의 각각 자리수마다 잘라서
                    // 둘다 0 이면 " " 그게 아니면 #으로 추가.
                    answer[i] = String.valueOf(sb.append(" "));
                } else {
                    answer[i] = String.valueOf(sb.append("#"));
                }
            }
//            System.out.println(sb);
        }
        return answer;
    }
}


/**
 * ------------------- 재귀 --------------------------------
 * class Solution {
 *     public String makeSharp(int n, int m) {
 *         if(n == 0) {
 *             if( m > 0) {
 *                 String str = "";
 *                 for(int i = 0; i < m; i++) {
 *                     str += " ";
 *                 }
 *                 return str;
 *             }
 *             else return "";
 *         }
 *         else {
 *             return n % 2 == 0 ? makeSharp(n/2, m-1) + " " : makeSharp(n/2, m-1) + "#";
 *         }
 *     }
 *     public String[] solution(int n, int [] arr1, int [] arr2) {
 *         String [] answer = new String[n];
 *         int [] secretMap = new int[n];
 *         for(int i = 0; i < n; i++) {
 *             secretMap[i] = arr1[i] | arr2[i];
 *             answer[i] = makeSharp(secretMap[i], n);
 *         }
 *         return answer;
 *     }
 * }
 *
 * ------------------------------------------------------------------
 *
 * class Solution {
 *   public String[] solution(int n, int[] arr1, int[] arr2) {
 *         String[] result = new String[n];
 *         for (int i = 0; i < n; i++) {
 *             result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
 *         }
 *
 *         for (int i = 0; i < n; i++) {
 *             result[i] = String.format("%" + n + "s", result[i]);
 *             result[i] = result[i].replaceAll("1", "#");
 *             result[i] = result[i].replaceAll("0", " ");
 *         }
 *
 *         return result;
 *     }
 * }
 */
