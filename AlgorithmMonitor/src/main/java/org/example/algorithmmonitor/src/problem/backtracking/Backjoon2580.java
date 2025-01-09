package org.example.algorithmmonitor.src.problem.backtracking;
import org.example.algorithmmonitor.src.application.domain.type.BackTracking;

import java.util.*;
import java.io.*;
public class Backjoon2580 extends BackTracking {
    public Backjoon2580() {
        name = "스도쿠";
        result = fail;
    }
    //정답풀이
    //: 빈칸을 찾을때마다, 1~9 중 가능한 수 찾아 넣기
    //이걸 반복문 대신 재귀함수로
    //* https://infodon.tistory.com/64 참고

    //내가 푼 방법
    //: 빈칸을 찾을때마다, 가로검사 (빈칸리스트와 가능한 수 리스트), 세로검사, 박스검사, 이후 리스트에서 꺼내서 삽입
    //
    //=> 쓸데 없는 짓을 너무 많이했다
    //=> 스도쿠를 해봤으면 이런 케이스를 생각 할 수 밖에 없음
    //=> 일부러 확장성있는 알고리즘을 설계했는데
    //=> 코드구조상 큰틀의 시간복잡도는 같다.(빈칸 찾을때마다 다 검사하기)
    //        => (설명이)족같은 문제는 풀지말자

    static int[][] arr = new int[9][9];
    static int emptyN = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //문제
        //스도쿠 채우기
        //input : 9x9 스도쿠 문제 배열 _빈칸:0
        //output :스도쿠 완성

        //풀이
        //첫번째 방법
        //1. 1개 남은 것부터 채우기 _가로,세로,사각형 세트로 다 채울때까지 반복
        //2. 2개 이상 남은 것밖에 존재하지 않은 경우 _존재한다면 다시 생각해야 함

        //두번째 방법
        //1. 각 빈 칸에 들어갈 수 있는 숫자들 구하기
        //2. 백트래킹으로 모든 경우의수(조합) 돌려보기

        //세 번째 방법 _1과 2를 합친 방법 < 채택
        //1. 1개 남은 것 부터 채우기 _가로,세로,사각형 세트로 다 채울때까지 반복
        //2. 2개 이상 남은 경우
        //: 각 빈칸에 들어갈 수 있는 숫자들 구해서, 백트래킹으로 조합 돌려보기
        // -> 우선 1번으로 제출해보기, 실패시 2번 로직 설계 및 구현

        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    emptyN++;
                }
            }
        }

        while (emptyN > 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    //빈칸을 찾았을때
                    if (arr[i][j] > 0) {
                        continue;
                    }
                    //가로체크
                    List<EmptyInfo> rowEmptyList = checkRow(i);
                    if (rowEmptyList.size() == 1) {
                        EmptyInfo info = rowEmptyList.get(0);
                        arr[info.x][info.y] = info.possibleList.get(0);
                        emptyN--;
                    }
                    //세로체크
                    List<EmptyInfo> colEmptyList = checkCol(j);
                    if (colEmptyList.size() == 1) {
                        EmptyInfo info = colEmptyList.get(0);
                        arr[info.x][info.y] = info.possibleList.get(0);
                        emptyN--;
                    }
                    //박스체크
                    List<EmptyInfo> boxEmptyList = checkBox(i, j);
                    if (boxEmptyList.size() == 1) {
                        EmptyInfo info = boxEmptyList.get(0);
                        arr[info.x][info.y] = info.possibleList.get(0);
                        emptyN--;
                    }
                    //체크 후 빈칸정보 리스트 리턴
                    //체크 후 1개 남았으면
                    //체크 후 2개 이상 남았으면

                }
            }
        }
        print();
    }

    static List<EmptyInfo> checkRow(int r) {
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> possibleList = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < 9; i++) {
            if (arr[r][i] == 0) {
                emptyList.add(i);
            } else {
                possibleList.remove(Integer.valueOf(arr[r][i]));
            }
        }

        List<EmptyInfo> infoList = new ArrayList<>();
        for (int n : emptyList) {
            infoList.add(new EmptyInfo(r, n, List.copyOf(possibleList)));
        }
        return infoList;
    }

    static List<EmptyInfo> checkCol(int c) {
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> possibleList = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 0; i < 9; i++) {
            if (arr[i][c] == 0) {
                emptyList.add(i);
            } else {
                possibleList.remove(Integer.valueOf(arr[i][c]));
            }
        }

        List<EmptyInfo> infoList = new ArrayList<>();
        for (int n : emptyList) {
            infoList.add(new EmptyInfo(n, c, List.copyOf(possibleList)));
        }
        return infoList;
    }

    static List<EmptyInfo> checkBox(int r, int c) {

        List<Integer> possibleList = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) {
            for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                possibleList.remove(Integer.valueOf(arr[i][j]));
            }
        }
        List<EmptyInfo> infoList = new ArrayList<>();
        for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) {
            for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
                if (arr[i][j] > 0) {
                    continue;
                }
                infoList.add(new EmptyInfo(i, j, List.copyOf(possibleList)));
            }
        }
        return infoList;
    }

    static class EmptyInfo {
        int x;
        int y;
        List<Integer> possibleList;    //해당 칸에 들어갈 수 있는 수

        EmptyInfo(int x, int y, List<Integer> possibleList) {
            this.x = x;
            this.y = y;
            this.possibleList = possibleList;
        }
    }

    static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
