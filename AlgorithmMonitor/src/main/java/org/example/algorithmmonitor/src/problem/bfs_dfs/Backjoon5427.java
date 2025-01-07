package org.example.algorithmmonitor.src.problem.bfs_dfs;

import org.example.algorithmmonitor.src.application.domain.type.BFS_DFS;
import java.util.*;
import java.io.*;

public class Backjoon5427 extends BFS_DFS {
    public Backjoon5427() {
        //1. 문제 이름 설정
        name = "불";
        //2. 문제풀이 후 결과 설정
        result = success;  // or result = fail
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //문제
        //불, 상근
        //탈출 최소시간 구하기, 불가능한 경우 IMPOSSIBLE

        //풀이
        //1. 입력받기 - char[]
        //2. 불 먼저 뿌리고, 상근 이동
        //2-1. 이동 불가능 시 IMPOSSIBLE
        //2-2. 가장자리 도착시 성공
        //* 시작부터 1초로 계산
        int test_case = Integer.parseInt(br.readLine());
        for(int T = 1; T <= test_case; T++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());

            //queue 생성
            //불&상근 시작자리 넣기

            //불부터 퍼져야 함
            //다른 큐에 넣기
            // -> 불 큐부터 먼저돌리기 (시간기록)
            // -> 상근 큐 돌리기

            int min = 2147483647;
            boolean success = false;
            char[][] arr = new char[row][col];
            int[][] fireRecord = new int[row][col];
            int[] bx = {0, 1, 0, -1};
            int[] by = {1, 0, -1, 0};
            Queue<Triple> sangQ = new LinkedList<>();
            Queue<Triple> fireQ = new LinkedList<>();

            //input _각 queue에 시작위치 넣기
            for(int i = 0; i < row; i++){
                String token = br.readLine();
                for(int j = 0; j < col; j++){
                    char now = token.charAt(j);
                    if(now == '@'){
                        sangQ.add(new Triple(i, j, 1));
                        fireRecord[i][j] = 1;
                    }else if(now == '*'){
                        fireQ.add(new Triple(i, j, 1));
                    }
                    arr[i][j] = now;
                }
            }

            Triple startCheck = sangQ.peek();
            if(startCheck.x == 0 || startCheck.x == row-1 || startCheck.y == 0 || startCheck.y == col-1){
                System.out.println(1);
                continue;
            }

            //불 bfs
            //이동 불가능한 곳? _방문한곳, 벽, 가장자리
            while(!fireQ.isEmpty()){
                Triple prev = fireQ.poll();
                int ns = prev.s + 1;

                for(int i = 0; i < 4; i++){
                    int nx = prev.x + bx[i];
                    int ny = prev.y + by[i];
                    //가장자리
                    if(nx < 0 || nx >= row || ny < 0 || ny >= col){
                        continue;
                    }
                    //벽이거나 방문한곳
                    if(arr[nx][ny] == '#' || arr[nx][ny] == '*'){
                        continue;
                    }
                    fireQ.add(new Triple(nx, ny, ns));
                    arr[nx][ny] = '*';
                    fireRecord[nx][ny] = ns;
                }
            }

            //상근 bfs
            //이동 불가능한 곳? _방문한곳, 벽, 가장자리, 불
            while(!sangQ.isEmpty()){
                Triple prev = sangQ.poll();
                int ns = prev.s + 1;

                for(int i = 0; i < 4; i++){
                    int nx = prev.x + bx[i];
                    int ny = prev.y + by[i];
                    //가장자리
                    if(nx < 0 || nx >= row || ny < 0 || ny >= col){
                        continue;
                    }
                    //벽이거나 방문한 곳
                    if(arr[nx][ny] == '#' || arr[nx][ny] == '@'){
                        continue;
                    }
                    //불이 '이미 지나간' 곳
                    if(arr[nx][ny] == '*' && fireRecord[nx][ny] <= ns){
                        continue;
                    }
                    //가장자리 도착시 최소시간 기록 _길 못찾은 경우
                    if(nx == 0 || nx == row-1 || ny == 0 || ny == col-1){
                        if(ns < min){
                            success = true;
                            min = ns;
                        }
//                        continue;
                    }
                    sangQ.add(new Triple(nx, ny, ns));
                    arr[nx][ny] = '@';
                }
            }
            if(success){
                System.out.println(min);
            }else{
                System.out.println("IMPOSSIBLE");
            }
        }
    }
    static class Triple{
        int x;
        int y;
        int s;
        Triple(int x, int y, int s){
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }}
