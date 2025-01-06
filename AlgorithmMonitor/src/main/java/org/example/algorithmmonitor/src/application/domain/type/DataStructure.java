package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

public abstract class DataStructure extends Problem {
    protected DataStructure() {
        type = DataStructure.class.getSimpleName();
    }
}
