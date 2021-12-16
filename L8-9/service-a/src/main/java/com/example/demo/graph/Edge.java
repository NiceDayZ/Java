package com.example.demo.graph;

public class Edge {
    private Long from;
    private Long to;

    public Edge(Long nodeA, Long nodeB) {
        this.from = nodeA;
        this.to = nodeB;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }
}
