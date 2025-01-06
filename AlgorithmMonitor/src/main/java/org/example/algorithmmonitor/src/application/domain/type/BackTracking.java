package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

//백트래킹
public abstract class BackTracking extends Problem {
    protected BackTracking() {
        type = BackTracking.class.getSimpleName();
    }
}
