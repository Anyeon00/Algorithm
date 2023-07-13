package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.io.*;
import java.util.*;
public class SumNumber{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int n = Integer.parseInt(br.readLine());
        String data = br.readLine();

        String[] splitData = data.split("");

        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(splitData[i]);
        }

        System.out.println(sum);
    }
}
/*
parse 형변환은 argument가 String인 경우에 사용하므로
Integer.parseInt(data.charAt(i)); 는 에러

split()도 String을 대상으로 사용, String Array에 저장
* */