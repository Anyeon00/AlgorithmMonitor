package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

//문자열 검색 알고리즘
public abstract class KMP extends Problem {
    protected KMP() {
        type = KMP.class.getSimpleName();
    }
}
