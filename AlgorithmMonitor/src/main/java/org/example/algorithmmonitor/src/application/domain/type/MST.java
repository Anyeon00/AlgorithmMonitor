package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

//최소신장트리
public abstract class MST extends Problem {
    protected MST() {
        type = MST.class.getSimpleName();
    }
}
