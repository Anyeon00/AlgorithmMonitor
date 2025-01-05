package org.example.algorithmmonitor.src.application.service;


import lombok.RequiredArgsConstructor;
import org.example.algorithmmonitor.src.application.domain.ProblemBox;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProblemStatusManagerImpl implements ProblemStatusManager {

    private final ProblemBox problemBox;

    @Override
    public void getAllInfo() {

    }

    @Override
    public void getUnsolvedInfo() {
    }
}
