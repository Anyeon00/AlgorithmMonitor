package org.example.algorithmmonitor.src.application.service.dto;

import org.example.algorithmmonitor.src.application.domain.Problem;

public record ProblemInfo(
        String type,
        String number,
        String name,
        Boolean result
) {
    public static ProblemInfo of(Problem problem) {
        return new ProblemInfo(problem.getType(), problem.getNumber(), problem.getName(), problem.getResult());
    }
}
