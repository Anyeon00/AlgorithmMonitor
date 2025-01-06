package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

public abstract class Tree extends Problem {
    protected Tree() {
        type = Tree.class.getSimpleName();
    }
}
