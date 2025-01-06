package org.example.algorithmmonitor.src.presentation;


import lombok.RequiredArgsConstructor;
import org.example.algorithmmonitor.src.application.service.ProblemStatusManager;
import org.example.algorithmmonitor.src.application.service.dto.AllInfo;
import org.example.algorithmmonitor.src.application.service.dto.UnsolvedInfo;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component  //View Component
@RequiredArgsConstructor
public class ConsoleBoard {

    private final ProblemStatusManager problemStatusManager;

    public void printAllInfo() {
        System.out.println("ConsoleStatusBoard.printOverallStatus");
        AllInfo allInfo = problemStatusManager.getAllInfo();
        HashMap<String, Integer> solvedMap = allInfo.solvedNByType();
        HashMap<String, Integer> unsolvedMap = allInfo.unsolvedNByType();

        StringBuilder sb = new StringBuilder();
        sb.append("시도한 문제 수 : " + allInfo.attemptN() + "\n")
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

    public void printUnSolvedInfo() {
        System.out.println("ConsoleStatusBoard.printUnsolved");
        UnsolvedInfo unsolvedInfo = problemStatusManager.getUnsolvedInfo();

//        List<ProblemBox> problemBoxList = problemStatusManager.presentUnsolved();
//        problemList.stream().forEach(System.out::println);
    }

}
