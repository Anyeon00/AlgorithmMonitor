package org.example.algorithmmonitor.src.presentation;


import lombok.RequiredArgsConstructor;
import org.example.algorithmmonitor.src.application.service.ProblemStatusManager;
import org.springframework.stereotype.Component;

@Component  //View Component
@RequiredArgsConstructor
public class ConsoleStatusBoard {

    private final ProblemStatusManager problemStatusManager;

    public void printAllInfo() {
        problemStatusManager.getAllInfo();
        System.out.println("ConsoleStatusBoard.printOverallStatus");
//        problemStatusManager.presentOverallStatus();
    }

    public void printUnSolvedInfo() {
        problemStatusManager.getUnsolvedInfo();
        System.out.println("ConsoleStatusBoard.printUnsolved");
//        List<ProblemBox> problemBoxList = problemStatusManager.presentUnsolved();
//        problemList.stream().forEach(System.out::println);
    }
}
