package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

//플로이드-워셜 알고리즘
public abstract class Floyd_Warshall extends Problem {
    protected Floyd_Warshall() {
        type = Floyd_Warshall.class.getSimpleName();
    }
}
