package org.example.algorithmmonitor.src.application.service;


public interface ProblemStatusManager {

    //아래 return type, argument 미정

    // 1. 현황 보기 총 푼 문제, 총 못푼 문제 _전체&유형별
    void getAllInfo();

    // 2. 유형별로 못 푼 문제 보기
    void getUnsolvedInfo();

}
