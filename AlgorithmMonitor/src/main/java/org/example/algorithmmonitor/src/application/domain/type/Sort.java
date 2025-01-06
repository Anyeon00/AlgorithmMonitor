package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

public abstract class Sort extends Problem {
    protected Sort() {
        type = Sort.class.getSimpleName();
    }
}
