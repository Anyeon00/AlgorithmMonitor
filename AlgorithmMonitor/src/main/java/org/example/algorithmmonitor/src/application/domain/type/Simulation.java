package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

public abstract class Simulation extends Problem {
    protected Simulation() {
        type = Simulation.class.getSimpleName();
    }
}
