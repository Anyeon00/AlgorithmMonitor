package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

public abstract class DP extends Problem {
    protected DP() {
        type = DP.class.getSimpleName();
    }
}
