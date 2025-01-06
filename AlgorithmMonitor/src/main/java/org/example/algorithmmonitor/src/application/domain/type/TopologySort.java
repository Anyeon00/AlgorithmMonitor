package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

//위상정렬
public abstract class TopologySort extends Problem {
    protected TopologySort() {
        type = TopologySort.class.getSimpleName();
    }
}
