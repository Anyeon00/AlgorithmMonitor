package org.example.algorithmmonitor.src.application.domain.type;

import org.example.algorithmmonitor.src.application.domain.Problem;

//트라이
public abstract class Trie extends Problem {
    protected Trie() {
        type = Trie.class.getSimpleName();
    }
}
