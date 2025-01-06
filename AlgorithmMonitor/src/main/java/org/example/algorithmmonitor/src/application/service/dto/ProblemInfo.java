package org.example.algorithmmonitor.src.application.service.dto;

public record ProblemInfo(
        String type,
        String number,
        String name,
        Boolean result
) {
}
