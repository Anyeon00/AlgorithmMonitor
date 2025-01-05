package org.example.algorithmmonitor.src.presentation;


import lombok.RequiredArgsConstructor;
import org.example.algorithmmonitor.src.application.service.ProblemStatusManager;
import org.springframework.stereotype.Component;

@Component  //View Component
@RequiredArgsConstructor
public class ConsoleStatusBoard {

    private final ProblemStatusManager problemStatusManager;

    public void printOverallStatus() {
        System.out.println("ConsoleStatusBoard.printOverallStatus");
        problemStatusManager.presentOverallStatus();
    }

    public void printUnsolved() {
        System.out.println("ConsoleStatusBoard.printUnsolved");
//        List<ProblemBox> problemBoxList = problemStatusManager.presentUnsolved();
//        problemList.stream().forEach(System.out::println);
    }
}
