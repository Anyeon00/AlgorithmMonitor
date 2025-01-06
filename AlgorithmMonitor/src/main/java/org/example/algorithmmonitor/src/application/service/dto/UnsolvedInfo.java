package org.example.algorithmmonitor.src.application.service.dto;

import java.util.HashMap;

public record UnsolvedInfo(
        HashMap<String, ProblemInfo> unsolvedInfoByType
) {
}
