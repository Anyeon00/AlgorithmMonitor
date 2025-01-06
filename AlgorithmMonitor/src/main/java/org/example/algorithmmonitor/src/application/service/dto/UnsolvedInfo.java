package org.example.algorithmmonitor.src.application.service.dto;

import java.util.HashMap;
import java.util.List;

public record UnsolvedInfo(
        HashMap<String, List<ProblemInfo>> unsolvedInfoByType
) {
    public static UnsolvedInfo of(HashMap<String, List<ProblemInfo>> unsolvedInfoByType) {
        return new UnsolvedInfo(unsolvedInfoByType);
    }
}
