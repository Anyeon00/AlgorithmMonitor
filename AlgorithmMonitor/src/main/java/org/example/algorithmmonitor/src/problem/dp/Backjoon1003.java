package org.example.algorithmmonitor.src.problem.dp;

import org.example.algorithmmonitor.src.application.domain.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon1003 extends DP {

    public Backjoon1003() {
        //ProblemBox에 등록
        //1. 문제 이름 설정 ex) name = "피보나치 함수"
        //2. 문제풀이 후, 결과 설정 ex) result = SUCCESS or result = FAIL
        name = "피보나치 함수";
        result = SUCCESS;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        //dp테이블 생성
        int[][] dp = new int[41][2];
        //점화식
        //n = n-1 + n-2
        //dp[n][0] = dp[n-1][0] + dp[n-2][0]
        //dp[n][1] = dp[n-1][1] + dp[n-2][1]
        //초기값 세팅
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
