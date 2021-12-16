package com.example.demo.graph;

import com.example.demo.dtos.GetDocumentDTO;


import java.util.*;

public class Graph {
    private List<Long> nodeList;
    private Map<Long,List<Long>> edgeList;

    public Graph(List<GetDocumentDTO> getDocumentsDTO){
        nodeList = new ArrayList<>();
        edgeList = new HashMap<>();

        for(GetDocumentDTO getDocumentDTO: getDocumentsDTO){
            nodeList.add(getDocumentDTO.getId());
            edgeList.put(getDocumentDTO.getId(), new ArrayList<>(getDocumentDTO.getReferences()));
        }
    }

    public boolean hasCycle(){
        Map<Long, Boolean> visited = new HashMap<>();

        //initialize
        for(Long node: nodeList){
            visited.put(node, false);
        }

        List<Long> tempListOfNodes = new ArrayList<>(nodeList);
        Queue<Long> queue = new LinkedList<>();

        queue.add(nodeList.get(0));

        while(tempListOfNodes.size() != 0){
            if(queue.isEmpty()){
                //we should start with another node
                queue.add(tempListOfNodes.get(0));
                tempListOfNodes.remove(tempListOfNodes.get(0));
                for(Long node: nodeList){
                    visited.put(node, false);
                }
            }

            Long node = queue.poll();
            tempListOfNodes.remove(node);
            visited.put(node, true);
            for(Long adj: edgeList.get(node)){
                if(visited.get(adj)){
                    return true;
                }
                queue.add(adj);
            }
        }
        return false;
    }

    public List<Long> getNodeList() {
        return nodeList;
    }

    public Map<Long, List<Long>> getEdgeList() {
        return edgeList;
    }
}
