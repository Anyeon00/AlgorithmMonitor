package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

public abstract class Graph extends Problem {
    protected Graph() {
        type = Graph.class.getSimpleName();
    }
}
