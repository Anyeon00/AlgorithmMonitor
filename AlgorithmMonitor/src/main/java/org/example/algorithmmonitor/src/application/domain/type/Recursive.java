package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

public abstract class Recursive extends Problem {
    protected Recursive() {
        type = Recursive.class.getSimpleName();
    }
}
