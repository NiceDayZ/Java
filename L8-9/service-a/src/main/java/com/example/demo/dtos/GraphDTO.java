package com.example.demo.dtos;

import com.example.demo.graph.Edge;
import com.example.demo.graph.Graph;
import com.example.demo.graph.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphDTO {
    private List<Node> nodes;
    private List<Edge> edges;

    public GraphDTO(Graph graph){
        this.nodes = graph.getNodeList().stream().map(node -> new Node(node.toString())).collect(Collectors.toList());

        edges = new ArrayList<>();
        for(Long node: graph.getEdgeList().keySet()){
            for(Long adj: graph.getEdgeList().get(node)){
                edges.add(new Edge(node, adj));
            }
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
