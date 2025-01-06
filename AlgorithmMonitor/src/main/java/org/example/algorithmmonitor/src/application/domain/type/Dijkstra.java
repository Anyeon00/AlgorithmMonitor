package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

//다익스트라
public abstract class Dijkstra extends Problem {
    protected Dijkstra() {
        type = Dijkstra.class.getSimpleName();
    }
}
