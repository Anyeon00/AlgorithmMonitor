package org.example.algorithmmonitor.src.application.service.dto;

import java.util.HashMap;

public record AllInfo(
        Integer attemptN,
        Integer solvedN,
        Integer unsolvedN,
        HashMap<String, Integer> solvedNByType,
        HashMap<String, Integer> unsolvedNByType

) {
    public static AllInfo of(Integer attemptN,
                             Integer solvedN,
                             Integer unsolvedN,
                             HashMap<String, Integer> solvedNByType,
                             HashMap<String, Integer> unsolvedNByType) {
        return new AllInfo(attemptN, solvedN, unsolvedN, solvedNByType, unsolvedNByType);
    }
}
