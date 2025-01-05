package org.example.algorithmmonitor.src.application.service;


import org.example.algorithmmonitor.src.application.domain.ProblemBox;

public interface ProblemStatusManager {

    // 1. 현황 보기 총 푼 문제, 총 못푼 문제 _전체&유형별
    void getOverallStatus();

    // 2. 유형별로 못 푼 문제 보기
    ProblemBox getUnsolved();

}
