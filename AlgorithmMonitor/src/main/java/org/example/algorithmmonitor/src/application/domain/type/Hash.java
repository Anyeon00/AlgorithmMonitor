package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

public abstract class Hash extends Problem {
    protected Hash() {
        type = Hash.class.getSimpleName();
    }
}
