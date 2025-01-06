package org.example.algorithmmonitor.src.application.service;


import lombok.RequiredArgsConstructor;
import org.example.algorithmmonitor.src.application.domain.Problem;
import org.example.algorithmmonitor.src.application.domain.ProblemBox;
import org.example.algorithmmonitor.src.application.service.dto.AllInfo;
import org.example.algorithmmonitor.src.application.service.dto.UnsolvedInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProblemStatusManagerImpl implements ProblemStatusManager {

    private final ProblemBox problemBox;

    @Override
    public AllInfo getAllInfo() {

        return AllInfo.of(
                problemBox.size(),
                problemBox.getSolved().size(),
                problemBox.getUnsolved().size(),
                getCountMapByType(problemBox.getSolvedMapByType()),
                getCountMapByType(problemBox.getUnsolvedMapByType()));
    }

    private HashMap<String, Integer> getCountMapByType(HashMap<String, Problem> problemMap) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String type : problemMap.keySet()) {
            int size = problemBox.findByType(type).size();
            countMap.put(type, size);
        }
        return countMap;
    }

    @Override
    public UnsolvedInfo getUnsolvedInfo() {
        return null;
    }
}
