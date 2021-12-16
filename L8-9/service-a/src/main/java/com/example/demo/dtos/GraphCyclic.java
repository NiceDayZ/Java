package com.example.demo.dtos;

import com.example.demo.graph.Graph;

public class GraphCyclic {
    private boolean cyclic;

    public GraphCyclic(Graph graph){
        this.cyclic = graph.hasCycle();
    }

    public boolean isCyclic() {
        return cyclic;
    }

}
