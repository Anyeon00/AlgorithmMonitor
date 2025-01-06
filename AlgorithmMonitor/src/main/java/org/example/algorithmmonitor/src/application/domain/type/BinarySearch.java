package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

//이분탐색
public abstract class BinarySearch extends Problem {
    protected BinarySearch() {
        type = BinarySearch.class.getSimpleName();
    }
}
