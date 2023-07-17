package DataStructure;
import java.io.*;
import java.util.*;
public class PrefixSum {    //11659번 구간 합 구하기
    /*
    Input line1 : 한줄 데이터의 개수 n, 합의 횟수  m
    line2 : 데이터 배열
    line 3~m : i번째수, j번째수

    Output Line1~m : i번째수 ~ j번째 수의 합

    1. 구간합배열 만들기
    2. 횟수만큼 input에 맞게 구간합 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String Line1 = br.readLine();   //배열의 데이터 수 n, 합구하는 횟수 m
        String Line2 = br.readLine();   //배열 데이터 입력
        st = new StringTokenizer(Line1);
        String nSt = st.nextToken();
        String mSt = st.nextToken();
        int n = Integer.parseInt(nSt);
        int m = Integer.parseInt(mSt);

        StringTokenizer st2 = new StringTokenizer(Line2);
        String[] Line2ArrStr = new String[n];
        int[] Line2ArrInt = new int[n]; //String입력값 -> split해서 StringArr에 저장 -> IntegerArr에 parseInt해서 저장
        for (int i = 0; i < n; i++) {
            Line2ArrStr[i] = st2.nextToken();
        }
        for (int i = 0; i < n; i++) {
            Line2ArrInt[i] = Integer.parseInt(Line2ArrStr[i]);
        }
        int[] dataArr = Line2ArrInt;

        StringTokenizer st3;
        int[][] ijArr = new int[m][2];
        for (int i = 0; i < m; i++) {   //String 한줄받기 -> StringTokenizer -> parsInt -> ijArr 입력
            String tmp = br.readLine();
            int x, y;
            st3 = new StringTokenizer(tmp);
            x = Integer.parseInt(st3.nextToken());
            y = Integer.parseInt(st3.nextToken());
            ijArr[i][0] = x;
            ijArr[i][1] = y;
        }
        //입력 끝
        //구간합 배열 생성
        int[] sumArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sumArr[i] = dataArr[i];
            } else {
                sumArr[i] = sumArr[i - 1] + dataArr[i];
            }
            //첫번째~m번째 반복해서 i, j 입력
        }
        //m번 반복해서 구간합 구하기
        int[] OutputData = new int[m];
        for (int i = 0; i < m; i++) {
            int x, y;
            x = ijArr[i][0];
            y = ijArr[i][1];

            if (x - 2 < 0) {
                OutputData[i] = sumArr[y - 1] - 0;
            } else {
                OutputData[i] = sumArr[y - 1] - sumArr[x - 2];
            }
        }
        //출력
        for (int i = 0; i < m; i++) {
            System.out.println(OutputData[i]);
        }
    }
}
/*
구간 합 핵심이론
1. 합배열 생성
ex) 기존 배열 1 2 3 4 5
합배열 1 3 6 10 15
2. 합배열 공식
합배열[i] = 합배열[i-1] + 기존배열[i]
3. 구간합 공식
합배열[j] - 합배열[i-1]
 */
/*
역시 막히면 메모리 allocation 상황 그리면서 풀기
 */
