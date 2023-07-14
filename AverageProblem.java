package DataStructure;
import java.io.*;
import java.util.*;

public class AverageProblem { //1546번 평균구하기
    public static void main(String[] args) throws IOException{
        /*
        1. 최댓값 m 구하기
        2. 모든 점수를 점수/m*100으로 고치기
        3. 새로운 평균 출력
        (a/m*100) + (b/m*100) + ... = sum
        sum/n = avg
        // n <= 1000
        // 0 <= instances <= 100
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String scores = br.readLine();
        String[] scoresSt = scores.split(" ");
        int[] scoresInt = new int[n];
        double max = 0.0;
        for (int i = 0; i < n; i++) {
            scoresInt[i] = Integer.parseInt(scoresSt[i]);
            if (scoresInt[i] > max) {
                max = scoresInt[i];
            }
        }

        double[] fixedScores = new double[n];
        for (int i = 0; i < n; i++) {
            fixedScores[i] = scoresInt[i]/max*100;
        }
        double avg = 0.0;
        for (int i = 0; i < n; i++) {
            avg += fixedScores[i];
        }
        avg /= n;
        System.out.println(avg);
    }
}
/*
intger로 나누면 truncate되므로 주의
 */
