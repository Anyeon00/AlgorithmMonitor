package org.example.algorithmmonitor.src.presentation;


import lombok.RequiredArgsConstructor;
import org.example.algorithmmonitor.src.application.service.ProblemStatusManager;
import org.example.algorithmmonitor.src.application.service.dto.AllInfo;
import org.example.algorithmmonitor.src.application.service.dto.ProblemInfo;
import org.example.algorithmmonitor.src.application.service.dto.UnsolvedInfo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component  //View Component
@RequiredArgsConstructor
public class ConsoleBoard {

    private final ProblemStatusManager problemStatusManager;

    public void printAllInfo() {
        StringBuilder sb = new StringBuilder();
        AllInfo allInfo = problemStatusManager.getAllInfo();
        HashMap<String, Integer> solvedMap = allInfo.solvedNByType();
        HashMap<String, Integer> unsolvedMap = allInfo.unsolvedNByType();

        sb.append("------------- 전체 현황 -------------")
                .append("시도한 문제 수 : " + allInfo.attemptN() + "\n")
                .append("해결한 문제 수 " + allInfo.solvedN() + "\n")
                .append("실패한 문제 수 : " + allInfo.unsolvedN() + "\n");
        for (String type : allInfo.typeList()) {
            int successN = 0;
            int falseN = 0;
            if (solvedMap.containsKey(type)) {
                successN = solvedMap.get(type);
            }
            if (unsolvedMap.containsKey(type)) {
                falseN = unsolvedMap.get(type);
            }
            sb.append("[ " + type + " ]" + "\n")
                    .append("성공 : " + successN + ", ")
                    .append("실패 : " + falseN + "\n");
        }
    }

    public void printUnsolvedInfo() {
        System.out.println("ConsoleStatusBoard.printUnsolved");
        UnsolvedInfo unsolvedInfo = problemStatusManager.getUnsolvedInfo();
        HashMap<String, List<ProblemInfo>> unsolvedMap = unsolvedInfo.unsolvedInfoByType();

        StringBuilder sb = new StringBuilder();
        for (String type : unsolvedMap.keySet()) {
            sb.append("[ " + type + " ]" + "\n");

            List<ProblemInfo> problemList = unsolvedMap.get(type);
            for (ProblemInfo problem : problemList) {
                sb.append("번호 : " + problem.number() + ", ")
                        .append("이름 : " + problem.name() + "\n");
            }
        }
    }
}
