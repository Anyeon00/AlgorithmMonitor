package org.example.algorithmmonitor.src.presentation;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.algorithmmonitor.src.application.service.ProblemStatusManager;
import org.example.algorithmmonitor.src.application.service.dto.AllInfo;
import org.example.algorithmmonitor.src.application.service.dto.ProblemInfo;
import org.example.algorithmmonitor.src.application.service.dto.UnsolvedInfo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@Component  //View Component
@RequiredArgsConstructor
public class ConsoleBoard {

    private final ProblemStatusManager problemStatusManager;

    @PostConstruct
    private void main() {
        System.out.println("[알고리즘 현황 게시판]");
        printAllInfo();
        System.out.println("틀린 문제를 확인하려면 엔터를 눌러주세요. (작동하지 않을 시 한 번 더 눌러주세요)");
        new Scanner(System.in).nextLine();
        printUnsolvedInfo();
    }

    public void printAllInfo() {
        StringBuilder sb = new StringBuilder();
        AllInfo allInfo = problemStatusManager.getAllInfo();
        HashMap<String, Integer> solvedMap = allInfo.solvedNByType();
        HashMap<String, Integer> unsolvedMap = allInfo.unsolvedNByType();

        sb.append("------------- 전체 현황 -------------\n")
                .append("시도한 문제 수 : " + allInfo.attemptN() + "\n")
                .append("해결한 문제 수 : " + allInfo.solvedN() + "\n")
                .append("실패한 문제 수 : " + allInfo.unsolvedN() + "\n\n");
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
        System.out.println(sb);
    }

    public void printUnsolvedInfo() {
        System.out.println("------------- 틀린 문제 -------------");
        UnsolvedInfo unsolvedInfo = problemStatusManager.getUnsolvedInfo();
        HashMap<String, List<ProblemInfo>> unsolvedMap = unsolvedInfo.unsolvedInfoByType();

        StringBuilder sb = new StringBuilder();
        for (String type : unsolvedMap.keySet()) {
            List<ProblemInfo> problemList = unsolvedMap.get(type);

            sb.append("[ " + type + " ] 문제 수 : " + problemList.size() + "\n");
            for (ProblemInfo problem : problemList) {
                sb.append(problem.number() + "  " + problem.name() + "\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
