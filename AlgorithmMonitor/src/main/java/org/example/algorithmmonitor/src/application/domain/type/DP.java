package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

public abstract class DP extends Problem {
    protected DP() {
        type = DP.class.getSimpleName();    //근데 이럴거면 그냥 "DP" 이렇게 저장해도 되는거 아닌가
    }
}
