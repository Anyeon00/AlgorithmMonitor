package org.example.algorithmmonitor.src.application.service.dto;

import java.util.HashMap;
import java.util.List;

public record AllInfo(
        Integer attemptN,
        Integer solvedN,
        Integer unsolvedN,
        List<String> typeList,
        HashMap<String, Integer> solvedNByType,
        HashMap<String, Integer> unsolvedNByType

) {
    public static AllInfo of(Integer attemptN,
                             Integer solvedN,
                             Integer unsolvedN,
                             List<String> typeList,
                             HashMap<String, Integer> solvedNByType,
                             HashMap<String, Integer> unsolvedNByType) {
        return new AllInfo(attemptN, solvedN, unsolvedN, typeList, solvedNByType, unsolvedNByType);
    }
}
