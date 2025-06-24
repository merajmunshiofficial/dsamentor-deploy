package com.example.dsa.graph;

import java.util.List;

public class GraphResponse {
    private List<Integer> dfsTraversal;
    private List<Integer> bfsTraversal;
    private boolean isCyclicDFS;
    private boolean isCyclicBFS;
    private boolean isBipartiteDFS;
    private boolean isBipartiteBFS;
    private List<Integer> topologicalSortDFS;
    private List<Integer> topologicalSortKahn;
    private List<Integer> dijkstra;
    private List<Integer> bellmanFord;
    private int[][] floydWarshall;
    private int kruskal;
    private int prim;
    private int numIslands;
    private int[][] floodFill;
    private boolean canFinish;
    private List<Integer> findOrder;
    private int numProvinces;
    private int orangesRotting;
    private int wordLadderLength;
    private int cheapestFlight;
    private List<Integer> articulationPoints;
    private List<List<Integer>> criticalConnections;
    private List<List<Integer>> kosaraju;
    private List<String> disjointSet;
    private Integer resultInt;
    private String resultString;
    private List<Integer> resultList;
    private List<List<Integer>> resultMatrix;
    private List<String> resultStringList;
    private Boolean resultBool;

    public GraphResponse() {}

    // Use static factory methods instead
    public static GraphResponse fromDfsTraversal(List<Integer> result) {
        GraphResponse resp = new GraphResponse();
        resp.setDfsTraversal(result);
        return resp;
    }
    public static GraphResponse fromCriticalConnections(List<List<Integer>> result) {
        GraphResponse resp = new GraphResponse();
        resp.setCriticalConnections(result);
        return resp;
    }
    public static GraphResponse fromDisjointSet(List<String> result) {
        GraphResponse resp = new GraphResponse();
        resp.setDisjointSet(result);
        return resp;
    }

    // Getters and Setters
    public List<Integer> getDfsTraversal() { return dfsTraversal; }
    public void setDfsTraversal(List<Integer> dfsTraversal) { this.dfsTraversal = dfsTraversal; }

    public List<Integer> getBfsTraversal() { return bfsTraversal; }
    public void setBfsTraversal(List<Integer> bfsTraversal) { this.bfsTraversal = bfsTraversal; }

    public boolean getIsCyclicDFS() { return isCyclicDFS; }
    public void setIsCyclicDFS(boolean isCyclicDFS) { this.isCyclicDFS = isCyclicDFS; }

    public boolean getIsCyclicBFS() { return isCyclicBFS; }
    public void setIsCyclicBFS(boolean isCyclicBFS) { this.isCyclicBFS = isCyclicBFS; }

    public boolean getIsBipartiteDFS() { return isBipartiteDFS; }
    public void setIsBipartiteDFS(boolean isBipartiteDFS) { this.isBipartiteDFS = isBipartiteDFS; }

    public boolean getIsBipartiteBFS() { return isBipartiteBFS; }
    public void setIsBipartiteBFS(boolean isBipartiteBFS) { this.isBipartiteBFS = isBipartiteBFS; }

    public List<Integer> getTopologicalSortDFS() { return topologicalSortDFS; }
    public void setTopologicalSortDFS(List<Integer> topologicalSortDFS) { this.topologicalSortDFS = topologicalSortDFS; }

    public List<Integer> getTopologicalSortKahn() { return topologicalSortKahn; }
    public void setTopologicalSortKahn(List<Integer> topologicalSortKahn) { this.topologicalSortKahn = topologicalSortKahn; }

    public List<Integer> getDijkstra() { return dijkstra; }
    public void setDijkstra(List<Integer> dijkstra) { this.dijkstra = dijkstra; }

    public List<Integer> getBellmanFord() { return bellmanFord; }
    public void setBellmanFord(List<Integer> bellmanFord) { this.bellmanFord = bellmanFord; }

    public int[][] getFloydWarshall() { return floydWarshall; }
    public void setFloydWarshall(int[][] floydWarshall) { this.floydWarshall = floydWarshall; }

    public int getKruskal() { return kruskal; }
    public void setKruskal(int kruskal) { this.kruskal = kruskal; }

    public int getPrim() { return prim; }
    public void setPrim(int prim) { this.prim = prim; }

    public int getNumIslands() { return numIslands; }
    public void setNumIslands(int numIslands) { this.numIslands = numIslands; }

    public int[][] getFloodFill() { return floodFill; }
    public void setFloodFill(int[][] floodFill) { this.floodFill = floodFill; }

    public boolean getCanFinish() { return canFinish; }
    public void setCanFinish(boolean canFinish) { this.canFinish = canFinish; }

    public List<Integer> getFindOrder() { return findOrder; }
    public void setFindOrder(List<Integer> findOrder) { this.findOrder = findOrder; }

    public int getNumProvinces() { return numProvinces; }
    public void setNumProvinces(int numProvinces) { this.numProvinces = numProvinces; }

    public int getOrangesRotting() { return orangesRotting; }
    public void setOrangesRotting(int orangesRotting) { this.orangesRotting = orangesRotting; }

    public int getWordLadderLength() { return wordLadderLength; }
    public void setWordLadderLength(int wordLadderLength) { this.wordLadderLength = wordLadderLength; }

    public int getCheapestFlight() { return cheapestFlight; }
    public void setCheapestFlight(int cheapestFlight) { this.cheapestFlight = cheapestFlight; }

    public List<Integer> getArticulationPoints() { return articulationPoints; }
    public void setArticulationPoints(List<Integer> articulationPoints) { this.articulationPoints = articulationPoints; }

    public List<List<Integer>> getCriticalConnections() { return criticalConnections; }
    public void setCriticalConnections(List<List<Integer>> criticalConnections) { this.criticalConnections = criticalConnections; }

    public List<List<Integer>> getKosaraju() { return kosaraju; }
    public void setKosaraju(List<List<Integer>> kosaraju) { this.kosaraju = kosaraju; }

    public List<String> getDisjointSet() { return disjointSet; }
    public void setDisjointSet(List<String> disjointSet) { this.disjointSet = disjointSet; }

    public Integer getResultInt() { return resultInt; }
    public void setResultInt(Integer resultInt) { this.resultInt = resultInt; }

    public String getResultString() { return resultString; }
    public void setResultString(String resultString) { this.resultString = resultString; }

    public List<Integer> getResultList() { return resultList; }
    public void setResultList(List<Integer> resultList) { this.resultList = resultList; }

    public List<List<Integer>> getResultMatrix() { return resultMatrix; }
    public void setResultMatrix(List<List<Integer>> resultMatrix) { this.resultMatrix = resultMatrix; }

    public List<String> getResultStringList() { return resultStringList; }
    public void setResultStringList(List<String> resultStringList) { this.resultStringList = resultStringList; }

    public Boolean getResultBool() { return resultBool; }
    public void setResultBool(Boolean resultBool) { this.resultBool = resultBool; }
}