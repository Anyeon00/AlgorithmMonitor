package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

public abstract class Greedy extends Problem {
    protected Greedy() {
        type = Greedy.class.getSimpleName();
    }
}
