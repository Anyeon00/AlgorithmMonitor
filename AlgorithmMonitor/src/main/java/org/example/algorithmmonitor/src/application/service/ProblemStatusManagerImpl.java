package org.example.algorithmmonitor.src.application.service;


import lombok.RequiredArgsConstructor;
import org.example.algorithmmonitor.src.application.domain.Problem;
import org.example.algorithmmonitor.src.application.domain.ProblemBox;
import org.example.algorithmmonitor.src.application.service.dto.AllInfo;
import org.example.algorithmmonitor.src.application.service.dto.ProblemInfo;
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
                problemBox.getMapByType().keySet().stream().toList(),
                getCountMapByType(problemBox.getSolvedMapByType()),
                getCountMapByType(problemBox.getUnsolvedMapByType()));
    }

    @Override
    public UnsolvedInfo getUnsolvedInfo() {
        HashMap<String, List<Problem>> unsolvedMapByType = problemBox.getUnsolvedMapByType();

        HashMap<String, List<ProblemInfo>> unsolvedInfo = new HashMap<>();
        for (String type : unsolvedMapByType.keySet()) {
            List<Problem> problemList = unsolvedMapByType.get(type);
            List<ProblemInfo> infoList = problemList.stream().map(ProblemInfo::of).toList();
            unsolvedInfo.put(type, infoList);
        }
        return UnsolvedInfo.of(unsolvedInfo);
    }

    private static HashMap<String, Integer> getCountMapByType(HashMap<String, List<Problem>> problemMap) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String type : problemMap.keySet()) {
            countMap.put(type, problemMap.get(type).size());
        }
        return countMap;
    }
}
